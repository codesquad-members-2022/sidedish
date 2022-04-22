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
    case main
    case soup
    case side
    var description: String{
        switch self{
        case .main:
            return "메인음식"
        case .side:
            return "밑반찬"
        case .soup:
            return "국"
        }
    }
}

enum ProductEvent: CustomStringConvertible{
    
    case eventPrice(disCount: Double)
    case launchingPrice(disCount: Double)
    case none(disCount: Double)
    
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
