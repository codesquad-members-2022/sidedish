//
//  DishCellInfo.swift
//  SideDish
//
//  Created by YEONGJIN JANG on 2022/04/25.
//

import Foundation

struct Dishes: Codable {
    let statusCode: Int
    let body: [DishCellInfo]
}

// MARK: - Body
struct DishCellInfo: Codable {
    let detailHash: String
    let image: String
    let alt: String
    let deliveryType: [DeliveryType]
    let title, bodyDescription: String
    let normalPrice: String?
    let salePrice: String
    let badge: [String]?

    enum CodingKeys: String, CodingKey {
        case detailHash = "detail_hash"
        case image, alt
        case deliveryType = "delivery_type"
        case title
        case bodyDescription = "description"
        case normalPrice = "n_price"
        case salePrice = "s_price"
        case badge
    }
}

enum DeliveryType: String, Codable {
    case dawnDelivery = "새벽배송"
    case contryParcel = "전국택배"
}
