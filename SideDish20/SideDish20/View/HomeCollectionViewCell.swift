//
//  HomeCollectionViewCell.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/20.
//

import UIKit

class HomeCollectionViewCell: UICollectionViewCell {

    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var discountedPriceLabel: UILabel!
    @IBOutlet weak var originalPriceLabel: UILabel!
    @IBOutlet weak var specialMessageContainerView: UIView!
    @IBOutlet weak var specialMessagelabel: UILabel!

    override class func awakeFromNib() {
        super.awakeFromNib()
    }
}
