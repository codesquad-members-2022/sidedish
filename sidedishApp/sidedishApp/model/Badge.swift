//
//  Badge.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation

enum Badge {
    case eventPrice
    case launchingPrice
    case mainPrice
    
    var description: String {
        switch self {
        case .eventPrice:
            return "이벤트특가"
        case .launchingPrice:
            return "런칭특가"
        case .mainPrice:
            return "메인특가"
        }
    }
}
