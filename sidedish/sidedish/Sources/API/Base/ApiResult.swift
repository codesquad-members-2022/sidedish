//
//  APIResult.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/08.
//

import Combine
import Foundation

struct ApiResult<T, Error: Swift.Error> {
    public private(set) var value: T?
    public private(set) var error: Error?
}
