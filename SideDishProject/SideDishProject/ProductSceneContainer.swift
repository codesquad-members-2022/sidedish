//
//  ProductSceneContainer.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/22.
//

import UIKit

final class ProductSceneContainer {
    static func makeRoot(repository: ProductRepository) -> UIViewController {
        let viewController = HomeViewController.create(with: repository)
        return RootNavigationController(rootViewController: viewController)
    }
    
    static func makeDetail(repository: ProductRepository) -> UIViewController {
        return DetailViewController.create(with: repository)
    }
}
