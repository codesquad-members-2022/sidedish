//
//  LoginViewModelProtocol.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import Combine
import Foundation
import GoogleSignIn

protocol LoginViewModelAction {
    var tappedGoogleLogin: PassthroughSubject<Void, Never> { get }
    var googleUser: PassthroughSubject<GIDGoogleUser?, Never> { get }
}

protocol LoginViewModelState {
    var presentMainView: PassthroughSubject<Void, Never> { get }
    var presentGoogleLogin: PassthroughSubject<GIDConfiguration, Never> { get }
}

protocol LoginViewModelBinding {
    func action() -> LoginViewModelAction
    func state() -> LoginViewModelState
}

typealias LoginViewModelProtocol = LoginViewModelBinding
