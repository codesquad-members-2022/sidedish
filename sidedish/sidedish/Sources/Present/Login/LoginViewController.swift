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
    private let model: LoginViewModelProtocol
    
    init(viewModel: LoginViewModelProtocol) {
        self.model = viewModel
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    deinit {
        Log.debug("DeInit LoginViewController")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attritbute()
        layout()
    }
    
    private func bind() {
        model.state().presentMainView
            .sink {
                RootWindow.shared?.switchRootWindowState.send(.main)
            }
            .store(in: &cancellables)
        
        googleLoginButton.publisher(for: .touchUpInside)
            .sink(receiveValue: model.action().tappedGoogleLogin.send(_:))
            .store(in: &cancellables)
        
        model.state().presentGoogleLogin
            .sink { [weak self] config in
                guard let self = self else { return }
                GIDSignIn.sharedInstance.signIn(with: config, presenting: self) { user, _ in
                    self.model.action().googleUser.send(user)
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
