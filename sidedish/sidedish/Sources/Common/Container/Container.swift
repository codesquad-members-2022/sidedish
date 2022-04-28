//
//  Container.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Foundation
import UIKit

enum Container {
    static let userStore = UserStore()
    
    static var rootWindow: RootWindow? {
        guard let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
              let sceneDelegate = windowScene.delegate as? SceneDelegate,
              let rootWindow = sceneDelegate.window else {
            return nil
        }
        return rootWindow
    }
}
