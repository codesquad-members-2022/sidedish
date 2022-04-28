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
    private let model: SplashViewModelProtocol
    
    init(viewModel: SplashViewModelProtocol) {
        self.model = viewModel
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    deinit {
        Log.debug("DeInit SplashViewController")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        model.state().presentNextView
            .sink {
                RootWindow.shared?.switchRootWindowState.send($0)
            }
            .store(in: &cancellables)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        model.action().viewDidAppear.send()
    }
}
