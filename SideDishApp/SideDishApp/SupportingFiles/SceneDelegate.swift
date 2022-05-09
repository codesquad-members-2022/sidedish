//
//  SceneDelegate.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let windowScene = (scene as? UIWindowScene) else { return }
        window = UIWindow(windowScene: windowScene)
        let orderingViewController = OrderingViewController()
        orderingViewController.networkManager = NetworkManager(session: .shared)
        let rootViewController = UINavigationController(rootViewController: orderingViewController)
        window?.rootViewController = rootViewController
        window?.makeKeyAndVisible()
    }
}
