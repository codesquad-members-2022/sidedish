//
//  Product.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

import Foundation

struct Response: Codable {
    let statusCode: Int
    let body: [Product]
}

struct Product: Codable {
    let detailHash: String
    let imageURL: URL
    let alt: String
    let title: String
    let description: String
    let deliveryType: [Delivery]
    private let unCastedOriginalPrice: String?
    private let unCastedSalePrice: String
    let badge: [Badge]?

    enum CodingKeys: String, CodingKey {
           case detailHash = "detail_hash"
           case imageURL = "image"
           case alt
           case title
           case description
           case deliveryType = "delivery_type"
           case unCastedOriginalPrice = "n_price"
           case unCastedSalePrice = "s_price"
           case badge
       }

    var originalPrice: Money<KRW>? {
        return Money(unCastedOriginalPrice)
    }

    var salePrice: Money<KRW> {
        Money(unCastedSalePrice)
    }

}
