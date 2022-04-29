//
//  HomeCollectionViewCell.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/20.
//

import UIKit

class HomeCollectionViewCell: UICollectionViewCell {

    var data: HomeModel? {
        didSet {
            guard let data = data else { return }

            if let imgUrlData = try? Data(contentsOf: URL(string: data.image)!) {
                imageView.image = UIImage(data: imgUrlData)
            }
            nameLabel.text = data.name
            descriptionLabel.text = data.description
            
            if let discountedPrice = data.discountedPrice {
                discountedPriceLabel.text = discountedPrice
            }
            originalPriceLabel.text = data.originalPrice
            specialMessagelabel.text = data.specialMessage
        }
    }
    
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var discountedPriceLabel: UILabel!
    @IBOutlet weak var originalPriceLabel: UILabel!
    @IBOutlet weak var specialMessageContainerView: UIView!
    @IBOutlet weak var specialMessagelabel: UILabel!
}
