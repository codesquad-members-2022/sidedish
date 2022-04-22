//
//  SidedishRepository.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//
import Combine
import Foundation

protocol SidedishRepository {
    func loadMenu(_ type: Sidedish.Menu) -> AnyPublisher<ApiResult<(Sidedish.Menu, [Sidedish]), SessionError>, Never>
    func loadDetail(_ hash: String) -> AnyPublisher<ApiResult<MenuDetail, SessionError>, Never>
}
