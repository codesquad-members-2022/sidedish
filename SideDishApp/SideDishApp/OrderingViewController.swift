//
//  OrderingViewController.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingViewController: UIViewController {
    
    private var orderingCollectionView = UICollectionView(frame: .zero, collectionViewLayout: UICollectionViewLayout())
    private var collectionViewDataSource = OrderingCollectionViewDataSource()
    
    private var collectionViewLayout: UICollectionViewLayout {
        let layout = UICollectionViewFlowLayout()
        let itemSize = CGSize(width: view.frame.width, height: 130)
        layout.itemSize = itemSize
        return layout
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setUpView()
    }
    
    private func setUpView() {
        configureView()
        
        view.addSubview(orderingCollectionView)
        configureOrderingCollectionView()
        layoutOrderingCollectionView()
    }
    
    private func configureView() {
        title = "ordering"
        view.backgroundColor = .systemBackground
    }
    
    private func configureOrderingCollectionView() {
        orderingCollectionView.register(OrderingCollectionViewCell.self, forCellWithReuseIdentifier: Constant.Identifier.orderingViewCell) //classForCoder가 무엇?
        orderingCollectionView.dataSource = collectionViewDataSource
        
        orderingCollectionView.collectionViewLayout = collectionViewLayout
        orderingCollectionView.backgroundColor = .gray
    }
}

// MARK: - View Layouts

extension OrderingViewController {
    private func layoutOrderingCollectionView() {
        orderingCollectionView.translatesAutoresizingMaskIntoConstraints = false
        orderingCollectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        orderingCollectionView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        orderingCollectionView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        orderingCollectionView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor).isActive = true
    }
}
