//
//  LoginViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import GoogleSignIn
import UIKit

class LoginViewController: UIViewController {
    let googleLoginButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.setTitle("구글 로그인", for: .normal)
        button.backgroundColor = .red
        return button
    }()
    
    private var cancellables = Set<AnyCancellable>()
    private var model: LoginViewModelProtocol = LoginViewModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        model.action.viewDidLoad.send()
    }
    
    private func bind() {
        model.state.presentMainView
            .sink {
                RootWindow.shared?.switchRootWindowState.send(.main)
            }
            .store(in: &cancellables)
        
        googleLoginButton.publisher(for: .touchUpInside)
            .sink(receiveValue: model.action.tappedGoogleLogin.send(_:))
            .store(in: &cancellables)
        
        model.state.presentGoogleLogin
            .sink { config in
                GIDSignIn.sharedInstance.signIn(with: config, presenting: self) { user, _ in
                    self.model.action.googleUser.send(user)
                }
            }.store(in: &cancellables)
    }
    
    private func attritbute() {
        view.backgroundColor = .white
    }
    
    private func layout() {
        view.addSubview(googleLoginButton)
        
        NSLayoutConstraint.activate([
            googleLoginButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            googleLoginButton.centerYAnchor.constraint(equalTo: view.centerYAnchor),
            googleLoginButton.widthAnchor.constraint(equalToConstant: 300),
            googleLoginButton.heightAnchor.constraint(equalToConstant: 50)
        ])
    }
}
