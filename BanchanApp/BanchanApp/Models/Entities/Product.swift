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
	let deliveryType: [String]
	let title, productDescription, nPrice, sPrice: String
	let badge: [String]

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
}
