//
//  HomeView.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import Foundation
import UIKit

class HomeView: UIView{
    var collectionView: UICollectionView?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupUI()
    }
    
    private func setupUI(){
        backgroundColor = .white
    }
    
}
