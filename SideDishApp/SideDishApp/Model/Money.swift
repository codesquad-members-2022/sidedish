//
//  Money.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

import Foundation
struct Money {

    var value: Decimal

    var krwFormat: String {
        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .decimal
        return numberFormatter.string(from: NSDecimalNumber(decimal: value))! + "원"
    }

    init (_ priceInput: String) {
        self.value = Decimal(string: priceInput.components(separatedBy: [",", "원"]).joined()) ?? 0.0
    }

    init (_ value: Decimal) {
        self.value = value
    }

    static func + (lhs: Money, rhs: Money) -> Money {
        return Money(lhs.value + rhs.value)
    }

    static func - (lhs: Money, rhs: Money) -> Money {
        return Money(lhs.value - rhs.value)
    }

}
