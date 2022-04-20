//
//  Food.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/20.
//

import Foundation

struct Food: Codable{
    private(set) var detailHash: String
    private(set) var title: String
    private(set) var description: String
    private(set) var image: String
    private(set) var alt: String
    private(set) var badge: [Badge]
    private(set) var deliveryType: [String]
    private(set) var originPrice: Int
    private(set) var salePrice: Int?
    
    enum CodingKyes: String, CodingKey{
        case detailHash = "detail_hash"
        case title
        case description
        case image
        case alt
        case badge
        case deliveryType = "delivery_type"
        case originPrice = "n_price"
        case salePrice = "s_price"
    }
}

enum Badge: String, Codable{
    case 이벤트특가
    case 점심특가
}
