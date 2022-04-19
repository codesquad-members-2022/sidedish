//
//  Extension.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

import Foundation
extension NSDecimalNumber {
    
    var wonFormat : String {
        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .decimal
//        numberFormatter.locale = Locale.current

        return numberFormatter.string(from: self)! + "원"
    }

}
