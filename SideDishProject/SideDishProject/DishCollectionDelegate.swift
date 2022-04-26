//
//  DishCollectionDeleagte.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/26.
//

import Foundation
import UIKit

final class DishCollectionDelegate: NSObject{
    
}
extension DishCollectionDelegate: UICollectionViewDelegate, UICollectionViewDelegateFlowLayout{
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 125)
    }
    
    func collectionView(collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 100)  // Header size
    }
}
