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
    let originalPrice: Money?
    let salePrice: Money
    let badge: [Badge]?
}
