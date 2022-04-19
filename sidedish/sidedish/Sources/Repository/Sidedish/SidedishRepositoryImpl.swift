//
//  SidedishRepositoryImpl.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

class SidedishRepositoryImpl: NetworkRepository<SidedishTarget>, SidedishRepository {
    func loadMain() -> AnyPublisher<ApiResult<[Sidedish], SessionError>, Never> {
        request(.loadMain)
            .map { $0.decode(SidedishAPIResult.self) }
            .map { result -> ApiResult<[Sidedish], SessionError> in
                if let error = result.error {
                    return ApiResult(value: nil, error: error)
                }
                if let result = result.value,
                   (200..<300).contains(result.statusCode) {
                    return ApiResult(value: result.body, error: nil)
                } else {
                    return ApiResult(value: nil, error: .statusCodeError)
                }
            }
            .eraseToAnyPublisher()
    }
}
