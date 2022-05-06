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
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        imageView.layer.cornerRadius = 8
        return imageView
    }()
    
    private let menuInfoView: MenuInfoView = {
        let attribute = MenuInfoAttribute()
        attribute.lineSpacing = 4
        attribute.titleFont = .systemFont(ofSize: 15, weight: .bold)
        attribute.titleTextColor = .black
        attribute.discriptionFont = .systemFont(ofSize: 14, weight: .regular)
        attribute.discriptionTextColor = .grey2
        attribute.priceFont = .systemFont(ofSize: 14, weight: .bold)
        attribute.priceTextColor = .black
        attribute.salePriceFont = .systemFont(ofSize: 14)
        attribute.salePriceTextColor = .grey2
        attribute.badgeStackViewSpacing = 4
        let view = MenuInfoView(attribute: attribute)
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
        
        imageView.snp.makeConstraints { make in
            make.top.equalTo(contentView.snp.top)
            make.leading.equalTo(contentView.snp.leading).offset(16)
            make.width.height.equalTo(imageSize)
        }
        
        menuInfoView.snp.makeConstraints { make in
            make.centerY.equalTo(imageView.snp.centerY)
            make.leading.equalTo(imageView.snp.trailing).offset(16)
            make.trailing.equalTo(contentView.snp.trailing).offset(-16)
        }
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
    
    func changePriceLabel(price: Int) {
        menuInfoView.changePriceLabel(price: price)
    }
    
    func changeSalePriceLabel(price: String?) {
        menuInfoView.changeSalePriceLabel(price: price)
    }
    
    func changeSaleBadge(_ badges: [String]?) {
        menuInfoView.changeSaleBadge(badges)
    }
    
    func changeBackgroundColor(_ color: UIColor) {
        backgroundColor = color
    }
}
