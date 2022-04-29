//
//  HomeResponseData.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

struct HomeResponseData: Codable {
    let statusCode: Int
    let body: [HomeModelList]
}

struct HomeModelList: Codable {
    let detailHash: String
    let image: String
    let alt: String
    let deliveryType: [String]
    let title: String
    let description: String
    let nPrice: String?
    let sPrice: String
    let badge: [String]?
    
    enum CodingKeys: String, CodingKey {
        case detailHash = "detail_hash"
        case image
        case alt
        case deliveryType = "delivery_type"
        case title
        case description
        case nPrice = "n_price"
        case sPrice = "s_price"
        case badge
    }
}
