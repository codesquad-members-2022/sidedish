//
//  PaddingLabel.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/04.
//

import UIKit

class PaddingLabel: UILabel {
    var padding = UIEdgeInsets.zero

    override func drawText(in rect: CGRect) {
        let paddingRect = rect.inset(by: padding)
        super.drawText(in: paddingRect)
    }

    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize
        contentSize.height += padding.top + padding.bottom
        contentSize.width += padding.left + padding.right
        return contentSize
    }
}
