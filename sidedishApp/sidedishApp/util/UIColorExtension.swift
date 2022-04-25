//
//  UIColorExtension.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import UIKit

enum CustomColor {
    case primaryDark
    case primary
    case primaryLight
    case black
    case grey1
    case grey2
    case grey3
    case grey4
    case white
}

extension UIColor {
    
    convenience init(red: Int, green: Int, blue: Int, a: Int = 1) {
        self.init(
            red: CGFloat(red) / 255.0,
            green: CGFloat(green) / 255.0,
            blue: CGFloat(blue) / 255.0,
            alpha: CGFloat(a) / 255.0
        )
    }
    
    static func customColor(_ name: CustomColor) -> UIColor {
        switch name {
        case .primaryDark:
            return UIColor(red: 0, green: 102, blue: 214)
        case .primary:
            return UIColor(red: 0, green: 122, blue: 255)
        case .primaryLight:
            return UIColor(red: 128, green: 188, blue: 255)
        case .black:
            return UIColor(red: 1, green: 1, blue: 1)
        case .grey1:
            return UIColor(red: 79, green: 79, blue: 79)
        case .grey2:
            return UIColor(red: 130, green: 130, blue: 130)
        case .grey3:
            return UIColor(red: 224, green: 224, blue: 224)
        case .grey4:
            return UIColor(red: 245, green: 245, blue: 247)
        case .white:
            return UIColor(red: 255, green: 255, blue: 255)
        }
    }
}
