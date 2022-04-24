//
//  SideHeader.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/24.
//

import UIKit

class SideHeader: UICollectionReusableView {

    static let identifier = "SideHeader"

    static func nib() -> UINib {
        return UINib(nibName: "SideHeader", bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }

}
