//
//  JSONConverter.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class JSONConverter {
    
    static func decodeJsonArray<T: Codable>(data: Data) -> [T]? { // JSON -> object
        do {
            let result = try JSONDecoder().decode([T].self, from: data)
            return result
        } catch { // 디코딩 실패시 에러를 던져줌 - error
            guard let error = error as? DecodingError else { return nil }
            
            switch error {
            case .dataCorrupted(let context):
                print(context.codingPath, context.debugDescription, context.underlyingError ?? "", separator: "\n")
                return nil
            default:
                return nil
            }
        }
    }
    
    static func encodeJson<T: Codable>(param: T) -> Data? { // object -> JSON
        do {
            let result = try JSONEncoder().encode(param)
            return result
        } catch {
            return nil
        }
    }
}
