//
//  BadgeLabel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/22.
//

import UIKit

class BadgeLabel: UILabel {
    static let minimumScale = 0.5

    private var padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)

    convenience init(color: UIColor) {
        self.init()
        setupStyle(with: color)
    }

    private func setupStyle(with color: UIColor) {
        self.font = .badgeFont
        self.textColor = .systemBackground
        self.backgroundColor = color
        self.textAlignment = .center
        self.layer.masksToBounds = true
        self.layer.cornerCurve = .continuous
        self.adjustsFontSizeToFitWidth = true
        self.minimumScaleFactor = Self.minimumScale
        self.setCornerRadius(ratio: 1.5)
    }

    override func drawText(in rect: CGRect) {
        super.drawText(in: rect.inset(by: padding))
    }

    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize
        contentSize.height += padding.top + padding.bottom
        contentSize.width += padding.left + padding.right
        return contentSize
    }

}
