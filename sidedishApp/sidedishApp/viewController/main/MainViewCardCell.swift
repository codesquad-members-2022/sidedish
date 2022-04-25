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
        return image
    }()
    
    private let cardTitleLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 20)
        return label
    }()
    
    private let cardBodyLabel: UILabel = {
        var label = UILabel()
        return label
    }()
    
    private let normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 18)
        return label
    }()
    
    private let salePriceLabel: UILabel = {
        var label = UILabel()
        return label
    }()
    
    private let eventBadgeLabel: UILabel = {
        var label = UILabel()
        label.clipsToBounds = true
        label.text = "이벤트특가"
        label.textColor = .white
        label.font = UIFont.customFont(.sfSemiboldEventLabel)
        label.backgroundColor = UIColor.customColor(.primaryLight)
        label.layer.cornerRadius = 13
        label.textAlignment = .center
        label.baselineAdjustment = .alignCenters
        return label
    }()
    
    private let launchingBadgeLabel: UILabel = {
        var label = UILabel()
        label.clipsToBounds = true
        label.text = "런칭특가"
        label.textColor = .white
        label.font = UIFont.customFont(.sfSemiboldEventLabel)
        label.backgroundColor = UIColor.customColor(.primaryDark)
        label.layer.cornerRadius = 13
        label.textAlignment = .center
        label.baselineAdjustment = .alignCenters
        return label
    }()
    
    private let mainBadgeLabel: UILabel = {
        var label = UILabel()
        label.clipsToBounds = true
        label.text = "메인특가"
        label.textColor = .white
        label.font = UIFont.customFont(.sfSemiboldEventLabel)
        label.backgroundColor = UIColor.customColor(.primary)
        label.layer.cornerRadius = 13
        label.textAlignment = .center
        label.baselineAdjustment = .alignCenters
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
    }
    
    func setPropertiesValue(mainCard: MainCard) {
        cardTitleLabel.text = mainCard.title
        cardBodyLabel.text = mainCard.description
        normalPriceLabel.text = mainCard.normalPrice
        if let salePrice = mainCard.salePrice {
            salePriceLabel.text = salePrice
        }
        if let badgeList = mainCard.badgeList {
            if badgeList.contains("이벤트특가"),
               badgeList.contains("런칭특가") {
                configureEventLabelAndBadgeLabelConstraint()
            } else if badgeList.contains("이벤트특가") {
                configureEventBadgeLabelConstraint()
            } else if badgeList.contains("런칭특가") {
                configureLaunchingBadgeLabelConstraint()
            }
        }
    }
    
    private func setUI() {
        self.addSubview(cardImageView)
        self.addSubview(cardTitleLabel)
        self.addSubview(cardBodyLabel)
        self.addSubview(normalPriceLabel)
        self.addSubview(salePriceLabel)
        self.addSubview(eventBadgeLabel)
        self.addSubview(launchingBadgeLabel)
        setUIConstraints()
    }
    
    private func setUIConstraints() {
        congifureCardImageViewConstraint()
        configureCardTitleLabelConstraint()
        configureCardBodyLabelConstraint()
        configurePriceLabelConstraint()
        configureDiscountedPriceLabelConstraint()
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
    
    private func configureCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardTitleLabel.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10),
            cardTitleLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5)
        ])
    }
    
    private func configureCardBodyLabelConstraint() {
        cardBodyLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardBodyLabel.topAnchor.constraint(equalTo: cardTitleLabel.bottomAnchor, constant: 5),
            cardBodyLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5)
        ])
    }
    
    private func configurePriceLabelConstraint() {
        normalPriceLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            normalPriceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5),
            normalPriceLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5)
        ])
    }
    
    private func configureDiscountedPriceLabelConstraint() {
        salePriceLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            salePriceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5),
            salePriceLabel.leadingAnchor.constraint(equalTo: normalPriceLabel.trailingAnchor, constant: 5)
        ])
    }
    
    private func configureEventBadgeLabelConstraint() {
        eventBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            eventBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            eventBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5),
            eventBadgeLabel.widthAnchor.constraint(equalToConstant: 89),
            eventBadgeLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    private func configureLaunchingBadgeLabelConstraint() {
        launchingBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            launchingBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            launchingBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5),
            launchingBadgeLabel.widthAnchor.constraint(equalToConstant: 77),
            launchingBadgeLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    private func configureEventLabelAndBadgeLabelConstraint() {
        eventBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            eventBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            eventBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5),
            eventBadgeLabel.widthAnchor.constraint(equalToConstant: 89),
            eventBadgeLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
        
        launchingBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            launchingBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            launchingBadgeLabel.leadingAnchor.constraint(equalTo: eventBadgeLabel.trailingAnchor, constant: 5),
            launchingBadgeLabel.widthAnchor.constraint(equalToConstant: 77),
            launchingBadgeLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
}
