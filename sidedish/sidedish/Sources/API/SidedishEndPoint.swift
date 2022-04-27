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
    case order(_ name: String, message: String)
}

extension SidedishEndPoint {
    var baseUrl: URL {
        switch self {
        case .loadMenu, .loadDetail:
            return Environment.codesquadUrl
        case .order:
            return Environment.slackUrl
        }
    }
    var path: String {
        switch self {
        case .loadMenu(let type):
            return "/\(type)"
        case .loadDetail(let hash):
            return "/detail/\(hash)"
        case .order:
            return ""
        }
    }
    
    var parameter: [String: Any]? {
        switch self {
        case .loadMenu, .loadDetail:
            return nil
        case .order(let name, let message):
            return ["channel": "#모바일ios-generic", "username": name, "text": message, "icon_emoji": ":ghost:"]
        }
    }
    var method: HTTPMethod {
        switch self {
        case .loadMenu, .loadDetail:
            return .get
        case .order:
            return .post
        }
    }
}
