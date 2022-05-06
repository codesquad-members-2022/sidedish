//
//  HttpContentType.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import Foundation

enum HttpContentType: String {
    case json
    case urlencode
    
    var value: String {
        switch self {
        case .json:
            return "application/json; charset=utf-8"
        case .urlencode:
//            return "application/x-www-form-urlencoded"
            return "application/x-www-form-urlencoded; charset=utf-8"
        }
    }
}
