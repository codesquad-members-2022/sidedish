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
    
    func getTitle() -> String{
        return name
    }
}

enum DishCategory: CaseIterable{
    case main
    case soup
    case side
    var comment: String{
        switch self{
        case .main:
            return "모두가 좋아하는\n든든한 메인 요리"
        case .side:
            return "정성이 담긴\n뜨끈뜨끈 국물 요리"
        case .soup:
            return "식탁을 풍성하게 하는\n정갈한 밑반찬"
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
