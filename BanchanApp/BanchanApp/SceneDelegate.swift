//
//  SceneDelegate.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/18.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo _: UISceneSession, options _: UIScene.ConnectionOptions) {
        guard let scene = (scene as? UIWindowScene) else { return }

        self.window = UIWindow(windowScene: scene)

        guard let viewController = UIStoryboard(name: "BanchanListViewController", bundle: nil)
            .instantiateInitialViewController() else { return }

        let navigationController = UINavigationController(rootViewController: viewController)

        self.window?.rootViewController = navigationController
        self.window?.makeKeyAndVisible()
    }
}
