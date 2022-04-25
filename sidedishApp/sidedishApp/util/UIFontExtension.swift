//
//  UIFontExtension.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import UIKit

enum CustomFont {
    case sfRegularTitle
    case sfRegularSubtitle
    case sfRegularRawPrice
    case sfRegularSubDescription
    case sfRegularCountLabel
    case sfRegularCountText
    case sfSemiboldSalePrice
    case sfSemiboldAccountLabel
    case sfSemiboldAccountText
    case sfSemiboldOrderButton
    case sfSemiboldEventLabel
}

extension UIFont {
    
    static func customFont(_ name: CustomFont) -> UIFont {
        
        switch name {
        case .sfRegularTitle:
            return UIFont(name: "SFProDisplay-Regular", size: 32) ?? UIFont()
        case .sfRegularSubtitle:
            return UIFont(name: "SFProDisplay-Regular", size: 18) ?? UIFont()
        case .sfRegularRawPrice:
            return UIFont(name: "SFProDisplay-Regular", size: 16) ?? UIFont()
        case .sfRegularSubDescription:
            return UIFont(name: "SFProDisplay-Regular", size: 14) ?? UIFont()
        case .sfRegularCountLabel:
            return UIFont(name: "SFProDisplay-Regular", size: 14) ?? UIFont()
        case .sfRegularCountText:
            return UIFont(name: "SFProDisplay-Regular", size: 18) ?? UIFont()
        case .sfSemiboldSalePrice:
            return UIFont(name: "SFProDisplay-Semibold", size: 18) ?? UIFont()
        case .sfSemiboldAccountLabel:
            return UIFont(name: "SFProDisplay-Semibold", size: 18) ?? UIFont()
        case .sfSemiboldAccountText:
            return UIFont(name: "SFProDisplay-Semibold", size: 32) ?? UIFont()
        case .sfSemiboldOrderButton:
            return UIFont(name: "SFProDisplay-Semibold", size: 18) ?? UIFont()
        case .sfSemiboldEventLabel:
            return UIFont(name: "SFProDisplay-Semibold", size: 12) ?? UIFont()
        }
    }
    
}
