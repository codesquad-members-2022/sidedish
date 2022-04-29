//
//  BadgeStackView.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/26.
//

import UIKit

class BadgeStackView: UIStackView {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    private func makeEventPriceBadge() -> UILabel {
        let badge = BadgeLabel()
        badge.text = Badge.eventPrice.description
        badge.backgroundColor = UIColor.customColor(.primaryLight)
        return badge
    }
    
    private func makeLaunchingPriceBadge() -> UILabel{
        let badge = BadgeLabel()
        badge.text = Badge.launchingPrice.description
        badge.backgroundColor = UIColor.customColor(.primary)
        return badge
    }
    
    private func makeMainPriceBadge() -> UILabel{
        let badge = BadgeLabel()
        badge.text = Badge.mainPrice.description
        badge.backgroundColor = UIColor.customColor(.primaryDark)
        return badge
    }
}
