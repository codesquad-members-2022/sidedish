//
//  badge.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/25.
//

import UIKit
class BadgeLabel: UILabel {

    private var padding = UIEdgeInsets(top: 4, left: 8.0, bottom: 4, right: 8.0)

    convenience init(text: String) {
        self.init()
        styleConfiguration()
        self.text = text
    }

    private func styleConfiguration() {
        self.clipsToBounds = true
        self.backgroundColor = .systemBlue
        self.font = .caption
        self.layer.cornerRadius = self.font.pointSize * 1.8 / 2
        self.textColor = .white
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
