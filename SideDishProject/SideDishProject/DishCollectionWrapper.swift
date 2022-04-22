//
//  DishCollectionViewModel.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import Foundation
import UIKit

class DishCollectionWrapper: NSObject{
    
    private var dishes: [DishCategory : [Product]] = [:]
    func setDishes(dishes: [DishCategory : [Product]]){
        self.dishes = dishes
    }
}
extension DishCollectionWrapper: UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout{
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return dishes.count
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return dishes[DishCategory.allCases[section]]?.count ?? 0
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: DishCollectionViewCell.identifier, for: indexPath) as? DishCollectionViewCell else { return UICollectionViewCell()}
        guard let product = dishes[DishCategory.allCases[indexPath.section]]?[indexPath.item] else { return cell }
        cell.setProperties(product: product)
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if (kind == UICollectionView.elementKindSectionHeader) {
            // Create Header
            
            guard let headerView : DishComentHeaderView = collectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: DishComentHeaderView.identifier, for: indexPath) as? DishComentHeaderView else { return UICollectionReusableView() }
            return headerView
        }
        return UICollectionReusableView()
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 125)
    }
    
    func collectionView(collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 100)  // Header size
    }
    
}
