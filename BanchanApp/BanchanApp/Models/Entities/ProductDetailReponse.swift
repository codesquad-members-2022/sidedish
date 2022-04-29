//
//  ProductDetailReponse.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/29.
//

import Foundation

struct ProductDetailResponse: Codable {
    let hash: String
    let data: ProductDetail
}
