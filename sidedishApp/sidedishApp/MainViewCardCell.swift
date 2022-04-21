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
        label.text = "이벤트특가"
        label.textColor = .white
        label.backgroundColor = UIColor(red: 127 / 255, green: 188 / 255, blue: 255 / 255, alpha: 1)
        return label
    }()
    
    private let launchingBadgeLabel: UILabel = {
        var label = UILabel()
        label.text = "런칭특가"
        label.textColor = .white
        label.backgroundColor = UIColor(red: 1 / 255, green: 102 / 255, blue: 214 / 255, alpha: 1)
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
    
    func setPropertiesValue(_ image: String, _ cardTitle: String, _ cardBody: String, _ normalPrice: String, _ salePrice: String?, _ badgeList: [Badge]?) {
        cardTitleLabel.text = cardTitle
        cardBodyLabel.text = cardBody
        normalPriceLabel.text = normalPrice
        if let salePrice = salePrice {
            salePriceLabel.text = salePrice
        }
        // MARK: 뱃지가 상황에 따라 표시되도록 해야 함
        if let badgeList = badgeList {
            if badgeList.contains(.eventPrice),
               badgeList.contains(.launchingPrice) {
                configureEventLabelAndBadgeLabelConstraint()
            }
            if badgeList.contains(.eventPrice) {
                configureEventBadgeLabelConstraint()
            }
            if badgeList.contains(.launchingPrice) {
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
        //self.addSubview(eventBadgeLabel)
//        self.addSubview(launchingBadgeLabel)
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
        self.addSubview(eventBadgeLabel)
        eventBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            eventBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            eventBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5)
        ])
    }
    
    private func configureLaunchingBadgeLabelConstraint() {
        print("런칭특가")
        self.addSubview(launchingBadgeLabel)
        launchingBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            launchingBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5),
            launchingBadgeLabel.leadingAnchor.constraint(equalTo: eventBadgeLabel.trailingAnchor, constant: 5)
        ])
    }
    
    private func configureEventLabelAndBadgeLabelConstraint() {
        eventBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        eventBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5).isActive = true
        eventBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
        
        launchingBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        launchingBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5).isActive = true
        launchingBadgeLabel.leadingAnchor.constraint(equalTo: eventBadgeLabel.trailingAnchor, constant: 5).isActive = true
    }
}
