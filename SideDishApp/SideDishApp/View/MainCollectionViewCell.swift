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

    private lazy var badges: [String: BadgeLabel] = {
        var labels = [String: BadgeLabel]()
        for label in Badge.allCases {
            let badgeLabel = BadgeLabel(text: label.rawValue)
            labels.updateValue(badgeLabel, forKey: label.rawValue)
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
        }
        if let detectedBadges = product.badge {
//            moveInfoContainerUpward()

            detectedBadges.forEach({
                let matchedBadge = self.badges[$0.rawValue]
                badgeContainer.addArrangedSubview(matchedBadge ?? UILabel())

            })

        }

        setStyle()
    }

    private func setStyle() {
        mainImage.layer.cornerRadius = 5
        productDescription.textColor = .systemGray2
        priceContainer.spacing = 4
        badgeContainer.spacing = 4
        title.font = .smallBold
        productDescription.sizeToFit()
        productDescription.font = .smallRegular
        productDescription.textColor = .grey2
//        productDescription.adjustsFontSizeToFitWidth = false
//        productDescription.lineBreakMode = .byTruncatingTail
        salePrice.font = .smallBold
    }

    private func configureOriginalPrice(text: String) {
        self.originalPrice.text = text
        let attributeString = NSMutableAttributedString(string: text)
          attributeString.addAttribute(.strikethroughStyle,
                                        value: NSUnderlineStyle.single.rawValue,
                                        range: NSRange(location: 0, length: attributeString.length))
        self.originalPrice.attributedText = attributeString
        priceContainer.addArrangedSubview(self.originalPrice)
    }

//    private func moveInfoContainerUpward() {
//        self.infoContainer.translatesAutoresizingMaskIntoConstraints = false
//        NSLayoutConstraint.activate([
//            self.infoContainer.topAnchor.constraint(equalTo: self.topAnchor, constant: 13)
//        ])
//    }

}
