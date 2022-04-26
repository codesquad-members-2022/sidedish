//
//  MainViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//
import Combine
import UIKit

class MainViewController: UIViewController {
    private let model: MainViewModelProtocol = MainViewModel()
    private var cancellables = Set<AnyCancellable>()
    
    private let underLineView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
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
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.register(CustomCollectionCell.self, forCellWithReuseIdentifier: CustomCollectionCell.identifier)
        collectionView.register(CollectionViewHeader.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: CollectionViewHeader.identifier)
        return collectionView
    }()
    
    private let loginButton: UIButton = {
        let button = UIButton()
        button.setTitle("Logout", for: .normal)
        button.setTitleColor(UIColor.systemBlue, for: .normal)
        return button
    }()
    
    deinit {
        Log.debug("DeInit MainViewController")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
        makeNavigationButtons()
        model.action.viewDidLoad.send()
    }
    
    private func bind() {
        collectionView.delegate = self
        collectionView.dataSource = self
        
        model.state.userData
            .receive(on: DispatchQueue.main)
            .sink { [weak self] user in
                self?.title = "\(user.name)님 안녕하세요"
            }.store(in: &cancellables)

        model.state.loadedData
            .receive(on: DispatchQueue.main)
            .sink { [weak self] type in
                self?.collectionView.reloadSections(IndexSet(integer: type.index))
            }.store(in: &cancellables)

        model.state.loadedImage
            .receive(on: DispatchQueue.main)
            .sink { [weak self] indexPath in
                self?.collectionView.reloadItems(at: [indexPath])
            }.store(in: &cancellables)

        loginButton.publisher(for: .touchUpInside)
            .sink(receiveValue: model.action.tappedLogoutButton.send(_:))
            .store(in: &cancellables)
        
        model.state.presentLoginPage
            .sink {
                RootWindow.shared?.switchRootWindowState.send(.login)
            }
            .store(in: &cancellables)
    }
    
    private func attritbute() {
        title = "Ordering"
        view.backgroundColor = .white
    }
    
    private func layout() {
        view.addSubview(collectionView)
        view.addSubview(underLineView)
        
        NSLayoutConstraint.activate([
            underLineView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            underLineView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor),
            underLineView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor),
            underLineView.heightAnchor.constraint(equalToConstant: 1),
            
            collectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            collectionView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            collectionView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            collectionView.trailingAnchor.constraint(equalTo: view.trailingAnchor)
        ])
    }
    
    private func makeNavigationButtons() {
        navigationItem.backButtonTitle = "뒤로"
        navigationItem.rightBarButtonItem = UIBarButtonItem(customView: loginButton)
    }
}

extension MainViewController: UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout {
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        Sidedish.Menu.allCases.count
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        guard let menuType = Sidedish.Menu(rawValue: section) else {
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
            cell.changePriceLabel(text: menuData.price)
            cell.changeSalePriceLabel(text: menuData.salePrice ?? "")
            cell.changeSaleBadge(menuData.badge)
            cell.changeBackgroundColor(indexPath.section.isMultiple(of: 2) ? .white : .grey4)
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if kind == UICollectionView.elementKindSectionHeader {
            guard let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: CollectionViewHeader.identifier, for: indexPath) as? CollectionViewHeader, let sideMenu = Sidedish.Menu(rawValue: indexPath.section) else {
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
        let detailViewController = MenuDetailViewController(model: MenuDetailViewModel(menu: menu))
        navigationController?.pushViewController(detailViewController, animated: true)
    }
}
