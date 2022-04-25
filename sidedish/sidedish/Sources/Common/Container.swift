//
//  Container.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Foundation

class Container {
    private init() {}
    
    static let shared = Container()
}

extension Container {
    var userStore: UserStore {
        UserStore()
    }
}
