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
    
    private lazy var cardImageView: UIImageView = {
        var image = UIImageView()
        image.backgroundColor = .systemGray5
        return image
    }()
    
    private lazy var cardTitleLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 20)
        return label
    }()
    
    private lazy var cardBodyLabel: UILabel = {
        var label = UILabel()
        return label
    }()
    
    private lazy var normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 18)
        return label
    }()
    
    private lazy var salePriceLabel: UILabel = {
        var label = UILabel()
        return label
    }()
    
    private lazy var eventBadgeLabel: UILabel = {
        var label = UILabel()
        label.textColor = .white
        label.backgroundColor = UIColor(red: 127 / 255, green: 188 / 255, blue: 255 / 255, alpha: 1)
        return label
    }()
    
    private lazy var launchingBadgeLabel: UILabel = {
        var label = UILabel()
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
    
    func setPropertiesValue(image: String, cardTitle: String, cardBody: String, normalPrice: String, salePrice: String?, badgeList: [Badge]?) {
        cardTitleLabel.text = cardTitle
        cardBodyLabel.text = cardBody
        normalPriceLabel.text = normalPrice
        if let salePrice = salePrice {
            salePriceLabel.text = salePrice
        }
        // MARK: 뱃지가 상황에 따라 표시되도록 해야 함
        if let badgeList = badgeList {
            if badgeList.contains(.eventPrice) {
                setEventBadgeLabelConstraint()
            }
            if badgeList.contains(.launchingPrice) {
                setLaunchingBadgeLabelConstraint()
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
        setCardImageViewConstraint()
        setCardTitleLabelConstraint()
        setCardBodyLabelConstraint()
        setPriceLabelConstraint()
        setDiscountedPriceLabelConstraint()
    }
    
    private func setCardImageViewConstraint() {
        cardImageView.translatesAutoresizingMaskIntoConstraints = false
        cardImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10).isActive = true
        cardImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 10).isActive = true
        cardImageView.widthAnchor.constraint(equalToConstant: 120).isActive = true
        cardImageView.heightAnchor.constraint(equalToConstant: 120).isActive = true
    }
    
    private func setCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        cardTitleLabel.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10).isActive = true
        cardTitleLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setCardBodyLabelConstraint() {
        cardBodyLabel.translatesAutoresizingMaskIntoConstraints = false
        cardBodyLabel.topAnchor.constraint(equalTo: cardTitleLabel.bottomAnchor, constant: 5).isActive = true
        cardBodyLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setPriceLabelConstraint() {
        normalPriceLabel.translatesAutoresizingMaskIntoConstraints = false
        normalPriceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5).isActive = true
        normalPriceLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setDiscountedPriceLabelConstraint() {
        salePriceLabel.translatesAutoresizingMaskIntoConstraints = false
        salePriceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5).isActive = true
        salePriceLabel.leadingAnchor.constraint(equalTo: normalPriceLabel.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setEventBadgeLabelConstraint() {
        eventBadgeLabel.layer.cornerRadius = 5
        
        eventBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        eventBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5).isActive = true
        eventBadgeLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setLaunchingBadgeLabelConstraint() {
        launchingBadgeLabel.translatesAutoresizingMaskIntoConstraints = false
        launchingBadgeLabel.topAnchor.constraint(equalTo: normalPriceLabel.bottomAnchor, constant: 5).isActive = true
        launchingBadgeLabel.leadingAnchor.constraint(equalTo: eventBadgeLabel.trailingAnchor, constant: 5).isActive = true
    }
    
}
