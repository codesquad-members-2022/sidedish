//
//  DetailCard.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/22.
//

import Foundation

struct DetailCard: Codable {
    private(set) var hash: String
    private(set) var data: DetailCardData
    
    struct DetailCardData: Codable {
        var topImage: String
        var thumbImages: [String]
        var productDescription, point, deliveryInfo, deliveryFee: String
        var prices: [String]
        var detailSection: [String]

        enum CodingKeys: String, CodingKey {
            case topImage = "top_image"
            case thumbImages = "thumb_images"
            case productDescription = "product_description"
            case point
            case deliveryInfo = "delivery_info"
            case deliveryFee = "delivery_fee"
            case prices
            case detailSection = "detail_section"
        }
    }
}
