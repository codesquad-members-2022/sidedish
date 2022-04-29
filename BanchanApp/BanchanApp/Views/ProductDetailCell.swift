//
//  PruductDetailCell.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductDetailCell: UICollectionViewCell {
    static let identifier = "ProductDetailCell"

    private let imageView: UIImageView = UIImageView()
    private let info: ProductDetailView = ProductDetailView()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    override func prepareForReuse() {
        super.prepareForReuse()
        self.imageView.image = UIImage(systemName: "cart.circle")
    }

    private func setup() {
        imageView.layer.masksToBounds = true
        imageView.layer.cornerRadius = 10
        imageView.image = UIImage(systemName: "cart.circle")

        imageView.translatesAutoresizingMaskIntoConstraints = false
        info.translatesAutoresizingMaskIntoConstraints = false

        self.contentView.addSubview(imageView)
        self.contentView.addSubview(info)

        imageView.anchor(top: self.contentView.topAnchor, bottom: self.contentView.bottomAnchor, leading: self.contentView.leadingAnchor)

        imageView.heightAnchor.constraint(equalToConstant: 130).isActive = true
        imageView.setWidth(toAnchor: imageView.heightAnchor)

        info.anchor(leading: imageView.trailingAnchor, paddingLeft: 8)
        info.trailingAnchor.constraint(lessThanOrEqualTo: self.contentView.trailingAnchor, constant: -16).isActive = true
        info.centerY(inView: self.contentView)
    }

    func setInfoText(title: String, description: String, salePrice: String, normalPrice: String?, badges: [String]) {
        self.info.setTitleText(title)
        self.info.setDescriptionText(description)
        self.info.setSalePrice(salePrice)

        if let normalPrice = normalPrice {
            self.info.setNormalPrice(normalPrice)
        }

        self.info.setBadgeList(badges)
    }

    func setImage(_ image: UIImage) {
        self.imageView.image = image
    }
}
