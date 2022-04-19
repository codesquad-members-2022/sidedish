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
    enum `Type` {
        case main, soup, side
    }
    
        // swiftlint:disable force_unwrapping
    static let dummy = Sidedish(hash: "HBDEF", image: URL(string: "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg")!, title: "오리 주물럭_반조리", deliveryType: ["새벽배송", "전국택배"], description: "감칠맛 나는 매콤한 양념", price: "15,800원", salePrice: "12,640원", badge: ["런칭특가"])
}
