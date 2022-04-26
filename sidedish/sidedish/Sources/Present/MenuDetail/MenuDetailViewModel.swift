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
    let tappedPlusButton = PassthroughSubject<Void, Never>()
    let tappedMinusButton = PassthroughSubject<Void, Never>()
    let tappedOrderButton = PassthroughSubject<Void, Never>()
}

struct MenuDetailViewModelState {
    let loadedDetail = PassthroughSubject<(Sidedish, MenuDetail), Never>()
    let showError = PassthroughSubject<SessionError, Never>()
    let ordered = PassthroughSubject<Void, Never>()
    let amount = CurrentValueSubject<Int, Never>(1)
    let loadedThumbnail = PassthroughSubject<(Int, URL), Never>()
    let loadedDetailSection = PassthroughSubject<(Int, URL), Never>()
}

protocol MenuDetailViewModelBinding {
    var action: MenuDetailViewModelAction { get }
    var state: MenuDetailViewModelState { get }
}

typealias MenuDetailViewModelProtcol = MenuDetailViewModelBinding

final class MenuDetailViewModel: MenuDetailViewModelProtcol {
    
    private var cancellables = Set<AnyCancellable>()
    private let sidedishRepository: SidedishRepository = SidedishRepositoryImpl()
    private let resourceRepository: ResourceRepository = ResourceRepositoryImpl()
    
    let action = MenuDetailViewModelAction()
    let state = MenuDetailViewModelState()
    
    init(menu: Sidedish) {
        
        let requestDetail = action.loadMenuDetail
            .map { self.sidedishRepository.loadDetail(menu.hash) }
            .switchToLatest()
            .share()
        
        requestDetail
            .compactMap { $0.value }
            .sink { detail in
                self.state.loadedDetail.send((menu, detail))
                self.loadImage(detail: detail)
            }
            .store(in: &cancellables)
        
        Publishers
            .Merge(
                action.tappedPlusButton.map { 1 },
                action.tappedMinusButton.map { -1 }
            )
            .map {
                var amount = self.state.amount.value + $0
                amount = amount < 0 ? 0 : amount
                return amount
            }
            .sink(receiveValue: state.amount.send(_:))
            .store(in: &cancellables)
        
        action.tappedOrderButton
            .sink(receiveValue: state.ordered.send(_:))
            .store(in: &cancellables)
        
        requestDetail
            .compactMap { $0.error }
            .sink(receiveValue: state.showError.send(_:))
            .store(in: &cancellables)
    }
    
    private func loadImage(detail: MenuDetail) {
        detail.thumbImages.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { fileUrl in
                    self.state.loadedThumbnail.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
        
        detail.detailSection.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { fileUrl in
                    self.state.loadedDetailSection.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
    }
}
