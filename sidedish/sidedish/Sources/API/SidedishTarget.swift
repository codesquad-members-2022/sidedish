//
//  SidedishTarget.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Foundation

enum SidedishTarget: BaseTarget {
    case loadMain
    
}

extension SidedishTarget {
    var path: String {
        switch self {
        case .loadMain: return "/main"
        }
    }
    
    var parameter: [String : Any]? {
        switch self {
        case .loadMain: return nil
        }
    }
    var method: String {
        switch self {
        case .loadMain: return "GET"
        }
    }
}
