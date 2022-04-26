//
//  PruductDetailCell.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductDetailCell: UICollectionViewCell {

	static let identifier = "ProductDetailCell"

    private let image: UIImageView = UIImageView()
    private let info: ProductDetailView = ProductDetailView()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    private func setup() {
        image.layer.masksToBounds = true
        image.layer.cornerRadius = 10
        image.image = UIImage(systemName: "cart.circle")

		image.translatesAutoresizingMaskIntoConstraints = false
		info.translatesAutoresizingMaskIntoConstraints = false

		self.contentView.addSubview(image)
		self.contentView.addSubview(info)

		image.anchor(top: self.contentView.topAnchor, bottom: self.contentView.bottomAnchor, leading: self.contentView.leadingAnchor)

		image.setWidth(130)
		image.setHeight(toAnchor: image.widthAnchor)

		info.anchor(leading: image.trailingAnchor)
		info.trailingAnchor.constraint(lessThanOrEqualTo: self.contentView.trailingAnchor, constant: -16).isActive = true
		info.centerY(inView: image)
    }

}
