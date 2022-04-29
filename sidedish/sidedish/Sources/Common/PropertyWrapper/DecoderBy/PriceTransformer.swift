//
//  PriceTransformer.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/27.
//

import Foundation

enum PriceTransformer<Source: Decodable>: DecodableTransformer {
    static func transform(form decodable: Source) throws -> Int {
        guard let price = decodable as? String else {
            return 0
        }
        let stringPrice = price.filter { $0.isNumber }
        return Int(stringPrice) ?? 0
    }
}
