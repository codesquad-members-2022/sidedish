//
//  Font.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/25.
//

import UIKit

extension UIFont {

    static var largeRegular: UIFont {
        return UIFont.systemFont(ofSize: 32, weight: .regular)
    }

    static var mediumRegular: UIFont {
        return UIFont.systemFont(ofSize: 18, weight: .medium)
    }
    static var smallRegular: UIFont {
        return UIFont.systemFont(ofSize: 14, weight: .regular)
    }

    static var largeBold: UIFont {
        return UIFont.systemFont(ofSize: 32, weight: .semibold)
    }

    static var mediumBold: UIFont {
        return UIFont.systemFont(ofSize: 18, weight: .semibold)
    }
    static var smallBold: UIFont {
        return UIFont.systemFont(ofSize: 14, weight: .semibold)
    }

    static var caption: UIFont {
        return UIFont.systemFont(ofSize: 12, weight: .semibold)
    }

}

extension UIColor {
    static var primaryDark: UIColor {
        return UIColor(red: 0.0, green: 0.4, blue: 0.84, alpha: 1.0)
    }

    static var primary: UIColor {
        return UIColor(red: 0.0, green: 0.48, blue: 1.0, alpha: 1.0)
    }

    static var primaryLight: UIColor {
        return UIColor(red: 0.5, green: 0.74, blue: 1.0, alpha: 1.0)
    }

    static var black: UIColor {
        return UIColor(red: 0.0, green: 0.0, blue: 0.0, alpha: 1.0)
    }

    static var grey1: UIColor {
        return UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1.0)
    }

    static var grey2: UIColor {
        return UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1.0)
    }

    static var grey3: UIColor {
        return UIColor(red: 0.88, green: 0.88, blue: 0.88, alpha: 1.0)
    }

    static var grey4: UIColor {
        return UIColor(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)
    }

    static var white: UIColor {
        return UIColor(red: 0.96, green: 0.96, blue: 0.97, alpha: 1.0)
    }
}
