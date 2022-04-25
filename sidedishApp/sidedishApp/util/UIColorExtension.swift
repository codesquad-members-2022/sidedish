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
            return #colorLiteral(red: 0, green: 0.4911711216, blue: 0.8711194396, alpha: 1)
        case .primary:
            return #colorLiteral(red: 0, green: 0.5694641471, blue: 1, alpha: 1)
        case .primaryLight:
            return #colorLiteral(red: 0.5680068731, green: 0.7893167138, blue: 1, alpha: 1)
        case .black:
            return #colorLiteral(red: 0.003166666953, green: 0.003166666487, blue: 0.003166666953, alpha: 1)
        case .grey1:
            return #colorLiteral(red: 0.3830943704, green: 0.3830943704, blue: 0.3830943704, alpha: 1)
        case .grey2:
            return #colorLiteral(red: 0.5815095305, green: 0.5815094709, blue: 0.5815094709, alpha: 1)
        case .grey3:
            return #colorLiteral(red: 0.9022675753, green: 0.9022675753, blue: 0.9022675753, alpha: 1)
        case .grey4:
            return #colorLiteral(red: 0.9688242078, green: 0.9690207839, blue: 0.9750978351, alpha: 1)
        case .white:
            return #colorLiteral(red: 1, green: 0.9999999404, blue: 0.9999999404, alpha: 1)
        }
    }
}
