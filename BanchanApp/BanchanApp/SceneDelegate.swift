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

        let viewController = BanchanListViewController(collectionViewLayout: UICollectionViewLayout())
		let repository = RemoteRepository()
		let service = Service(repository: repository)
		let viewModel = BanchanListViewModel(service: service)

		viewController.viewModel = viewModel

        let navigationController = UINavigationController(rootViewController: viewController)

        self.window?.rootViewController = navigationController
        self.window?.makeKeyAndVisible()
    }
}
