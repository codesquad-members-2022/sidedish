//
//  LoginViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Combine
import FirebaseAuth
import Foundation

struct LoginViewModelAction {
    let viewDidLoad = PassthroughSubject<Void, Never>()
    let tappedGoogleLogin = PassthroughSubject<Void, Never>()
}

struct LoginViewModelState {
    let presentMainView = PassthroughSubject<Void, Never>()
    let loginFinish = PassthroughSubject<User, Never>()
}

protocol LoginViewModelBinding {
    var action: LoginViewModelAction { get }
    var state: LoginViewModelState { get }
}

protocol LoginViewDelegate: AnyObject {
    func getPresenting() -> UIViewController
}

protocol LoginViewModelProperty {
    var delegate: LoginViewDelegate? { get set }
}

typealias LoginViewModelProtocol = LoginViewModelBinding & LoginViewModelProperty

class LoginViewModel: LoginViewModelProtocol {
    
    private var cancellables = Set<AnyCancellable>()
    private let loginRepository: LoginRepository = LoginRepositoryImpl()
    
    let action = LoginViewModelAction()
    let state = LoginViewModelState()
    weak var delegate: LoginViewDelegate?
    
    init() {
        action.viewDidLoad
            .compactMap{ self.loginRepository.getUser() }
            .switchToLatest()
            .sink(receiveValue: state.presentMainView.send(_:))
            .store(in: &cancellables)
                    
        action.tappedGoogleLogin
            .compactMap { self.delegate?.getPresenting() }
            .map { self.loginRepository.googleLogin(viewController: $0) }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.shared.userStore.user = $0 })
            .sink(receiveValue: state.loginFinish.send(_:))
            .store(in: &cancellables)
    }
}
