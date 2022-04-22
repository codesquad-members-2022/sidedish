//
//  HomeView.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import Foundation
import UIKit

class HomeView: UIView{
    private var collectionView: UICollectionView?
    
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
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .vertical
        collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        collectionView?.register(DishCollectionViewCell.self, forCellWithReuseIdentifier: DishCollectionViewCell.identifier)
        collectionView?.register(DishComentHeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: DishComentHeaderView.identifier)
        collectionView?.alwaysBounceVertical = true
        guard let collectionView = collectionView else {
            return
        }
        layout.headerReferenceSize = CGSize(width: collectionView.frame.width, height: 100)
        addSubview(collectionView)
        setUIConstraint()
    }
    
    private func setUIConstraint(){
        guard let collectionView = collectionView else {
            return
        }
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        collectionView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor, constant: 0).isActive = true
        collectionView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor, constant: 15).isActive = true
        collectionView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor, constant: -15).isActive = true
        collectionView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor, constant: -10).isActive = true
    }
    
    func setCollectionViewModel(viewModel: DishCollectionWrapper){
        collectionView?.delegate = viewModel
        collectionView?.dataSource = viewModel
    }
}
