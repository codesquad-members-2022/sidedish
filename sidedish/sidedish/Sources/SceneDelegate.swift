//
//  SceneDelegate.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: RootWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let scene = (scene as? UIWindowScene) else { return }
        
        self.window = RootWindow(windowScene: scene)
        window?.makeKeyAndVisible()
    }
}
