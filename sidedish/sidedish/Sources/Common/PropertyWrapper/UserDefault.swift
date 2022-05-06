//
//  UserDefaultPropertyWrapper.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Foundation

@propertyWrapper
struct UserDefault<Value> {
    let key: UserDefault.Key
    let defaultValue: Value?
    var container: UserDefaults = .standard
    
    var wrappedValue: Value? {
        get {
            container.object(forKey: key.value) as? Value ?? defaultValue
        }
        set {
            container.set(newValue, forKey: key.value)
        }
    }
    
    init(key: UserDefault.Key, defaultValue: Value? = nil) {
        self.key = key
        self.defaultValue = defaultValue
    }
}

enum UserDefaultKey: String {
    case userData
    case token
    
    var value: String { rawValue }
}

extension UserDefault {
    enum Key: String {
        case userData
        case token
        
        var value: String { rawValue }
    }
}
