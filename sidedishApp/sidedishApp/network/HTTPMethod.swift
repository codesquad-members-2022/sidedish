//
//  HTTPMethod.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/28.
//

import Foundation

enum HTTPMethod: String {
    case get = "GET"
    case post = "POST"
    
    func getRawValue() -> String {
        return self.rawValue
    }
}
