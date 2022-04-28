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
    
    let badgesView: BadgesView = {
        var view = BadgesView()
        return view
    }()
    
//    let badgeStackView: BadgeStackView = {
//        var stackView = BadgeStackView()
//        stackView.axis = .horizontal
//        stackView.spacing = 4
//        stackView.alignment = .center
//        stackView.distribution = .fillProportionally
//        return stackView
//    }()
    
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
        
        guard let badgeList = dish.badgeList else { return }
        badgeList.forEach { badgesView.setBadge($0) }
        // badgeStackView.setBadges(dish.badgeList)
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
        self.addArrangedSubview(badgesView)
    }
    
    private func setUIConstraints() {
        configureCardTitleLabelConstraint()
        configureCardBodyLabelConstraint()
        configurePriceLabelConstraint()
        configureBadgesViewConstraint()
    }
    
//    private func configureBadgeStackViewConstraint() {
//        badgeStackView.translatesAutoresizingMaskIntoConstraints = false
//        NSLayoutConstraint.activate([
//            badgeStackView.widthAnchor.constraint(equalTo: self.widthAnchor),
//            badgeStackView.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 5),
//            badgeStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10)
//        ])
//    }
    
    private func configureBadgesViewConstraint() {
        badgesView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            badgesView.widthAnchor.constraint(equalTo: self.widthAnchor),
            badgesView.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 5),
            badgesView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10)
        ])
    }
    
    private func configureCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardTitleLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            cardTitleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 10),
            cardTitleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10),
        ])
    }
    
    private func configureCardBodyLabelConstraint() {
        cardBodyLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardBodyLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            cardBodyLabel.topAnchor.constraint(equalTo: cardTitleLabel.bottomAnchor),
            cardBodyLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10),
        ])
    }
    
    private func configurePriceLabelConstraint() {
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            priceLabel.widthAnchor.constraint(equalTo: self.widthAnchor),
            priceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor),
            priceLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10),
        ])
    }

}

