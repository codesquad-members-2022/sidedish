//
//  MenuDetail.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import Foundation

struct MenuDetailApi: Decodable {
    let hash: String
    let data: MenuDetail
}

struct MenuDetail: Decodable {
    let topImage: URL
    let thumbImages: [URL]
    let description: String
    let point: String
    let deliveryInfo: String
    let deliveryFee: String
    let prices: [String]
    let detailSection: [URL]
    
    enum CodingKeys: String, CodingKey {
        case point, prices
        case topImage = "top_image"
        case thumbImages = "thumb_images"
        case description = "product_description"
        case deliveryInfo = "delivery_info"
        case deliveryFee = "delivery_fee"
        case detailSection = "detail_section"
    }
}
