//
//  NetworkError.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation

enum NetworkError: Error {
    case noData
    case wrongBaseEndPoint
    case wrongEndPoint
}

extension NetworkError: LocalizedError {
    var errorDescription: String? {
        switch self {
        case .noData: return NSLocalizedString("\(self)", comment: "No Data")
        case .wrongBaseEndPoint: return NSLocalizedString("\(self)", comment: "Wrong Base Endpoint")
        case .wrongEndPoint: return NSLocalizedString("\(self)", comment: "Wrong EndPoint")
        }
    }
}
