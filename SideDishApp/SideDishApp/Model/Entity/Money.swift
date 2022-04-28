//
//  Money.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

import Foundation
struct Money<C: CurrencyFormattable> {

    typealias Currency = CurrencyFormattable

    var value: Decimal

    var priceTag: String {
        "\(C.numberFormat.string(from: NSDecimalNumber(decimal: value))!)" + C.symbol
    }

    init (_ priceInput: String) {
        self.value = Decimal(string: priceInput.components(separatedBy: [",", "원"]).joined()) ?? 0.0
    }

    init?(_ priceInput: String?) {
        guard let priceInput = priceInput else {return nil}
        self.init(priceInput)
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
