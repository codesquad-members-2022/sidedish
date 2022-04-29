//
//  ProductResponse.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

struct ProductResponse: Codable {
    let statusCode: Int
    let body: [Product]
}
