//
//  Dish.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/26.
//

import Foundation

enum Dish: CaseIterable {
    case main
    case side
    case soup
    
    var name: String {
        switch self {
        case .main:
            return "main"
        case .side:
            return "side"
        case .soup:
            return "soup"
        }
    }
}
