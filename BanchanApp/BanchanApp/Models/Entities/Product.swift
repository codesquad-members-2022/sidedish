//
//  Product.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/25.
//

import Foundation

struct Product: Codable {
    let detailHash: String
    let image: String
    let alt: String
    let title: String
    let deliveryType: [String]
    let productDescription: String
    let nPrice: String?
    let sPrice: String
    let badge: [String]?

    enum CodingKeys: String, CodingKey {
        case detailHash = "detail_hash"
        case image
        case alt
        case deliveryType = "delivery_type"
        case title
        case productDescription = "description"
        case nPrice = "n_price"
        case sPrice = "s_price"
        case badge
    }

    func toDomain(type: BanchanType) -> Banchan {
        var nPrice: Price?

        if let normalPrice = self.nPrice {
            nPrice = Price(normalPrice)
        }

        return Banchan(
            id: self.detailHash,
            type: type,
            imageUrl: self.image,
            alternativeImage: self.alt,
            title: self.title,
            menuDescription: self.productDescription,
            normalPrice: nPrice,
            salePrice: Price(self.sPrice),
            badges: self.badge ?? []
        )
    }
}
