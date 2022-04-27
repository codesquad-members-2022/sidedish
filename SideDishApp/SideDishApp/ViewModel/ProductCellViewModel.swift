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
    static let placeholderURL = URL(string: "https://socialistmodernism.com/wp-content/uploads/2017/07/placeholder-image.png?w=640")!

    init(title: String, description: String, imageURL: URL, originalPrice: Money<KRW>?, salePrice: Money<KRW>, badge: [Badge]?) {
        self.title = title
        self.description = description
        self.imageURL = imageURL
        self.originalPrice = originalPrice
        self.salePrice = salePrice
        self.badge = badge
    }

    init(product: ProductSummary) {
        self.init(title: product.title, description: product.description, imageURL: product.imageURL, originalPrice: product.originalPrice, salePrice: product.salePrice, badge: product.badge)
    }

    static func makePlaceHolder () -> ProductCellViewModel {
        ProductCellViewModel(title: "", description: "", imageURL: placeholderURL, originalPrice: nil, salePrice: Money<KRW>(0), badge: nil)
    }

}
