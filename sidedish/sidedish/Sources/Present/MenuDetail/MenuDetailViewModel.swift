//
//  SidedishDetailViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import Foundation

final class MenuDetailViewModel: MenuDetailViewModelProtcol, MenuDetailViewModelAction, MenuDetailViewModelState {
    func action() -> MenuDetailViewModelAction { self }
    
    let loadMenuDetail = PassthroughSubject<Void, Never>()
    let tappedPlusButton = PassthroughSubject<Void, Never>()
    let tappedMinusButton = PassthroughSubject<Void, Never>()
    let tappedOrderButton = PassthroughSubject<Void, Never>()
    
    func state() -> MenuDetailViewModelState { self }
    
    let loadedDetail = PassthroughSubject<(Menu, MenuDetail), Never>()
    let showError = PassthroughSubject<SessionError, Never>()
    let ordered = PassthroughSubject<Void, Never>()
    let amount = CurrentValueSubject<Int, Never>(1)
    let totalPrice = PassthroughSubject<Int, Never>()
    let loadedThumbnail = PassthroughSubject<(Int, URL), Never>()
    let loadedDetailSection = PassthroughSubject<(Int, URL), Never>()
    
    @Inject(\.userStore) private var userStore: UserStore
    @Inject(\.sidedishRepository) private var sidedishRepository: SidedishRepository
    @Inject(\.resourceRepository) private var resourceRepository: ResourceRepository
    
    private var cancellables = Set<AnyCancellable>()
    
    deinit {
        Log.debug("DeInit MenuDetailViewModel")
    }
    
    init(menu: Menu, sidedishRepository: SidedishRepository, resourceRepository: ResourceRepository) {
        let requestDetail = action().loadMenuDetail
            .compactMap { [weak self] _ in self?.sidedishRepository.loadDetail(menu.hash) }
            .switchToLatest()
            .share()
        
        requestDetail
            .compactMap { $0.value }
            .sink { [weak self] detail in
                self?.state().loadedDetail.send((menu, detail))
                self?.loadImage(detail: detail)
            }
            .store(in: &cancellables)
        
        Publishers
            .Merge(
                action().tappedPlusButton.map { 1 },
                action().tappedMinusButton.map { -1 }
            )
            .map { [weak self] value -> Int in
                let amount = (self?.state().amount.value ?? 0) + value
                return amount < 1 ? 1 : amount
            }
            .sink { [weak self] amount in
                self?.state().amount.send(amount)
                self?.state().totalPrice.send(menu.price * amount)
            }
            .store(in: &cancellables)
        
        let requestOrder = action().tappedOrderButton
            .compactMap { [weak self] _ -> (String, String)? in
                guard let userName = self?.userStore.user?.name,
                      let count = self?.state().amount.value else {
                    return nil
                }
                let message = "\(menu.title) \(count)개 주문!"
                return (userName, message)
            }
            .compactMap { [weak self] name, message in self?.sidedishRepository.order(name, message: message) }
            .switchToLatest()
            .share()

        requestOrder
            .compactMap { $0.value }
            .map { _ in }
            .sink(receiveValue: state().ordered.send(_:))
            .store(in: &cancellables)
        
        requestDetail
            .compactMap { $0.error }
            .sink(receiveValue: state().showError.send(_:))
            .store(in: &cancellables)
    }
    
    private func loadImage(detail: MenuDetail) {
        detail.thumbImages.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { [weak self] fileUrl in
                    self?.state().loadedThumbnail.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
        
        detail.detailSection.enumerated().forEach { index, url in
            resourceRepository.loadImage(url)
                .sink { [weak self] fileUrl in
                    self?.state().loadedDetailSection.send((index, fileUrl))
                }.store(in: &self.cancellables)
        }
    }
}
