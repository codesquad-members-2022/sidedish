//
//  SidedishTarget.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Foundation

enum SidedishTarget: BaseTarget {
    case loadMenu(_ type: Sidedish.`Type`)
    case loadDetail(_ hash: String)
}

extension SidedishTarget {
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
    var method: String {
        switch self {
        case .loadMenu, .loadDetail:
            return "GET"
        }
    }
}
