//
//  MainViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//
import Combine
import SnapKit
import UIKit

class MainViewController: UIViewController {
    private let underLineView: UIView = {
        let view = UIView()
        view.backgroundColor = .grey3
        return view
    }()
    
    private let collectionView: UICollectionView = {
        let flowLayout = UICollectionViewFlowLayout()
        flowLayout.scrollDirection = .vertical
        flowLayout.sectionInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
        flowLayout.headerReferenceSize = CGSize(width: 0, height: 110)
        flowLayout.minimumInteritemSpacing = 0
        flowLayout.minimumLineSpacing = 0
        let collectionView = UICollectionView(frame: .zero, collectionViewLayout: flowLayout)
        collectionView.register(CustomCollectionCell.self, forCellWithReuseIdentifier: CustomCollectionCell.identifier)
        collectionView.register(CollectionViewHeader.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: CollectionViewHeader.identifier)
        return collectionView
    }()
    
    private let loginOutButton: UIButton = {
        let button = UIButton()
        button.setTitle("Logout", for: .normal)
        button.setTitleColor(UIColor.systemBlue, for: .normal)
        return button
    }()
    
    private let model: MainViewModelProtocol
    
    private var cancellables = Set<AnyCancellable>()
    
    init(viewModel: MainViewModelProtocol) {
        self.model = viewModel
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    deinit {
        Log.debug("DeInit MainViewController")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
        makeNavigationButtons()
        model.action().viewDidLoad.send()
    }
    
    private func bind() {
        collectionView.delegate = self
        collectionView.dataSource = self
        
        model.state().userData
            .receive(on: DispatchQueue.main)
            .sink { [weak self] user in
                self?.title = "\(user.name)님 안녕하세요"
            }.store(in: &cancellables)

        model.state().loadedData
            .receive(on: DispatchQueue.main)
            .sink { [weak self] type in
                self?.collectionView.reloadSections(IndexSet(integer: type.index))
            }.store(in: &cancellables)

        model.state().loadedImage
            .receive(on: DispatchQueue.main)
            .sink { [weak self] indexPath in
                self?.collectionView.reloadItems(at: [indexPath])
            }.store(in: &cancellables)

        loginOutButton.publisher(for: .touchUpInside)
            .sink(receiveValue: model.action().tappedLogoutButton.send(_:))
            .store(in: &cancellables)
        
        model.state().presentLoginPage
            .map { .login }
            .sink { [weak self] state in self?.switchRootWindowState(state) }
            .store(in: &cancellables)
    }
    
    private func attritbute() {
        title = "Ordering"
        view.backgroundColor = .white
    }
    
    private func layout() {
        view.addSubview(collectionView)
        view.addSubview(underLineView)
        
        underLineView.snp.makeConstraints {
            $0.top.leading.trailing.equalTo(view.safeAreaLayoutGuide)
            $0.height.equalTo(1)
        }
        
        collectionView.snp.makeConstraints {
            $0.top.equalTo(view.safeAreaLayoutGuide)
            $0.leading.trailing.bottom.equalToSuperview()
        }
    }
    
    private func makeNavigationButtons() {
        navigationItem.backButtonTitle = "뒤로"
        navigationItem.rightBarButtonItem = UIBarButtonItem(customView: loginOutButton)
    }
}

extension MainViewController: UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout {
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        Menu.categoryCount
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        guard let menuType = Menu.Category(rawValue: section) else {
            return 8
        }
        return model.getMenuCount(menuType)
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: CustomCollectionCell.identifier, for: indexPath) as? CustomCollectionCell else {
            return UICollectionViewCell()
        }

        DispatchQueue.main.async {
            guard let menuData = self.model[indexPath] else {
                return
            }
              
            cell.changeThumbnail(imageUrl: self.model.getThumbnailUrl(indexPath: indexPath))
            cell.changeTitleLabel(text: menuData.title)
            cell.changeDescriptionLabel(text: menuData.description)
            cell.changePriceLabel(price: menuData.price)
            cell.changeSalePriceLabel(price: menuData.salePrice)
            cell.changeSaleBadge(menuData.badge)
            cell.changeBackgroundColor(indexPath.section.isMultiple(of: 2) ? .white : .grey4)
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if kind == UICollectionView.elementKindSectionHeader {
            guard let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: CollectionViewHeader.identifier, for: indexPath) as? CollectionViewHeader, let sideMenu = Menu.Category(rawValue: indexPath.section) else {
                return UICollectionReusableView()
            }
            headerView.changeTitle(text: sideMenu.headerTitle)
            headerView.changeBackgroundColor(indexPath.section.isMultiple(of: 2) ? .white : .grey4)
            return headerView
        }
        return UICollectionReusableView()
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let size = CGSize(width: collectionView.frame.width, height: 138)
        return size
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let menu = model[indexPath] else {
            return
        }
        let detailViewController = MenuDetailViewController(model: MenuDetailViewModel(menu: menu, sidedishRepository: SidedishRepositoryImpl(), resourceRepository: ResourceRepositoryImpl()))
        navigationController?.pushViewController(detailViewController, animated: true)
    }
}
