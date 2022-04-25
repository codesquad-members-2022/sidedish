//
//  MainCollectionViewCell.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/22.
//

import UIKit

class MainCollectionViewCell: UICollectionViewCell {

    static let identifier = "MainCollectionViewCell"

    @IBOutlet weak var mainImage: UIImageView!
    @IBOutlet weak private var infoContainer: UIStackView!
    @IBOutlet weak private var title: UILabel!
    @IBOutlet weak private var productDescription: UILabel!
    @IBOutlet weak private var priceContainer: UIStackView!
    @IBOutlet weak private var salePrice: UILabel!
    @IBOutlet weak private var badgeContainer: UIStackView!

    private lazy var originalPrice: UILabel = {
        let label = UILabel()
        label.textColor = .grey2
        label.font = .smallRegular
        return label
    }()

    private lazy var badges: [Badge: BadgeLabel] = {
        var labels = [Badge: BadgeLabel]()
        for label in Badge.allCases {
            let badgeLabel = BadgeLabel(text: label.rawValue)
            labels.updateValue(badgeLabel, forKey: label)
        }
        return labels
    }()

    static func nib() -> UINib {
        return UINib(nibName: self.identifier, bundle: nil)
    }

    override func awakeFromNib() {
        super.awakeFromNib()
    }
}

extension MainCollectionViewCell {

    func configureCell(product: ProductCellViewModel) {
        mainImage.image = UIImage(named: "ImagePlaceHolder")
        title.text = product.title
        productDescription.text = product.description
        salePrice.text = product.salePrice.priceTag

        if let originalPrice = product.originalPrice {
            configureOriginalPrice(text: originalPrice.priceTag)
            priceContainer.addArrangedSubview(self.originalPrice)
        }

        if let detectedBadges = product.badge {
            detectedBadges.forEach({
                let matchedBadge = self.badges[$0]
                badgeContainer.addArrangedSubview(matchedBadge ?? UILabel())
            })
        }
        setStyle()
    }

    private func setStyle() {
        setImage()
        setContainers()
        setFont()
    }

    private func setImage() {
        mainImage.layer.cornerRadius = 5
    }

    private func setContainers() {
        priceContainer.spacing = 4
        badgeContainer.spacing = 4
    }

    private func setFont() {
        productDescription.textColor = .systemGray2
        title.font = .smallBold
        productDescription.font = .smallRegular
        productDescription.textColor = .grey2
        salePrice.font = .smallBold
    }

    private func configureOriginalPrice(text: String) {
        self.originalPrice.text = text
        let attributeString = setStrikeThroughAttribute(text: text)
        self.originalPrice.attributedText = attributeString
    }

    private func setStrikeThroughAttribute(text: String) -> NSMutableAttributedString {
        let attributeString = NSMutableAttributedString(string: text)
          attributeString.addAttribute(.strikethroughStyle,
                                        value: NSUnderlineStyle.single.rawValue,
                                        range: NSRange(location: 0, length: attributeString.length))
        return attributeString
    }

}
