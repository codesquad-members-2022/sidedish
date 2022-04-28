//
//  SidedishRepositoryImpl.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

class SidedishRepositoryImpl: NetworkApiRepository<SidedishEndPoint>, SidedishRepository {
    
    func loadMenu(_ type: Menu.Category) -> AnyPublisher<ApiResult<(Menu.Category, [Menu]), SessionError>, Never> {
        request(.loadMenu(type))
            .map { $0.decode(SidedishAPIResult.self) }
            .map { result -> ApiResult<(Menu.Category, [Menu]), SessionError> in
                if let error = result.error {
                    return ApiResult(value: nil, error: error)
                }
                if let result = result.value,
                   (200..<300).contains(result.statusCode) {
                    return ApiResult(value: (type, result.body), error: nil)
                } else {
                    return ApiResult(value: nil, error: .statusCodeError)
                }
            }
            .eraseToAnyPublisher()
    }
    
    func loadDetail(_ hash: String) -> AnyPublisher<ApiResult<MenuDetail, SessionError>, Never> {
        request(.loadDetail(hash))
            .map { $0.decode(MenuDetailApi.self) }
            .map { result -> ApiResult<MenuDetail, SessionError> in
                if let error = result.error {
                    return ApiResult(value: nil, error: error)
                }
                
                if let result = result.value {
                    return ApiResult(value: result.data, error: nil)
                } else {
                    return ApiResult(value: nil, error: .statusCodeError)
                }
            }
            .eraseToAnyPublisher()
    }
}
