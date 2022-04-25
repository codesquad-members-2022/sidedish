//
//  LoginViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
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
        
        model.action.viewDidLoad.send()
    }
    
    private func bind() {
        model.delegate = self
        
        model.state.presentMainView
            .sink {
                self.navigationController?.pushViewController(MainViewController(), animated: true)
            }
            .store(in: &cancellables)
        
        googleLoginButton.publisher(for: .touchUpInside)
            .sink(receiveValue: model.action.tappedGoogleLogin.send(_:))
            .store(in: &cancellables)
        
        model.state.loginFinish
            .sink {
                print($0.name)
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

extension LoginViewController: LoginViewDelegate {
    func getPresenting() -> UIViewController {
        self
    }
}
