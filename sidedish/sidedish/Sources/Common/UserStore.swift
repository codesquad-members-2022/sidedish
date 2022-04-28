//
//  UserStore.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Foundation

class UserStore {
    
    private let encoder = JSONEncoder()
    private let decoder = JSONDecoder()
    
    @UserDefault(key: UserDefault.Key.userData) private var userData: Data?
    
    var user: User? {
        get {
            guard let data = self.userData,
                  let user = try? decoder.decode(User.self, from: data) else {
                return nil
            }
            return user
        }
        set {
            guard let data = try? encoder.encode(newValue) else {
                return
            }
            self.userData = data
        }
    }
    
    func clear() {
        self.userData = nil
    }
}
