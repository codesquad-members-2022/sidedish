//
//  DetailDishInfo.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/20.
//

import Foundation

struct DetailDishInfo: Codable {
    let data: MenuDetail
}

struct MenuDetail: Codable {
    let top_image: String
    let thumb_images: [String]
    let product_description: String
    let point: String
    let delivery_info: String
    let delivery_fee: String
    let prices: [String]
    let detail_section: [String]
}
