//
//  SidedishTarget.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Foundation

enum SidedishEndPoint: EndPoint {
    case loadMenu(_ type: Menu.Category)
    case loadDetail(_ hash: String)
}

extension SidedishEndPoint {
    var path: String {
        switch self {
        case .loadMenu(let type):
            return "/\(type)"
        case .loadDetail(let hash):
            return "/detail/\(hash)"
        }
    }
    
    var parameter: [String: Any]? {
        switch self {
        case .loadMenu, .loadDetail:
            return nil
        }
    }
    var method: HTTPMethod {
        switch self {
        case .loadMenu, .loadDetail:
            return .get
        }
    }
}
