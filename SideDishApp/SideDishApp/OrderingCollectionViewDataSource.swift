//
//  OrderingCollectionViewDataSource.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingCollectionViewDataSource: NSObject, UICollectionViewDataSource {
    
    private var dishes: [String] = ["a", "b", "c"]
    
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
