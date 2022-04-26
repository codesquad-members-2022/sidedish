//
//  SplashViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/26.
//

import Combine
import Foundation

struct SplashViewModelAction {
    let viewDidAppear = PassthroughSubject<Void, Never>()
}

struct SplashViewModelState {
    let presentNextView = PassthroughSubject<RootWindow.State, Never>()
}

protocol SplashViewModelBinding {
    var action: SplashViewModelAction { get }
    var state: SplashViewModelState { get }
}

typealias SplashViewModelProtocol = SplashViewModelBinding

class SplashViewModel: SplashViewModelProtocol {
    private let loginRepository: LoginRepository = LoginRepositoryImpl()
    private var cancellables = Set<AnyCancellable>()
    
    let action = SplashViewModelAction()
    let state = SplashViewModelState()
    
    deinit {
        Log.debug("DeInit SplashViewModel")
    }
    
    init() {
        action.viewDidAppear
            .compactMap { [weak self] _ in self?.loginRepository.getUser() }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.shared.userStore.user = $0 })
            .map { user -> RootWindow.State in user == nil ? .login : .main }
            .sink(receiveValue: state.presentNextView.send(_:))
            .store(in: &cancellables)
    }
}
