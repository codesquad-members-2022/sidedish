//
//  SplashViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/26.
//

import Combine
import UIKit

class SplashViewController: UIViewController {
    
    private var cancellables = Set<AnyCancellable>()
    private var model: SplashViewModelProtocol = SplashViewModel()
    
    deinit {
        Log.debug("DeInit SplashViewController")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        model.state.presentNextView
            .sink {
                RootWindow.shared?.switchRootWindowState.send($0)
            }
            .store(in: &cancellables)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        model.action.viewDidAppear.send()
    }
}
