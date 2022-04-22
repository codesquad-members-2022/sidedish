//
//  HTTPMethod.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/21.
//

import Foundation

enum HTTPMethod: String {
    case get
    case put
    case post
    case delete
    
    var value: String {
        self.rawValue.uppercased()
    }
}
