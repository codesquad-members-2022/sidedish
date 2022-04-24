//
//  MainHeader.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/24.
//

import UIKit

class MainHeader: UICollectionReusableView {

    static let identifier = "MainHeader"

    static func nib() -> UINib {
        return UINib(nibName: "MainHeader", bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }

}
