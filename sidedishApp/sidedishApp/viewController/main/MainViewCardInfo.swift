//
//  MainViewCardInfo.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/26.
//

import UIKit

class MainViewCardInfo: UIStackView {

    private let cardTitleLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfSemiboldMainTitleLabel)
        return label
    }()

    private let cardBodyLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfRegularMainBodyLabel)
        label.numberOfLines = 0
        label.lineBreakStrategy = .hangulWordPriority
        return label
    }()

    private let normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfRegularMainNormalPrice)
        label.textColor = UIColor.customColor(.grey2)
        return label
    }()

    private let salePriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.customFont(.sfSemiboldMainSalePrice)
        return label
    }()

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
        setUIProperties()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
        setUIProperties()
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
    
    private func setUIProperties() {
        // constraints 설정하기
    }
}
