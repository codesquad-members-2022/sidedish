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
    private let networkManger = NetworkManager(session: .shared)
    
    private var collectionViewLayout: UICollectionViewLayout {
        let itemHeight: CGFloat = 130.0
        let headerHeigth: CGFloat = 130.0
        
        let layout = UICollectionViewFlowLayout()
        let itemSize = CGSize(width: view.frame.width, height: itemHeight)
        layout.headerReferenceSize = CGSize(width: view.frame.width, height: headerHeigth)
        layout.itemSize = itemSize
        return layout
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setUpView()
        getSideDishInfo()
        
        guard let navigationBar = self.navigationController?.navigationBar else { return }
        
        let appearance = UINavigationBarAppearance()
        appearance.configureWithOpaqueBackground()
        appearance.backgroundColor = .systemBackground
        
        navigationBar.standardAppearance = appearance
        navigationBar.scrollEdgeAppearance = navigationBar.standardAppearance
    }
    
    private func setUpView() {
        configureView()
        collectionViewDelegate.delegate = self
        
        view.addSubview(orderingCollectionView)
        configureOrderingCollectionView()
        layoutOrderingCollectionView()
        
    }
    
    private func configureView() {
        title = Constant.Title.orderingViewController
        view.backgroundColor = .systemBackground
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
        networkManger.request(endpoint: EndPointCase.get(category: .main).endpoint) { [weak self] (result: Result<SideDishInfo?, NetworkError>) in
            guard let self = self else { return }
            switch result {
            case .success(let success):
                guard let menus = success?.body else { return }
                self.collectionViewDataSource.fetch(dishes: menus)
                self.setHeaderViewDelegate()
                
                DispatchQueue.main.async {
                    self.orderingCollectionView.reloadData()
                }
                
            case .failure(let failure):
                os_log(.error, "\(failure.localizedDescription)")
            }
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
        guard let menu = collectionViewDataSource.getSelectedItem(at: index.item) else { return }
        let detailVC = DetailViewController(menu: menu)
        navigationController?.pushViewController(detailVC, animated: true)
        
        networkManger.request(endpoint: EndPointCase.getDetail(hash: menu.detail_hash).endpoint) { (result: Result<DetailDishInfo?, NetworkError>) in
            switch result {
            case .success(let data):
                guard let menuDetail = data?.data else { return }
                DispatchQueue.main.async {
                    detailVC.setMenuDetail(menuDetail: menuDetail)
                }
            case .failure(let failure):
                os_log(.error, "\(failure.localizedDescription)")
            }
        }
    }
}

extension OrderingViewController: SectionHeaderViewDelegate {
    
    func didTapSectionHeader(section: SectionHeaderView, sectionNumber: Int) {
        let count = self.orderingCollectionView.numberOfItems(inSection: sectionNumber)
        section.setCountLabel(count: count)
    }
}
