//
//  MainCard.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation

struct MainCard: Codable {
    private(set) var statusCode: Int
    private(set) var body: [Body]
    
    struct Body: Codable {
        var detailHash: String
        var imageURL: String
        var alt: String
        var deliveryType: [String]
        var title: String
        var description: String
        var normalPrice: String?
        var salePrice: String
        var badgeList: [String]?
        
        enum CodingKeys: String, CodingKey {
            case detailHash = "detail_hash"
            case imageURL = "image"
            case alt
            case deliveryType = "delivery_type"
            case title
            case description
            case normalPrice = "n_price"
            case salePrice = "s_price"
            case badgeList = "badge"
        }
    }
}
