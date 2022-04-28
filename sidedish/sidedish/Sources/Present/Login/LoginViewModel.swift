//
//  LoginViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Combine
import FirebaseAuth
import FirebaseCore
import Foundation
import GoogleSignIn

class LoginViewModel: LoginViewModelProtocol, LoginViewModelAction, LoginViewModelState {
    func action() -> LoginViewModelAction { self }
    
    let tappedGoogleLogin = PassthroughSubject<Void, Never>()
    let googleUser = PassthroughSubject<GIDGoogleUser?, Never>()
    
    func state() -> LoginViewModelState { self }
    
    let presentMainView = PassthroughSubject<Void, Never>()
    let presentGoogleLogin = PassthroughSubject<GIDConfiguration, Never>()
    
    private var cancellables = Set<AnyCancellable>()
    private let loginRepository: LoginRepository
    
    deinit {
        Log.debug("DeInit LoginViewModel")
    }
    
    init(loginRepository: LoginRepository) {
        self.loginRepository = loginRepository
        
        action().tappedGoogleLogin
            .compactMap { _ -> GIDConfiguration? in
                guard let clientId = FirebaseApp.app()?.options.clientID else {
                    return nil
                }
                return GIDConfiguration(clientID: clientId)
            }
            .sink(receiveValue: state().presentGoogleLogin.send(_:))
            .store(in: &cancellables)
        
        action().googleUser
            .compactMap { user -> AuthCredential? in
                guard let authentication = user?.authentication,
                      let idToken = authentication.idToken else {
                    return nil
                }
                return GoogleAuthProvider.credential(withIDToken: idToken, accessToken: authentication.accessToken)
            }
            .compactMap { [weak self] credential in self?.loginRepository.googleLogin(authCredential: credential) }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.userStore.user = $0 })
            .map { _ in }
            .sink(receiveValue: state().presentMainView.send(_:))
            .store(in: &cancellables)
    }
}
