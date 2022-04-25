//
//  MainCollectionViewCell.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/22.
//

import UIKit

class MainCollectionViewCell: UICollectionViewCell {

    static let identifier = "MainCollectionViewCell"

    static func nib() -> UINib {
        return UINib(nibName: "MainCollectionViewCell", bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }

}
