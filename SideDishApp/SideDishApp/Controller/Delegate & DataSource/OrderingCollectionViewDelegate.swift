//
//  OrderingCollectionViewDelegate.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/20.
//

import UIKit

final class OrderingCollectionViewDelegate: NSObject, UICollectionViewDelegate {
    
    weak var delegate: CollectionViewSelectionDetectable?
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        guard let dataSource = collectionView.dataSource as? OrderingCollectionViewDataSource else { return }
        let selectedItem = dataSource.getSelectedItem(at: indexPath.item)
        delegate?.didSelectItem(item: selectedItem)
    }
}

protocol CollectionViewSelectionDetectable: AnyObject {
    func didSelectItem(item: Menu)
}
