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
        delegate?.didSelectItem(index: indexPath)
    }
}
protocol CollectionViewSelectionDetectable: AnyObject {
    func didSelectItem(index: IndexPath)
}
