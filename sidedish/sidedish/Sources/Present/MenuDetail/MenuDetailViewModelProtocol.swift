//
//  MenuDetailViewModelProtocol.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/28.
//

import Combine
import Foundation

protocol MenuDetailViewModelAction {
    var loadMenuDetail: PassthroughSubject<Void, Never> { get }
    var tappedPlusButton: PassthroughSubject<Void, Never> { get }
    var tappedMinusButton: PassthroughSubject<Void, Never> { get }
    var tappedOrderButton: PassthroughSubject<Void, Never> { get }
}

protocol MenuDetailViewModelState {
    var loadedDetail: PassthroughSubject<(Menu, MenuDetail), Never> { get }
    var showError: PassthroughSubject<SessionError, Never> { get }
    var ordered: PassthroughSubject<Void, Never> { get }
    var amount: CurrentValueSubject<Int, Never> { get }
    var totalPrice: PassthroughSubject<Int, Never> { get }
    var loadedThumbnail: PassthroughSubject<(Int, URL), Never> { get }
    var loadedDetailSection: PassthroughSubject<(Int, URL), Never> { get }
}

protocol MenuDetailViewModelBinding {
    func action() -> MenuDetailViewModelAction
    func state() -> MenuDetailViewModelState
}

typealias MenuDetailViewModelProtcol = MenuDetailViewModelBinding
