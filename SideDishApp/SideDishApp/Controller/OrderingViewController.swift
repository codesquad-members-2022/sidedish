//
//  OrderingViewController.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit
import OSLog

final class OrderingViewController: UIViewController {
    
    private var orderingCollectionView = UICollectionView(frame: .zero, collectionViewLayout: UICollectionViewLayout())
    private var collectionViewDataSource = OrderingCollectionViewDataSource()
    private var collectionViewDelegate = OrderingCollectionViewDelegate()
    private var networkRepository: NetworkRepository?
    
    private var collectionViewLayout: UICollectionViewLayout {
        let layout = UICollectionViewFlowLayout()
        let itemSize = CGSize(width: view.frame.width, height: 130)
        let headerSize = CGSize(width: view.frame.width, height: 130)
        layout.headerReferenceSize = headerSize
        layout.itemSize = itemSize
        return layout
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setUpView()
        setUpDelegate()
        setUpNavigaionBar()
        getSideDishInfo()
    }
    
    private func setUpView() {
        configureView()
        configureOrderingCollectionView()
        layoutOrderingCollectionView()
    }
    
    private func setUpDelegate() {
        collectionViewDelegate.delegate = self
    }
    
    private func configureView() {
        view.addSubview(orderingCollectionView)
        title = Constant.ViewControllerTitle.ordering
        view.backgroundColor = .systemBackground
    }
    
    private func setUpNavigaionBar() {
        guard let navigationBar = self.navigationController?.navigationBar else { return }
        
        let appearance = UINavigationBarAppearance()
        appearance.configureWithOpaqueBackground()
        appearance.backgroundColor = .systemBackground
        
        navigationBar.standardAppearance = appearance
        navigationBar.scrollEdgeAppearance = navigationBar.standardAppearance
    }
    
    private func configureOrderingCollectionView() {
        orderingCollectionView.register(OrderingCollectionViewCell.self, forCellWithReuseIdentifier: Constant.Identifier.orderingViewCell)
        orderingCollectionView.register(SectionHeaderView.self,
                                        forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader,
                                        withReuseIdentifier: Constant.Identifier.sectionHeaderView )
        
        orderingCollectionView.dataSource = collectionViewDataSource
        orderingCollectionView.delegate = collectionViewDelegate
        
        orderingCollectionView.collectionViewLayout = collectionViewLayout
        orderingCollectionView.backgroundColor = .systemBackground
    }
    
    private func getSideDishInfo() {
        Category.allCases.forEach { category in
            // 특정 NetworkManager를 Repository에 주입함.
            networkRepository = NetworkRepository(networkManager: NetworkManager(session: .shared))
            
            networkRepository?.fetchData(endpoint: EndPointCase.get(category: category).endpoint,
                                         decodeType: SideDishInfo.self,
                                         onCompleted: { [weak self] mainDishInfo in
                // Repository에 요청한 Data에서 필요한 부분으로 로직을 처리함.
                guard let self = self,
                      let menus = mainDishInfo?.body else { return }
                
                // View에 model을 넘김
                self.collectionViewDataSource.fetch(menus: menus, category: category)
                self.setHeaderViewDelegate()
                
                // View 업데이트
                DispatchQueue.main.async {
                    guard let sectionIndex = Category.allCases.firstIndex(of: category) else { return }
                    switch category {
                    case .main:
                        self.orderingCollectionView.reloadSections(IndexSet(integer: sectionIndex))
                    case .soup:
                        self.orderingCollectionView.reloadSections(IndexSet(integer: sectionIndex))
                    case .side:
                        self.orderingCollectionView.reloadSections(IndexSet(integer: sectionIndex))
                    }
                }
            }
        )
    }
}
    
    private func setHeaderViewDelegate() {
        DispatchQueue.main.async { [weak self] in
            guard let self = self else { return }
            let countOfSection = self.orderingCollectionView.numberOfSections
            
            for sectionIndex in 0..<countOfSection {
                guard let sectionHeaderView = self.orderingCollectionView.supplementaryView(
                    forElementKind: UICollectionView.elementKindSectionHeader,
                    at: IndexPath(row: 0, section: sectionIndex)) as? SectionHeaderView else { return }
                sectionHeaderView.delegate = self
            }
        }
    }
}

// MARK: - View Layout

extension OrderingViewController {
    private func layoutOrderingCollectionView() {
        orderingCollectionView.translatesAutoresizingMaskIntoConstraints = false
        orderingCollectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        orderingCollectionView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        orderingCollectionView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        orderingCollectionView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor).isActive = true
    }
}

extension OrderingViewController: CollectionViewSelectionDetectable {
    func didSelectItem(index: IndexPath) {
        networkRepository = NetworkRepository(networkManager: NetworkManager(session: .shared))
        
        guard let menu = collectionViewDataSource.getSelectedItem(at: index) else { return }
        let detailVC = DetailViewController(menu: menu)
        navigationController?.pushViewController(detailVC, animated: true)
        
        networkRepository?.fetchData(endpoint: EndPointCase.getDetail(hash: menu.detail_hash).endpoint,
                                     decodeType: DetailDishInfo.self,
                                     onCompleted: { detailDishInfo in
            guard let detailOfMenu = detailDishInfo?.data else { return }
            DispatchQueue.main.async {
                detailVC.setMenuDetail(menuDetail: detailOfMenu)
                }
            }
        )
    }
}

extension OrderingViewController: SectionHeaderViewDelegate {
    func didTapSectionHeader(section: SectionHeaderView, sectionNumber: Int) {
        let count = self.orderingCollectionView.numberOfItems(inSection: sectionNumber)
        section.setCountLabel(count: count)
    }
}
