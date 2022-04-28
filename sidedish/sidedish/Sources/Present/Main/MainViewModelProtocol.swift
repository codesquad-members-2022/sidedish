//
//  MainViewModelProtocol.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import Combine
import Foundation

protocol MainViewModelAction {
    var viewDidLoad: PassthroughSubject<Void, Never> { get }
    var tappedLogoutButton: PassthroughSubject<Void, Never> { get }
}

protocol MainViewModelState {
    var userData: PassthroughSubject<User, Never> { get }
    var loadedData: PassthroughSubject<Menu.Category, Never> { get }
    var loadedImage: PassthroughSubject<IndexPath, Never> { get }
    var presentLoginPage: PassthroughSubject<Void, Never> { get }
}

protocol MainViewModelBinding {
    func action() -> MainViewModelAction
    func state() -> MainViewModelState
}

protocol MainViewModelProperty {
    subscript(_ indexPath: IndexPath) -> Menu? { get }
    func getThumbnailUrl(indexPath: IndexPath) -> URL?
    func getMenuCount(_ type: Menu.Category) -> Int
}

typealias MainViewModelProtocol = MainViewModelBinding & MainViewModelProperty
typealias Menus = [Menu]
