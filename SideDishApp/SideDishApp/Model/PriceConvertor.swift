//
//  PriceConvertor.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/26.
//

import Foundation

struct PriceConvertor {
    static func toDecimal(from string: String) -> Int {
        return Int(string.replacingOccurrences(of: ",", with: "")
                    .replacingOccurrences(of: "원", with: "")) ?? 0
    }
    
    static func toString(from int: Int) -> String {
        let numberFomatter = NumberFormatter()
        numberFomatter.numberStyle = .decimal
        let decimalNumber = numberFomatter.string(from: NSNumber(value: int)) ?? ""
        let displayingPrice = "\(decimalNumber)원"
        return displayingPrice
    }
}
