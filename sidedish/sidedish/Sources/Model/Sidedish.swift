//
//  Food.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Foundation

struct Sidedish {
    let hash: String
    let image: URL
    let title: String
    let deliveryType: [String]
    let description: String
    let price: String
    let salePrice: String
    let badge: [String]
    
    enum CodingKeys: String, CodingKey {
        case image, title, description, badge
        case deliveryType = "delivery_type"
        case hash = "detail_hash"
        case price = "n_price"
        case salePrice = "s_price"
    }
}
