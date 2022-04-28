//
//  NetworkResult.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

enum NetworkResult<T> {
    case success(T)
    case failure(NetworkError)
}
