//
//  MoneyCurrency.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/21.
//

import Foundation

protocol CurrencyFormatable {
    static var symbol: String {get}
    static var numberFormat: NumberFormatter {get}
}

enum KRW: CurrencyFormatable {

    static var symbol: String {
        return "원"
    }

    static var numberFormat: NumberFormatter {
       let numberFormatter = NumberFormatter()
       numberFormatter.numberStyle = .decimal
       return numberFormatter
    }

}
