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
    
    struct DetailCardData: Codable{
        private(set) var topImage: String
        private(set) var thumbImages: [String]
        private(set) var productDescription, point, deliveryInfo, deliveryFee: String
        private(set) var prices: [String]
        private(set) var detailSection: [String]

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
