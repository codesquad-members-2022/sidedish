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
    let loadedDetail = PassthroughSubject<(Menu, MenuDetail), Never>()
    let showError = PassthroughSubject<SessionError, Never>()
    let ordered = PassthroughSubject<Void, Never>()
    let amount = CurrentValueSubject<Int, Never>(1)
    let totalPrice = PassthroughSubject<Int, Never>()
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
    
    deinit {
        Log.debug("DeInit MenuDetailViewModel")
    }
    
    init(menu: Menu) {
        
        let requestDetail = action.loadMenuDetail
            .compactMap { [weak self] _ in self?.sidedishRepository.loadDetail(menu.hash) }
            .switchToLatest()
            .share()
        
        requestDetail
            .compactMap { $0.value }
            .sink { [weak self] detail in
                self?.state.loadedDetail.send((menu, detail))
                self?.loadImage(detail: detail)
            }
            .store(in: &cancellables)
        
        Publishers
            .Merge(
                action.tappedPlusButton.map { 1 },
                action.tappedMinusButton.map { -1 }
            )
            .map { [weak self] value -> Int in
                var amount = (self?.state.amount.value ?? 0) + value
                amount = amount < 1 ? 1 : amount
                return amount
            }
            .sink { [weak self] amount in
                self?.state.amount.send(amount)
                self?.state.totalPrice.send(menu.price * amount)
            }
            .store(in: &cancellables)
        
        let requestOrder = action.tappedOrderButton
            .compactMap { [weak self] _ -> AnyPublisher<ApiResult<Void, SessionError>, Never>? in
                guard let userName = Container.shared.userStore.user?.name,
                      let count = self?.state.amount.value else {
                    return nil
                }

                let message = "\(menu.title) \(count)개 주문!"
                return self?.sidedishRepository.order(userName, message: message)
            }
            .switchToLatest()
            .share()

        requestOrder
            .compactMap { $0.value }
            .sink { [weak self] _ in
                self?.state.ordered.send()
            }
            .store(in: &cancellables)
        
        requestDetail
            .compactMap { $0.error }
            .sink(receiveValue: state.showError.send(_:))
            .store(in: &cancellables)
    }
    
    private func loadImage(detail: MenuDetail) {
        detail.thumbImages.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { [weak self] fileUrl in
                    self?.state.loadedThumbnail.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
        
        detail.detailSection.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { [weak self] fileUrl in
                    self?.state.loadedDetailSection.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
    }
}
