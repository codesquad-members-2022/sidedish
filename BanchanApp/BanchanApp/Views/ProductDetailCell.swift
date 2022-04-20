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
        self.addSubview(stackView)
        
        stackView.translatesAutoresizingMaskIntoConstraints = false
        image.translatesAutoresizingMaskIntoConstraints = false

        NSLayoutConstraint.activate([
            stackView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor),
            stackView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            stackView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor),
            image.widthAnchor.constraint(equalTo: image.heightAnchor)
        ])
    }

}
