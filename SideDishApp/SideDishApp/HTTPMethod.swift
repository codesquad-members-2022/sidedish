//
//  HTTPMethod.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

enum HTTPMethod: String, CustomStringConvertible {
    
    case get
    case post
    case put
    case delete
    case patch
    
    var description: String {
        return self.rawValue.uppercased()
    }
}
