//
//  LoginViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import GoogleSignIn
import SnapKit
import UIKit

class LoginViewController: UIViewController {
    let googleLoginButton: UIButton = {
        var config = UIButton.Configuration.bordered()
        config.baseBackgroundColor = .white
        config.cornerStyle = .capsule
        config.background.cornerRadius = 20
        config.background.strokeColor = .grey3
        config.title = "구글 로그인"
        config.baseForegroundColor = .black
        config.image = UIImage(named: "Google_Logo")
        config.imagePadding = 10
        config.imagePlacement = .leading
       
        let button = UIButton(configuration: config)
        return button
    }()
    
    let loadingIndicator: UIActivityIndicatorView = {
        let indicator = UIActivityIndicatorView(style: .large)
        indicator.hidesWhenStopped = false
        indicator.isHidden = true
        return indicator
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
            .map { .main }
            .sink { [weak self] state in self?.switchRootWindowState(state) }
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
        
        model.state().showLoadingIndicator
            .sink { [weak self] isShow in
                self?.loadingIndicator.isHidden = !isShow
                isShow ? self?.loadingIndicator.startAnimating() : self?.loadingIndicator.stopAnimating()
            }.store(in: &cancellables)
    }
    
    private func attritbute() {
        view.backgroundColor = .white
    }
    
    private func layout() {
        view.addSubview(googleLoginButton)
        view.addSubview(loadingIndicator)
        
        googleLoginButton.snp.makeConstraints {
            $0.center.equalToSuperview()
            $0.width.equalTo(300)
            $0.height.equalTo(60)
        }
        
        loadingIndicator.snp.makeConstraints {
            $0.edges.equalToSuperview()
        }
    }
}
