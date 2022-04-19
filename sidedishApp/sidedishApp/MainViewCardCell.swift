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
        label.text = "오리 주물럭_반조리"
        return label
    }()
    
    private lazy var cardBodyLabel: UILabel = {
        var label = UILabel()
        label.text = "감칠맛 나는 매콤한 양념"
        return label
    }()
    
    private lazy var priceLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 18)
        label.text = "15,800원"
        return label
    }()
    
    private lazy var discountedPriceLabel: UILabel = {
        var label = UILabel()
        label.text = "12,640원"
        return label
    }()
    
    private lazy var eventTagLabel: UILabel = {
        var label = UILabel()
        label.text = "이벤트특가"
        label.textColor = .white
        label.backgroundColor = UIColor(red: 127 / 255, green: 188 / 255, blue: 255 / 255, alpha: 1)
        return label
    }()
    
    private lazy var launchingTagLabel: UILabel = {
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
    
    private func setUI() {
        self.addSubview(cardImageView)
        self.addSubview(cardTitleLabel)
        self.addSubview(cardBodyLabel)
        self.addSubview(priceLabel)
        self.addSubview(discountedPriceLabel)
        self.addSubview(eventTagLabel)
        self.addSubview(launchingTagLabel)
        setUIConstraints()
    }
    
    private func setUIConstraints() {
        setCardImageViewConstraint()
        setCardTitleLabelConstraint()
        setCardBodyLabelConstraint()
        setPriceLabelConstraint()
        setDiscountedPriceLabelConstraint()
        setEventTagLabelConstraint()
        setLaunchingTagLabelConstraint()
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
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5).isActive = true
        priceLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setDiscountedPriceLabelConstraint() {
        discountedPriceLabel.translatesAutoresizingMaskIntoConstraints = false
        discountedPriceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5).isActive = true
        discountedPriceLabel.leadingAnchor.constraint(equalTo: priceLabel.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setEventTagLabelConstraint() {
        eventTagLabel.layer.cornerRadius = 5
        
        eventTagLabel.translatesAutoresizingMaskIntoConstraints = false
        eventTagLabel.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 5).isActive = true
        eventTagLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setLaunchingTagLabelConstraint() {
        launchingTagLabel.translatesAutoresizingMaskIntoConstraints = false
        launchingTagLabel.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 5).isActive = true
        launchingTagLabel.leadingAnchor.constraint(equalTo: eventTagLabel.trailingAnchor, constant: 5).isActive = true
    }
    
}
