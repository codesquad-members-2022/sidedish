//
//  MainViewCardCell.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation
import UIKit

class MainViewCardCell: UICollectionViewCell {
    
    static let identifier = "MainViewCardCell"
    
    private let cardImageView: UIImageView = {
        var image = UIImageView()
        image.backgroundColor = .systemGray5
        image.layer.cornerRadius = 5
        return image
    }()
    
    private let cardInfoVerticalStackView: MainViewCardInfo = {
        var stackView = MainViewCardInfo()
        stackView.axis = .vertical
        stackView.backgroundColor = UIColor.customColor(.primaryDark)
        return stackView
    }()
    
//    private let cardTitleLabel: UILabel = {
//        var label = UILabel()
//        label.font = UIFont.customFont(.sfSemiboldMainTitleLabel)
//        return label
//    }()
//
//    private let cardBodyLabel: UILabel = {
//        var label = UILabel()
//        label.font = UIFont.customFont(.sfRegularMainBodyLabel)
//        label.numberOfLines = 0
//        label.lineBreakStrategy = .hangulWordPriority
//        return label
//    }()
//
//    private let normalPriceLabel: UILabel = {
//        var label = UILabel()
//        label.font = UIFont.customFont(.sfRegularMainNormalPrice)
//        label.textColor = UIColor.customColor(.grey2)
//        return label
//    }()
//
//    private let salePriceLabel: UILabel = {
//        var label = UILabel()
//        label.font = UIFont.customFont(.sfSemiboldMainSalePrice)
//        return label
//    }()
//
//    private let eventBadgeLabel: UILabel = {
//        var label = UILabel()
//        label.clipsToBounds = true
//        label.text = Badge.eventPrice.description
//        label.textColor = .white
//        label.font = UIFont.customFont(.sfSemiboldEventLabel)
//        label.backgroundColor = UIColor.customColor(.primaryLight)
//        label.layer.cornerRadius = 13
//        label.textAlignment = .center
//        label.baselineAdjustment = .alignCenters
//        return label
//    }()
//
//    private let launchingBadgeLabel: UILabel = {
//        var label = UILabel()
//        label.clipsToBounds = true
//        label.text = Badge.launchingPrice.description
//        label.textColor = .white
//        label.font = UIFont.customFont(.sfSemiboldEventLabel)
//        label.backgroundColor = UIColor.customColor(.primaryDark)
//        label.layer.cornerRadius = 13
//        label.textAlignment = .center
//        label.baselineAdjustment = .alignCenters
//        return label
//    }()
//
//    private let mainBadgeLabel: UILabel = {
//        var label = UILabel()
//        label.clipsToBounds = true
//        label.text = Badge.mainPrice.description
//        label.textColor = .white
//        label.font = UIFont.customFont(.sfSemiboldEventLabel)
//        label.backgroundColor = UIColor.customColor(.primary)
//        label.layer.cornerRadius = 13
//        label.textAlignment = .center
//        label.baselineAdjustment = .alignCenters
//        return label
//    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
    }
    
    func setPropertiesValue(dish: MainCard.Body) {
        cardInfoVerticalStackView.setPropertiesValue(dish: dish)
    }
    
    private func setUI() {
        self.addSubview(cardImageView)
        self.addSubview(cardInfoVerticalStackView)
        setUIConstraints()
    }
    
    private func setUIConstraints() {
        congifureCardImageViewConstraint()
        configureCardInfoVerticalStackViewConstraint()
        
    }
    
    private func congifureCardImageViewConstraint() {
        cardImageView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10),
            cardImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 10),
            cardImageView.widthAnchor.constraint(equalToConstant: 120),
            cardImageView.heightAnchor.constraint(equalToConstant: 120)
        ])
    }
    
    private func configureCardInfoVerticalStackViewConstraint() {
        cardInfoVerticalStackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardInfoVerticalStackView.topAnchor.constraint(equalTo: self.contentView.topAnchor),
            cardInfoVerticalStackView.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor),
            cardInfoVerticalStackView.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor),
            cardInfoVerticalStackView.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor)
        ])
    }
    
}
