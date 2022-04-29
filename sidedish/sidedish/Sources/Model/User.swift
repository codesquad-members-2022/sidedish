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
    
    init(user: FirebaseAuth.User) {
        self.name = user.displayName ?? ""
    }
}
