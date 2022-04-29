//
//  HomeResponseDetailData.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/29.
//

import Foundation

struct HomeResponseDetailData: Codable {
    let hash: String
    let data: HomeDetailModel
}

struct HomeDetailModel: Codable {
    let topImage: String
    let thumbImages: [String]
    let productDescription: String
    let point: String
    let deliveryInfo: String
    let deliveryFee: String
    let prices: [String]
    let detailSection: [String]
    
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
