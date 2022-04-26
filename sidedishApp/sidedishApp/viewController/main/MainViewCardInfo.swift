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
        return label
    }()
    
    let cardBodyLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfRegularMainBodyLabel)
        label.numberOfLines = 0
        label.lineBreakStrategy = .hangulWordPriority
        return label
    }()
    
    let normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfRegularMainNormalPrice)
        label.textColor = UIColor.customColor(.grey2)
        return label
    }()
    
    let salePriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfSemiboldMainSalePrice)
        return label
    }()

//
//    let eventBadgeLabel: UILabel = {
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
        normalPriceLabel.text = dish.normalPrice
        salePriceLabel.text = dish.salePrice
    }

    private func setUI() {
        self.addArrangedSubview(cardTitleLabel)
        self.addArrangedSubview(cardBodyLabel)
        self.addArrangedSubview(normalPriceLabel)
        self.addArrangedSubview(salePriceLabel)
    }
    
    private func setUIConstraints() {
        configureCardTitleLabelConstraint()
        configureCardBodyLabelConstraint()
        configureNormalPriceLabelConstraint()
        configureSalePriceLabelConstraint()
    }
    
    private func configureCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false

    }
    
    private func configureCardBodyLabelConstraint() {
        
    }
    
    private func configureSalePriceLabelConstraint() {
        
    }
    
    private func configureNormalPriceLabelConstraint() {
    }
}


