//
//  SceneDelegate.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/18.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        if let windowScene = scene as? UIWindowScene {
            let window = UIWindow(windowScene: windowScene)
            window.rootViewController = ProductSceneContainer.makeRoot(repository: MockProductRepository())
            self.window = window
            window.makeKeyAndVisible()
        }
    }
}

final class ProductSceneContainer {
    static func makeRoot(repository: ProductRepository) -> UIViewController {
        let viewController = HomeViewController.create(with: repository)
        return RootNavigationController(rootViewController: viewController)
    }
    
    static func makeDetail(repository: ProductRepository) -> UIViewController {
        return DetailViewController.create(with: repository)
    }
    
}
