//
//  BaseTarget.swift
//  Signup
//
//  Created by seongha shin on 2022/03/28.
//

import Foundation

protocol BaseTarget {
    var parameter: [String: Any]? { get }
    var path: String { get }
    var method: String { get }
}

extension BaseTarget {
    var baseURL: URL? {
        URL(string: "https://api.codesquad.kr/onban")
    }
}
