//
//  NetworkError.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

enum NetworkError: Error {
    case invalidURL
    case invalidResponse(statusCode: Int)
    case transportError(Error)
    case encodingError
    case decodingError
    case emptyData
    case emptyLocation
    case otherError(Error)
}
