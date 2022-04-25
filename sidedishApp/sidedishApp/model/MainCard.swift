//
//  MainCard.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation

struct MainCard: Codable {
    private(set) var detailHash: String
    private(set) var imageURL: String
    private(set) var alt: String
    private(set) var deliveryType: [String]
    private(set) var title: String
    private(set) var description: String
    private(set) var normalPrice: String
    private(set) var salePrice: String?
    private(set) var badgeList: [String]?
    
    enum CodingKeys: String, CodingKey {
        case detailHash = "detail_hash"
        case imageURL
        case alt
        case deliveryType = "delivery_type"
        case title
        case description
        case normalPrice = "n_price"
        case salePrice = "s_price"
        case badgeList = "badge"
    }
}
