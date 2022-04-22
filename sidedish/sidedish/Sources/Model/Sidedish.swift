//
//  Food.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Foundation

struct SidedishAPIResult: Decodable {
    let statusCode: Int
    let body: [Sidedish]
}

struct Sidedish: Decodable {
    let hash: String
    let image: URL
    let title: String
    let deliveryType: [String]
    let description: String
    let price: String
    let salePrice: String?
    let badge: [String]?
    
    enum CodingKeys: String, CodingKey {
        case image, title, description, badge
        case deliveryType = "delivery_type"
        case hash = "detail_hash"
        case price = "s_price"
        case salePrice = "n_price"
    }
}

extension Sidedish {
    enum Menu: Int, CaseIterable {
        case main, soup, side
        
        var index: Int {
            switch self {
            case .main: return 0
            case .soup: return 1
            case .side: return 2
            }
        }
        
        var headerTitle: String {
            switch self {
            case .main: return "모두가 좋아하는\n든든한 메인 요리"
            case .soup: return "정성이 담긴\n뜨끈뜨끈 국물 요리"
            case .side: return "식탁을 풍성하게 하는 정갈한 밑반찬"
            }
        }
    }

}
