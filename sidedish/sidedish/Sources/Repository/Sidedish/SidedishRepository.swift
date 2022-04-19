//
//  SidedishRepository.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//
import Combine
import Foundation

protocol SidedishRepository {
    func loadMain() -> AnyPublisher<ApiResult<Sidedish, SessionError>, Never>
}
