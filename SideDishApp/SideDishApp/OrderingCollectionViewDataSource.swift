//
//  OrderingCollectionViewDataSource.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingCollectionViewDataSource: NSObject, UICollectionViewDataSource {
    
    private var dishes: [String] = ["모두가 좋아하는 든든한 메인 요리", "b", "c"]
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
    }
    
    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String,
                        at indexPath: IndexPath) -> UICollectionReusableView {
        
        guard let supplementaryView = collectionView.dequeueReusableSupplementaryView(
            ofKind: kind,
            withReuseIdentifier: Constant.Identifier.sectionHeaderView,
            for: indexPath
        ) as? SectionHeaderView else { return UICollectionReusableView() }
        
        supplementaryView.setTitle(title: dishes[indexPath.section])
        return supplementaryView
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return dishes.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: Constant.Identifier.orderingViewCell, for: indexPath) as? OrderingCollectionViewCell else {
            return UICollectionViewCell()
        }
        
        //        cell.setImage(url:) 등등 cell에 대한 설정
        //        cell.backgroundColor = .blue
        //        cell.setLabel(text: dishes[indexPath.item])
        return cell
    }
    
}
