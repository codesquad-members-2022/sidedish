//
//  UIFont+Extension.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/22.
//

import UIKit.UIFont

extension UIFont {
    static func getFont(size: CGFloat, weight: Weight = .regular) -> UIFont {
        return .systemFont(ofSize: size, weight: weight)
    }

    static var textLargeRegular: UIFont {
        return Self.getFont(size: 32)
    }

    static var textLargeBold: UIFont {
        return Self.getFont(size: 32, weight: .semibold)
    }

    static var textMediumRegular: UIFont {
        return Self.getFont(size: 18)
    }

    static var textMediumBold: UIFont {
        return Self.getFont(size: 18, weight: .semibold)
    }

    static var textSmallRegular: UIFont {
        return Self.getFont(size: 14)
    }

    static var textSmallBold: UIFont {
        return Self.getFont(size: 14, weight: .semibold)
    }

    static var badgeFont: UIFont {
        return Self.getFont(size: 12, weight: .semibold)
    }
}
