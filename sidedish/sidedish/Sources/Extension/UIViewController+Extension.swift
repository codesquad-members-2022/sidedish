//
//  UIViewController+Extension.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import UIKit

extension UIViewController {
    func switchRootWindowState(_ state: RootWindow.State) {
        guard let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
              let sceneDelegate = windowScene.delegate as? SceneDelegate,
              let rootWindow = sceneDelegate.window else {
            return
        }
        rootWindow.switchRootWindowState.send(state)
    }
}
