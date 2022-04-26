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

    private func setup() {
        imageView.layer.masksToBounds = true
        imageView.layer.cornerRadius = 10
        imageView.image = UIImage(systemName: "cart.circle")

		imageView.translatesAutoresizingMaskIntoConstraints = false
		info.translatesAutoresizingMaskIntoConstraints = false

		self.contentView.addSubview(imageView)
		self.contentView.addSubview(info)

		imageView.anchor(top: self.contentView.topAnchor, bottom: self.contentView.bottomAnchor, leading: self.contentView.leadingAnchor)

		imageView.heightAnchor.constraint(greaterThanOrEqualToConstant: 130).isActive = true
		imageView.setWidth(toAnchor: imageView.heightAnchor)

		info.anchor(leading: imageView.trailingAnchor)
		info.trailingAnchor.constraint(lessThanOrEqualTo: self.contentView.trailingAnchor, constant: -16).isActive = true
		info.centerY(inView: self.contentView)
    }

}
