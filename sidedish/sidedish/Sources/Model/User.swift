//
//  User.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import FirebaseAuth
import Foundation

struct User: Codable {
    let name: String
    let accessToken: String
    let refreshToken: String?
    
    init(user: FirebaseAuth.User) {
        self.name = user.displayName ?? ""
        self.accessToken = ""
        self.refreshToken = user.refreshToken
    }
}
