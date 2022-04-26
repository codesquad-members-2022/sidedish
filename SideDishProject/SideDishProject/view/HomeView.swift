//
//  HomeView.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import UIKit

final class HomeView: UIView{
    private let flowLayout = UICollectionViewFlowLayout()
    private lazy var collectionView = UICollectionView(frame: .zero, collectionViewLayout: self.flowLayout)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupUI()
    }
    
    private func setupUI(){
        backgroundColor = .white
        flowLayout.scrollDirection = .vertical
        collectionView.register(DishCollectionViewCell.self, forCellWithReuseIdentifier: DishCollectionViewCell.identifier)
        collectionView.register(DishCommentHeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: DishCommentHeaderView.identifier)
        collectionView.alwaysBounceVertical = true
        flowLayout.headerReferenceSize = CGSize(width: collectionView.frame.width, height: 120)
        addSubview(collectionView)
        setUIConstraint()
    }
    
    private func setUIConstraint(){
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor, constant: 0).isActive = true
        collectionView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor, constant: 15).isActive = true
        collectionView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor, constant: -15).isActive = true
        collectionView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor, constant: -10).isActive = true
    }
    
    func setCollectionViewModel(dataSource: UICollectionViewDataSource, delegate: UICollectionViewDelegate&UICollectionViewDelegateFlowLayout){
        collectionView.dataSource = dataSource
        collectionView.delegate = delegate
    }
}
