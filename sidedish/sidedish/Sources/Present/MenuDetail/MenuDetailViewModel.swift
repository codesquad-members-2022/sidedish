//
//  SidedishDetailViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import Foundation

struct MenuDetailViewModelAction {
    let loadMenuDetail = PassthroughSubject<Void, Never>()
    let plusAmount = PassthroughSubject<Void, Never>()
    let minusAmount = PassthroughSubject<Void, Never>()
}

struct MenuDetailViewModelState {
    let loadedDetail = PassthroughSubject<(Sidedish, MenuDetail), Never>()
    let showError = PassthroughSubject<SessionError, Never>()
    let amount = CurrentValueSubject<Int, Never>(1)
}

protocol MenuDetailViewModelBinding {
    var action: MenuDetailViewModelAction { get }
    var state: MenuDetailViewModelState { get }
}

typealias MenuDetailViewModelProtcol = MenuDetailViewModelBinding

final class MenuDetailViewModel: MenuDetailViewModelProtcol {
    
    private var cancellables = Set<AnyCancellable>()
    private let sidedishRepository: SidedishRepository = SidedishRepositoryImpl()
    
    let action = MenuDetailViewModelAction()
    let state = MenuDetailViewModelState()
    
    init(menu: Sidedish) {
        
        let requestDetail = action.loadMenuDetail
            .map { self.sidedishRepository.loadDetail(menu.hash) }
            .switchToLatest()
            .share()
        
        requestDetail
            .compactMap { $0.value }
            .sink {
                self.state.loadedDetail.send((menu, $0))
            }
            .store(in: &cancellables)
        
        requestDetail
            .compactMap { $0.error }
            .sink(receiveValue: state.showError.send(_:))
            .store(in: &cancellables)
        
        Publishers
            .Merge(
                action.plusAmount.map { 1 },
                action.minusAmount.map { -1 }
            )
            .map {
                var amount = self.state.amount.value + $0
                amount = amount < 0 ? 0 : amount
                return amount
            }
            .sink(receiveValue: state.amount.send(_:))
            .store(in: &cancellables)
    }
}
