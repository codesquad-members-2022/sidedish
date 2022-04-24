//
//  MainCollectionViewCell.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/22.
//

import UIKit

class MainCollectionViewCell: UICollectionViewCell {

    static let identifier = "MainCollectionViewCell"

    @IBOutlet weak private var mainImage: UIImageView!
    @IBOutlet weak private var infoContainer: UIStackView!
    @IBOutlet weak private var title: UILabel!
    @IBOutlet weak private var productDescription: UILabel!
    @IBOutlet weak private var priceContainer: UIStackView!
    @IBOutlet weak private var salePrice: UILabel!

    weak private var originalPrice: UILabel?

    static func nib() -> UINib {
        return UINib(nibName: "MainCollectionViewCell", bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }
}

extension MainCollectionViewCell {

    func configureCell(product: ProductCellViewModel) {
        mainImage.image = UIImage(named: "1155_ZIP_P_0081_T")
        title.text = product.title
        productDescription.text = product.description
        salePrice.text = product.salePrice.priceTag
        if let originalPrice = product.originalPrice {
            self.originalPrice?.text = originalPrice.priceTag
        }
        if let badge = product.badge {

        }

        setStyle()
    }

    private func setStyle() {
        mainImage.layer.cornerRadius = 5
        setOriginalPriceStyle()
    }

    private func setOriginalPriceStyle() {
        guard let originalPrice = self.originalPrice else {return}
        originalPrice.textColor = .systemGray2
        priceContainer.addArrangedSubview(originalPrice)
    }

}
