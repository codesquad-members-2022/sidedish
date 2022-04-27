//
//  Int+Extension.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/27.
//

import Foundation

extension Int {
    func printCurrency() -> String {
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal
        guard let stringPrice = formatter.string(from: NSNumber(value: self)) else {
            return ""
        }
        return "\(stringPrice)원"
    }
}
