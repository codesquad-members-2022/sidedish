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
    let imageUrl: String
    let event: [ProductEvent]
    
    init(name: String, price: Int, description: String, stock: Int, category: DishCategory, imageUrl: String, event: [ProductEvent]) {
        self.id = UUID()
        self.name = name
        self.price = price
        self.description = description
        self.stock = stock
        self.category = category
        self.imageUrl = imageUrl
        self.event = event
    }
}

struct ProductDTO: Codable{
    let id: Int
    let name: String
    let imageUrl: String
    let description: String
    let price: Int
    let discount_price: Int
    let events: [String]
}

struct DishCategory: Hashable, Codable {
    let id: Int
    let name: String
    let count: Int
    let description: String
    
    func hash(into hasher: inout Hasher) {
        return hasher.combine(id)
    }
}



enum ProductEvent: CustomStringConvertible, Codable{
    
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
