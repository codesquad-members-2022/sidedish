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
    
    @Inject(\.userStore) private var userStore: UserStore
    @Inject(\.loginRepository) private var loginRepository: LoginRepository
    
    private var cancellables = Set<AnyCancellable>()
    
    deinit {
        Log.debug("DeInit SplashViewModel")
    }
    
    init() {
        action().viewDidAppear
            .compactMap { [weak self] _ in self?.loginRepository.getUser() }
            .switchToLatest()
            .handleEvents(receiveOutput: { [weak self] user in self?.userStore.user = user })
            .map { user -> RootWindow.State in user == nil ? .login : .main }
            .sink(receiveValue: state().presentNextView.send(_:))
            .store(in: &cancellables)
    }
}
