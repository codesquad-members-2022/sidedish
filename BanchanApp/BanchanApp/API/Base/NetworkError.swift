//
//  NetworkError.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

enum NetworkError: Int, Error {
    case badRequest = 400
    case authenticationFailed = 401
    case notFound = 404
    case internalServer = 500
    case endpointError = 503
    case timeout = 504
    case unknownError = 1000
    case parsingError
}
