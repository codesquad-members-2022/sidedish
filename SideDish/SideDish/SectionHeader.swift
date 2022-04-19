//
//  SectionHeader.swift
//  SideDish
//
//  Created by YEONGJIN JANG on 2022/04/19.
//

import UIKit

class SectionHeader: UICollectionReusableView {
    
    static let cellId = "homeHeaderView"
    @IBOutlet weak var label: UILabel!
    
    public func setup() {
        label.text = "header"
        backgroundColor = .yellow
    }
    
}
