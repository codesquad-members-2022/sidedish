//
//  SplashViewModelProtocol.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import Combine
import Foundation

protocol SplashViewModelAction {
    var viewDidAppear: PassthroughSubject<Void, Never> { get }
}

protocol SplashViewModelState {
    var presentNextView: PassthroughSubject<RootWindow.State, Never> { get }
}

protocol SplashViewModelBinding {
    func action() -> SplashViewModelAction
    func state() -> SplashViewModelState
}

typealias SplashViewModelProtocol = SplashViewModelBinding
