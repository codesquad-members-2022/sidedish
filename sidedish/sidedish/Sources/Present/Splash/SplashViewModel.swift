//
//  SplashViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/26.
//

import Combine
import Foundation

class SplashViewModel: SplashViewModelProtocol, SplashViewModelAction, SplashViewModelState {
    func action() -> SplashViewModelAction { self }
    
    let viewDidAppear = PassthroughSubject<Void, Never>()
    
    func state() -> SplashViewModelState { self }
    
    let presentNextView = PassthroughSubject<RootWindow.State, Never>()
    
    private var cancellables = Set<AnyCancellable>()
    private let loginRepository: LoginRepository = LoginRepositoryImpl()
    
    deinit {
        Log.debug("DeInit SplashViewModel")
    }
    
    init() {
        action().viewDidAppear
            .compactMap { [weak self] _ in self?.loginRepository.getUser() }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.userStore.user = $0 })
            .map { user -> RootWindow.State in user == nil ? .login : .main }
            .sink(receiveValue: state().presentNextView.send(_:))
            .store(in: &cancellables)
    }
}
