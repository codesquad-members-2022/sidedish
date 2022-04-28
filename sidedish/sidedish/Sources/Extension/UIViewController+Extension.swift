//
//  UIViewController+Extension.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import UIKit

extension UIViewController {
    func switchRootWindowState(_ state: RootWindow.State) {
        Container.rootWindow?.switchRootWindowState.send(state)
    }
}
