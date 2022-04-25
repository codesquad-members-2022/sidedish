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

    var title: String {
        switch self {
        case .main:
            return "모두가 좋아하는\n든든한 메인 요리"
        case .soup:
            return "정성이 담긴\n뜨끈뜨끈 국물 요리"
        case .side:
            return "식탁을 풍성하게 하는\n정갈한 밑반찬"
        }
    }
}
