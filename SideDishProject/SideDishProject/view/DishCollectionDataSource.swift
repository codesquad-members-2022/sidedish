//
//  DishCollectionViewModel.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import UIKit

final class DishCollectionDataSource: NSObject{
    private var dishes: [DishCategory : [Product]] = [:]
    private var dishComments: [String] = []
    private var dishImages: [DishCategory : [Data]] = [:]
    func setDishes(dishes: [DishCategory : [Product]]){
        self.dishes = dishes
    }
    
    func setDishImages(images: [DishCategory : [Data]]){
        self.dishImages = images
    }
    
    func setDishComments(dishComments: [String]){
        self.dishComments = dishComments
    }
}
extension DishCollectionDataSource: UICollectionViewDataSource{
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return dishes.count
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return dishes[DishCategory.allCases[section]]?.count ?? 0
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: DishCollectionViewCell.identifier, for: indexPath) as? DishCollectionViewCell else { return UICollectionViewCell()}
        guard let product = dishes[DishCategory.allCases[indexPath.section]]?[indexPath.item] else { return cell }
        cell.updateUIProperty(with: product)
        if !(dishImages.isEmpty){
            guard let data = dishImages[DishCategory.dishKind(section: indexPath.section)]?[indexPath.row] else { return cell }
            cell.updateImage(data: data)
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if (kind == UICollectionView.elementKindSectionHeader) {
            // Create Header
            
            guard let headerView : DishCommentHeaderView = collectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: DishCommentHeaderView.identifier, for: indexPath) as? DishCommentHeaderView else { return UICollectionReusableView() }
            headerView.setCommentLabel(text: dishComments[indexPath.section])
            return headerView
        }
        return UICollectionReusableView()
    }
}
