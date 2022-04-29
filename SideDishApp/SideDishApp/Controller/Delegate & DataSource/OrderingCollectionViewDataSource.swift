//
//  OrderingCollectionViewDataSource.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit
import OSLog

final class OrderingCollectionViewDataSource: NSObject, UICollectionViewDataSource {
    
    private var imageNetworkManager: ImageNetworkManager = ImageNetworkManager.shared
    
    private var headers: [Category] = [Category.main,
                                       Category.soup,
                                       Category.side]
    
    private var menus: [Category: [Menu]] = [:]
    
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
        
        supplementaryView.setTitle(title: headers[indexPath.section].headerValue)
        supplementaryView.setSectionNumber(number: indexPath.section)
        return supplementaryView
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        switch self.headers[section] {
        case .main:
            return menus[Category.main]?.count ?? 0
        case .soup:
            return menus[Category.soup]?.count ?? 0
        case .side:
            return menus[Category.side]?.count ?? 0
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: Constant.Identifier.orderingViewCell, for: indexPath) as? OrderingCollectionViewCell else {
            return UICollectionViewCell()
        }
        switch self.headers[indexPath.section] {
        case .main:
            return configure(cell: cell, menu: menus[Category.main]?[indexPath.row])
        case .soup:
            return configure(cell: cell, menu: menus[Category.soup]?[indexPath.row])
        case .side:
            return configure(cell: cell, menu: menus[Category.side]?[indexPath.row])
        }
    }
    
    private func configure(cell: OrderingCollectionViewCell, menu: Menu?) -> OrderingCollectionViewCell {
        guard let menu = menu else { return OrderingCollectionViewCell() }
        setImage(cell: cell, by: menu.image)
        cell.menuStackView.setTitle(by: menu.title)
        cell.menuStackView.setDescription(by: menu.description)
        cell.menuStackView.setPrice(originPrice: menu.n_price, discountedPrice: menu.s_price)
        cell.menuStackView.setBadges(by: menu.badge)
        return cell
    }
    
    func fetch(menus: [Menu], category: Category) {
        self.menus[category] = menus
    }
    
    func getSelectedItem(at index: IndexPath) -> Menu? {
        switch self.headers[index.section] {
        case .main:
            return menus[Category.main]?[index.row]
        case .soup:
            return menus[Category.soup]?[index.row]
        case .side:
            return menus[Category.side]?[index.row]
        }
    }
}

// MARK: - Fecth & Set Image From URL

extension OrderingCollectionViewDataSource {
    private func setImage(cell: OrderingCollectionViewCell, by imageURL: String) {
        guard let imageURL = URL(string: imageURL) else { return }
        imageNetworkManager.request(endpoint: EndPointCase.getImage(imagePath: imageURL.path).endpoint) { (result: Result<UIImage?, NetworkError>) in
            switch result {
            case .success(let image):
                DispatchQueue.main.async {
                    cell.setMenu(image: image)
                }
            case .failure(let failure):
                os_log(.error, "\(failure.localizedDescription)")
            }
        }
    }
}
