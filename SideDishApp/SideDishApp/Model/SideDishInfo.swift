//
//  SideDishInfo.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

import Foundation

struct SideDishInfo: Codable, Equatable {
    static func == (lhs: SideDishInfo, rhs: SideDishInfo) -> Bool {
        lhs.body == rhs.body
    }
    
    let statusCode: Int
    let body: [Menu]
}

struct Menu: Codable, Equatable {
    let detail_hash: String
    let image: String
    let delivery_type: [String]
    let title: String
    let description: String
    let n_price: String?
    let s_price: String?
    let badge: [String]?
}
