//
//  CommonViewModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/27.
//

import Foundation

class CommonViewModel {

    private var models = [SideDishUseCase: SideDishModel]()

    func getModel(useCase: SideDishUseCase) -> SideDishModel {
        if let middleWare = models[useCase] {
            return middleWare
        } else {
            let model = CacheModelFactory.make(useCase: useCase)
            models[useCase] = model
            return model
        }
    }
}
