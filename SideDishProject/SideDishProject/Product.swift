//
//  Product.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import Foundation

typealias UniqueID = UUID

struct Product{
    let id: UniqueID
    let name: String
    let price: Int
    let description: String
    let stock: Int
    let category: DishCategory
    let event: [ProductEvent]
    
    init(name: String, price: Int, description: String, stock: Int, category: DishCategory, event: [ProductEvent]) {
        self.id = UUID()
        self.name = name
        self.price = price
        self.description = description
        self.stock = stock
        self.category = category
        self.event = event
    }
}

enum DishCategory: CaseIterable, CustomStringConvertible{
    var description: String{
        switch self{
        case .mainDish:
            return "메인음식"
        case .sideDish:
            return "밑반찬"
        case .soupDish:
            return "국"
        }
    }
    case mainDish
    case soupDish
    case sideDish
}

enum ProductEvent: CaseIterable, CustomStringConvertible{
    case eventPrice
    case launchingPrice
    case none
    
    var disCountRate: Double{
        switch self{
        case .eventPrice:
            return 0.2
        case .launchingPrice:
            return 0.15
        case .none:
            return 1.0
        }
    }
    
    var description: String{
        switch self{
        case .eventPrice:
            return "이벤트 특가"
        case .launchingPrice:
            return "런칭 특가"
        case .none:
            return "해당사항없음"
        }
    }
}
