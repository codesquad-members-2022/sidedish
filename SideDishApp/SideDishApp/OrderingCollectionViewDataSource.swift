//
//  OrderingCollectionViewDataSource.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingCollectionViewDataSource: NSObject, UICollectionViewDataSource {
    
    private var headers: [String] = [Constant.SectionHeaderTitle.main,
                                     Constant.SectionHeaderTitle.soup,
                                     Constant.SectionHeaderTitle.side]
    
    var menus: [Menu] = []
    
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return headers.count
    }
    
    func collectionView(_ collectionView: UICollectionView,
                        viewForSupplementaryElementOfKind kind: String,
                        at indexPath: IndexPath) -> UICollectionReusableView {
        
        guard let supplementaryView = collectionView.dequeueReusableSupplementaryView(
            ofKind: kind,
            withReuseIdentifier: Constant.Identifier.sectionHeaderView,
            for: indexPath
        ) as? SectionHeaderView else { return UICollectionReusableView() }
        
        supplementaryView.setTitle(title: headers[indexPath.section])
        return supplementaryView
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return menus.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: Constant.Identifier.orderingViewCell, for: indexPath) as? OrderingCollectionViewCell else {
            return UICollectionViewCell()
        }
        configure(cell: cell, at: indexPath.item)
        return cell
    }
    
    func fetch(dishes: [Menu]) {
        self.menus = dishes
    }
    
    func configure(cell: OrderingCollectionViewCell, at index: Int) {
        let dish = menus[index]
        
        cell.setDishImage(by: dish.image)
        cell.setMenuTitle(by: dish.title)
        cell.setMenuDescription(by: dish.description)
        cell.setMenuPrice(nPrice: dish.n_price, sPrice: dish.s_price)
        cell.setBadges(by: dish.badge)
    }
}
