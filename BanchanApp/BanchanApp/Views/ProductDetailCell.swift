//
//  PruductDetailCell.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductDetailCell: UICollectionViewCell {

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

        let stackView: UIStackView = UIStackView(arrangedSubviews: [image, info])
        stackView.axis = .horizontal
        stackView.spacing = 8
        stackView.distribution = .fill
        stackView.alignment = .center
        self.addSubview(stackView)

        stackView.translatesAutoresizingMaskIntoConstraints = false
        image.translatesAutoresizingMaskIntoConstraints = false
        info.translatesAutoresizingMaskIntoConstraints = false

        NSLayoutConstraint.activate([
            image.heightAnchor.constraint(equalTo: safeAreaLayoutGuide.heightAnchor),
            image.widthAnchor.constraint(equalTo: image.heightAnchor),
            info.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor, constant: 13),
            info.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor, constant: -13)
        ])
    }

}
