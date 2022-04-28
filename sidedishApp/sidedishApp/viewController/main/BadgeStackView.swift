////
////  BadgeStackView.swift
////  sidedishApp
////
////  Created by Bibi on 2022/04/26.
////
//
//import UIKit
//
//class BadgeStackView: UIStackView {
//
//    class badgeLabel: UILabel {
//        private var padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)
//        
//        override init(frame: CGRect) {
//            super.init(frame: frame)
//            self.clipsToBounds = true
//            self.textColor = .white
//            self.font = UIFont.customFont(.sfSemiboldEventLabel)
//            self.layer.cornerRadius = 10
//            self.textAlignment = .center
//            self.baselineAdjustment = .alignCenters
//            self.numberOfLines = 0
//        }
//        
//        required init?(coder: NSCoder) {
//            super.init(coder: coder)
//        }
//        
//        convenience init(padding: UIEdgeInsets) {
//            self.init()
//            self.padding = padding
//        }
//        
//        override func drawText(in rect: CGRect) {
//            super.drawText(in: rect.inset(by: padding))
//        }
//        
//        override var intrinsicContentSize: CGSize {
//            var contentSize = super.intrinsicContentSize
//            contentSize.height += padding.top + padding.bottom
//            contentSize.width += padding.left + padding.right
//            return contentSize
//        }
//    }
//    
//    override init(frame: CGRect) {
//        super.init(frame: frame)
//    }
//    
//    required init(coder: NSCoder) {
//        super.init(coder: coder)
//    }
//
//    func setBadges(_ badges: [String]?) {
//        guard let badges = badges else {
//            return
//        }
//        if badges.contains(Badge.eventPrice.description) {
//            self.addArrangedSubview(makeEventPriceBadge())
//        }
//        if badges.contains(Badge.launchingPrice.description) {
//            self.addArrangedSubview(makeLaunchingPriceBadge())
//        }
//        if badges.contains(Badge.mainPrice.description) {
//            self.addArrangedSubview(makeMainPriceBadge())
//        }
//    }
//    
//    private func makeEventPriceBadge() -> UILabel {
//        let badge = badgeLabel()
//        badge.text = Badge.eventPrice.description
//        badge.backgroundColor = UIColor.customColor(.primaryLight)
//        return badge
//    }
//    
//    private func makeLaunchingPriceBadge() -> UILabel{
//        let badge = badgeLabel()
//        badge.text = Badge.launchingPrice.description
//        badge.backgroundColor = UIColor.customColor(.primary)
//        return badge
//    }
//    
//    private func makeMainPriceBadge() -> UILabel{
//        let badge = badgeLabel()
//        badge.text = Badge.mainPrice.description
//        badge.backgroundColor = UIColor.customColor(.primaryDark)
//        return badge
//    }
//}
