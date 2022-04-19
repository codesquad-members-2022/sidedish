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
            .map { $0.decode([Sidedish].self) }
            .eraseToAnyPublisher()
    }
}
