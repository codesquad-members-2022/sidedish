//
//  ProductCellViewModel.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/21.
//

import Foundation
struct ProductCellViewModel {

    let title: String
    let description: String
    let imageURL: URL
    let originalPrice: Money<KRW>?
    let salePrice: Money<KRW>
    let badge: [Badge]?

    init(title: String, description: String, imageURL: URL, originalPrice: Money?, salePrice: Money, badge: [Badge]?) {
        self.title = title
        self.description = description
        self.imageURL = imageURL
        self.originalPrice = originalPrice
        self.salePrice = salePrice
        self.badge = badge
    }

    init(product: Product) {
        self.init(title: product.title, description: product.description, imageURL: product.imageURL, originalPrice: product.originalPrice, salePrice: product.salePrice, badge: product.badge)
    }
}
