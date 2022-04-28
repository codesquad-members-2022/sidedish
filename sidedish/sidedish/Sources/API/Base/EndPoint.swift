//
//  EndPoint.swift
//  Signup
//
//  Created by seongha shin on 2022/03/28.
//

import Foundation

protocol EndPoint {
    var baseUrl: URL { get }
    var path: String { get }
    var parameter: [String: Any]? { get }
    var method: HTTPMethod { get }
    var contentType: HttpContentType { get }
}
