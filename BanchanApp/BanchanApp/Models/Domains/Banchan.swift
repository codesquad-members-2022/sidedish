//
//  Banchan.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

enum BanchanType: CaseIterable {
	case main
	case soup
	case side

	var toValue: String {
		switch self {
		case .main:
			return "main"
		case .soup:
			return "soup"
		case .side:
			return "side"
		}
	}
}

class Banchan {
	let id: String
	let type: BanchanType
	let imageUrl: String
	let alternativeImage: String
	let title: String
	let menuDescription: String
	let	normalPrice: Price?
	let salePrice: Price
	let badges: [String]

	init(id: String, type: BanchanType, imageUrl: String, alternativeImage: String, title: String, menuDescription: String, normalPrice: Price?, salePrice: Price, badges: [String]) {
		self.id = id
		self.type = type
		self.imageUrl = imageUrl
		self.alternativeImage = alternativeImage
		self.title = title
		self.menuDescription = menuDescription
		self.normalPrice = normalPrice
		self.salePrice = salePrice
		self.badges = badges
	}
}
