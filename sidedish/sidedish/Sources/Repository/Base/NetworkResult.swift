//
//  NetworkResult.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import Combine
import Foundation

struct NetworkResult {
    private let data: Data?
    private let error: SessionError?
    
    init(_ data: Data) {
        self.data = data
        self.error = nil
    }
    
    init(_ error: SessionError) {
        self.data = nil
        self.error = error
    }
}

extension NetworkResult {
    func decode<T: Decodable>(_ type: T.Type) -> ApiResult<T, SessionError> {
        guard error == nil else {
            return ApiResult(value: nil, error: error)
        }
        
        guard let data = data,
              let decodableData = try? JSONDecoder().decode(T.self, from: data) else {
            return ApiResult(value: nil, error: .pasingError)
        }
        return ApiResult(value: decodableData, error: nil)
    }
    
    func mapVoid() -> ApiResult<Void, SessionError> {
        ApiResult(value: error == nil ? () : nil, error: error)
    }
    
    func mapValue<V>(_ value: V) -> ApiResult<V, SessionError> {
        ApiResult(value: error == nil ? value : nil, error: error)
    }
}
