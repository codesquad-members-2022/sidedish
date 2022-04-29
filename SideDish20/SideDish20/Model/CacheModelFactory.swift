//
//  CacheModelFactory.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/25.
//

import Foundation

class CacheModelFactory {
    static func make(useCase: SideDishUseCase) -> SideDishModel {
        switch useCase {
        case .getCacheData:
            return CacheImageRequestModel()
        case .setCacheIndividually:
            return CacheImageModel()
        }
    }
}
