//
//  Container.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Foundation
import UIKit

class Container {
    static var shared = Container()
    
    private init() { }
    
    lazy var userStore = UserStore()
    
    lazy var sidedishRepository: SidedishRepository = SidedishRepositoryImpl()

    lazy var resourceRepository: ResourceRepository = ResourceRepositoryImpl()

    lazy var loginRepository: LoginRepository = LoginRepositoryImpl()
}
