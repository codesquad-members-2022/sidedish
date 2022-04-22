//
//  EndPoint.swift
//  Signup
//
//  Created by seongha shin on 2022/03/28.
//

import Foundation

protocol EndPoint {
    var parameter: [String: Any]? { get }
    var path: String { get }
    var method: HTTPMethod { get }
}

extension EndPoint {
    var baseURL: URL? {
        URL(string: "https://api.codesquad.kr/onban")
    }
}
