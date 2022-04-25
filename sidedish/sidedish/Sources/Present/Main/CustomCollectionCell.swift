//
//  CustomCollectionCell.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import UIKit

class CustomCollectionCell: UICollectionViewCell {
    static let identifier = "CustomCollectionCell"
    private let imageSize = 130.0

    private let imageView: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        imageView.layer.cornerRadius = 8
        imageView.image = UIImage(named: "testimage")
        return imageView
    }()
    
    private let menuInfoView: MenuInfoView = {
        let attribute = MenuInfoAttribute(stackViewSpacing: 4,
                                          titleFont: .systemFont(ofSize: 15, weight: .bold), titleTextColor: .black,
                                          discriptionFont: .systemFont(ofSize: 14, weight: .regular), discriptionTextColor: .grey2,
                                          priceFont: .systemFont(ofSize: 14, weight: .bold), priceTextColor: .black,
                                          salePriceFont: .systemFont(ofSize: 14), salePriceTextColor: .grey2,
                                          badgeStackViewSpacing: 4)
        let view = MenuInfoView(attribute: attribute)
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        layout()
    }

    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }

    private func layout() {
        contentView.addSubview(imageView)
        contentView.addSubview(menuInfoView)
        
        NSLayoutConstraint.activate([
            imageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            imageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            imageView.widthAnchor.constraint(equalToConstant: imageSize),
            imageView.heightAnchor.constraint(equalToConstant: imageSize),
            
            menuInfoView.centerYAnchor.constraint(equalTo: imageView.centerYAnchor),
            menuInfoView.leadingAnchor.constraint(equalTo: imageView.trailingAnchor, constant: 16),
            menuInfoView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16)
        ])
    }
}

extension CustomCollectionCell {
    func changeThumbnail(imageUrl: URL?) {
        guard let imagePath = imageUrl?.path else {
            return
        }
        
        imageView.image = UIImage(contentsOfFile: imagePath)
    }
    func changeTitleLabel(text: String) {
        menuInfoView.changeTitleLabel(text: text)
    }

    func changeDescriptionLabel(text: String) {
        menuInfoView.changeDescriptionLabel(text: text)
    }
    
    func changePriceLabel(text: String) {
        menuInfoView.changePriceLabel(text: text)
    }
    
    func changeSalePriceLabel(text: String) {
        menuInfoView.changeSalePriceLabel(text: text)
    }
    
    func changeSaleBadge(_ badges: [String]?) {
        menuInfoView.changeSaleBadge(badges)
    }
}
