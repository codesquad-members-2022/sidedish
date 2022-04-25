//
//  ProductSceneContainer.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/22.
//

import UIKit

final class ProductSceneContainer {
    
    static func makeViewController(sceneType: SceneType ,repository: ProductRepository) -> UIViewController{
        switch sceneType{
        case .home:
            let viewController = HomeViewController.create(with: repository)
            return RootNavigationController(rootViewController: viewController)
        case .detail:
            return DetailViewController.create(with: repository)
        }
    }
    
    enum SceneType{
        case home
        case detail
    }
}

