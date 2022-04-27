//
//  SideDishModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/25.
//

import Foundation

protocol SideDishModel {
    var repository: RepositoryCommons { get }
    func callCacheSystem(userInfo: [String: Any]?) -> Any?
}

enum SideDishUseCase {
    case getCacheData
    case setCacheIndividually
}
