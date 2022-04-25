//
//  ProductDetail.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/25.
//

import Foundation

struct ProductDetail: Codable {
	let topImage: String
	let thumbImages: [String]
	let productDescription, point, deliveryInfo, deliveryFee: String
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
