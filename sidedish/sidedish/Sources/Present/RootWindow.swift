//
//  RootWindow.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/26.
//

import Combine
import UIKit

class RootWindow: UIWindow {
    static var shared: RootWindow? {
        let window = UIApplication.shared.windows.first { $0.isKeyWindow }
        return window as? RootWindow
    }
    
    private var cancellables = Set<AnyCancellable>()
    let switchRootWindowState = PassthroughSubject<State, Never>()
    
    override init(windowScene: UIWindowScene) {
        super.init(windowScene: windowScene)
        overrideUserInterfaceStyle = .light
        rootViewController = RootWindow.State.splash.viewController
        
        switchRootWindowState
            .compactMap { $0.viewController }
            .sink {
                self.rootViewController = $0
            }.store(in: &cancellables)
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}

extension RootWindow {
    enum State {
        case splash, login, main
        
        var viewController: UIViewController {
            switch self {
            case .splash:
                return SplashViewController(viewModel: SplashViewModel())
            case .login:
                return LoginViewController(viewModel: LoginViewModel(loginRepository: LoginRepositoryImpl()))
            case .main:
                return UINavigationController(rootViewController: MainViewController(viewModel: MainViewModel(sidedishRepository: SidedishRepositoryImpl(), resourceRepository: ResourceRepositoryImpl(), loginRepository: LoginRepositoryImpl())))
            }
        }
    }
}
