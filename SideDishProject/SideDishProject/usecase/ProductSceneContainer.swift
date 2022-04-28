//
//  ProductSceneContainer.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/22.
//

import UIKit

final class ProductSceneContainer {
    
    static func makeViewController(sceneType: SceneType) -> UIViewController{
        switch sceneType{
        case .home:
            //let model = HomeUsecase(repository: MockProductRepository())
            let model = HomeUsecase(repository: ProductNetworkRepository(service: ProductService()))
            let viewController = HomeViewController.create(with: model)
            return UINavigationController(rootViewController: viewController)
        case .detail(let uniqueId):
            let model = DetailUsecase(repository: MockDetailRepository(), uniqueId: uniqueId)
            return DetailViewController.create(with: model)
        }
    }
    
    enum SceneType{
        case home
        case detail(uniqueId: Int)
    }
}

