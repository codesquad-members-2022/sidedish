//
//  Header.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class Header: UICollectionReusableView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.backgroundColor = .gray
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.backgroundColor = .gray
    }
}
