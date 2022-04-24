//
//  SoupHeader.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/24.
//

import UIKit

class SoupHeader: UICollectionReusableView {

    static let identifier = "SoupHeader"

    static func nib() -> UINib {
        return UINib(nibName: self.identifier, bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }
}
