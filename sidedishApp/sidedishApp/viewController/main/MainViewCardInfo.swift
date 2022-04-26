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
    
    let badgeLabel: UILabel = {
        var label = UILabel()
        label.clipsToBounds = true
        label.textColor = .white
        label.font = UIFont.customFont(.sfSemiboldEventLabel)
        label.layer.cornerRadius = 13
        label.textAlignment = .center
        label.baselineAdjustment = .alignCenters
        // text, backgroundColor
        return label
    }() // badgeStackView 만들기

//    let launchingBadgeLabel: UILabel = {
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
//    let mainBadgeLabel: UILabel = {
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
    }
    
    private func setUIConstraints() {
        configureCardTitleLabelConstraint()
        configureCardBodyLabelConstraint()
        configureSalePriceLabelConstraint()
    }
    
    private func configureCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardTitleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 10),
            cardTitleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10),
        ])
    }
    
    private func configureCardBodyLabelConstraint() {
    
    }
    
    private func configureSalePriceLabelConstraint() {
        
    }
}

