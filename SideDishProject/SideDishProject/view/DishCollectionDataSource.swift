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
    private var dishImages: [DishCategory : [Data?]] = [:]
    func setDishes(dishes: [DishCategory : [Product]]){
        self.dishes = dishes
    }
    
    func setDishImages(images: [DishCategory : [Data?]]){
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
        guard let category = findCategory(by: section),
              let itemCount = dishes[category]?.count else {
            return 0
        }
        return itemCount
    }
    
    private func findCategory(by section: Int) -> DishCategory? {
        for (index,dish) in dishes.enumerated() {
            if section == index {
                return dish.key
            }
        }
        return nil
    }
    
    private func findProduct(by indexPath: IndexPath) -> Product? {
        guard let category = findCategory(by: indexPath.section), let categoryValues = dishes[category] else {
            return nil
        }
        return categoryValues[indexPath.row]
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: DishCollectionViewCell.identifier, for: indexPath) as? DishCollectionViewCell else { return UICollectionViewCell()}
        guard let product = findProduct(by: indexPath) else {
            return cell
        }
        cell.updateUIProperty(with: product)
        let isContainEvent = product.event.contains { event in
            if case .none = event {
                return false
            }
            return true
        }
        isContainEvent ? cell.setNonEventUIConstraint() : cell.setEventUIConstraint()
        
        if !(dishImages.isEmpty){
            guard let category = findCategory(by: indexPath.section),
                  let imageData = dishImages[category]?[indexPath.row] else {
                return cell
            }
            cell.updateImage(data: imageData)
        }
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        if (kind == UICollectionView.elementKindSectionHeader)
            && (!dishComments.isEmpty) {
            guard let headerView : DishCommentHeaderView = collectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: DishCommentHeaderView.identifier, for: indexPath) as? DishCommentHeaderView else { return UICollectionReusableView() }
            headerView.setCommentLabel(text: dishComments[indexPath.section])
            return headerView
        }
        return UICollectionReusableView()
    }
}
