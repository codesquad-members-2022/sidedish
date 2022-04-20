//
//  Money.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

import Foundation
struct Money {
    
    private let inputString : String
    
    var value : NSDecimalNumber {
        let priceString = inputString.components(separatedBy: [",","원"]).joined()
        return NSDecimalNumber(string: priceString)
    }
    
    var won : String {
        return value.wonFormat
    }
    
    init (_ inputString : String){
        self.inputString = inputString
    }
}
