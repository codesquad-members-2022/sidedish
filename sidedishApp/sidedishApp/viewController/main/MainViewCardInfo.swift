//
//  MainViewCardInfo.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/26.
//

import UIKit

class MainViewCardInfo: UIStackView {

    let cardTitleLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfSemiboldMainTitleLabel)
        label.textColor = UIColor.customColor(.black)
        return label
    }()
    
    let cardBodyLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfRegularMainBodyLabel)
        label.textColor = UIColor.customColor(.grey2)
        label.numberOfLines = 0
        label.lineBreakStrategy = .hangulWordPriority
        return label
    }()
    
    let priceLabel: UILabel = {
        var label = UILabel()
        label.textColor = UIColor.customColor(.black)
        return label
    }()
    
    let badgeStackView: BadgeStackView = {
        var stackView = BadgeStackView()
        stackView.axis = .horizontal
        stackView.alignment = .center
        //stackView.spacing = 1
        stackView.distribution = .fillProportionally
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
        setUIConstraints()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
        setUIConstraints()
    }
    
    func setPropertiesValue(dish: MainCard.Body) {
        cardTitleLabel.text = dish.title
        cardBodyLabel.text = dish.description
        priceLabel.text = "\(dish.salePrice)" + " \(dish.normalPrice ?? "")"
        
        setPriceLabelAttributedString(salePrice: dish.salePrice, normalPrice: dish.normalPrice ?? "")
        
        if badgeStackView.subviews.count != .zero {
            badgeStackView.clearSubviews()
        }
        
        guard let badgeTypeList = dish.badgeList else { return }
        for badgeType in badgeTypeList {
            if let badgeLabel = BadgeLabel().makeBadge(type: badgeType) {
                badgeStackView.addArrangedSubview(badgeLabel)
            }
        }
    }
    
    private func setPriceLabelAttributedString(salePrice: String, normalPrice: String) {
        let fullText = priceLabel.text ?? ""
        let attributedStr = NSMutableAttributedString(string: fullText)
        
        let salePriceRange = (fullText as NSString).range(of: salePrice)
        attributedStr.addAttribute(.font, value: UIFont.customFont(.sfSemiboldMainSalePrice), range: salePriceRange)
        let normalPriceRange = (fullText as NSString).range(of: normalPrice)
        attributedStr.addAttribute(.foregroundColor, value: UIColor.customColor(.grey2), range: normalPriceRange)
        attributedStr.addAttribute(.font, value: UIFont.customFont(.sfRegularMainNormalPrice), range: normalPriceRange)
        attributedStr.addAttribute(.strikethroughStyle, value: 1, range: normalPriceRange)
        
        priceLabel.attributedText = attributedStr
    }

    private func setUI() {
        self.addArrangedSubview(cardTitleLabel)
        self.addArrangedSubview(cardBodyLabel)
        self.addArrangedSubview(priceLabel)
        self.addArrangedSubview(badgeStackView)
    }
    
    private func setUIConstraints() {
        configureCardTitleLabelConstraint()
        configureCardBodyLabelConstraint()
        configurePriceLabelConstraint()
        configureBadgeStackViewConstraint()
    }
    
    private func configureCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardTitleLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            cardTitleLabel.topAnchor.constraint(equalTo: self.topAnchor),
            cardTitleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            cardTitleLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
    
    private func configureCardBodyLabelConstraint() {
        cardBodyLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardBodyLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            cardBodyLabel.topAnchor.constraint(equalTo: cardTitleLabel.bottomAnchor),
            cardBodyLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            cardBodyLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
    
    private func configurePriceLabelConstraint() {
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            priceLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            priceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor),
            priceLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            priceLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
    
    private func configureBadgeStackViewConstraint() {
        badgeStackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            badgeStackView.widthAnchor.constraint(equalTo: self.widthAnchor),
            badgeStackView.topAnchor.constraint(equalTo: priceLabel.bottomAnchor),
            badgeStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            badgeStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor),
            badgeStackView.heightAnchor.constraint(equalTo: self.heightAnchor)
        ])
    }
}

