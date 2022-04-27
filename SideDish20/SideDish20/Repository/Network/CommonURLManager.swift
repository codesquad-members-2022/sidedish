//
//  CommonURLManager.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

class CommonURLManager {
    static let host = "https://api.codesquad.kr/onban"
   
    enum Endpoint: String {
        case main
        case soup
        case side
        
        var endpoint: String {
            return "\(host)/\(rawValue)"
        }
    }
}
