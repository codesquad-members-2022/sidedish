//
//  ProductType.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/19.
//

enum ProductType: String, CaseIterable {
    case main
    case soup
    case side
}

extension ProductType {
    var index: Int {
        switch self {
        case .main:
            return 0
        case .soup:
            return 1
        case .side:
            return 2
        }
    }
}
