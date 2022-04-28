//
//  MainViewModel.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

class MainViewModel: MainViewModelBinding, MainViewModelProperty, MainViewModelAction, MainViewModelState {
    func action() -> MainViewModelAction { self }
    
    let viewDidLoad = PassthroughSubject<Void, Never>()
    let tappedLogoutButton = PassthroughSubject<Void, Never>()
    
    func state() -> MainViewModelState { self }
    
    let userData = PassthroughSubject<User, Never>()
    let loadedData = PassthroughSubject<Menu.Category, Never>()
    let loadedImage = PassthroughSubject<IndexPath, Never>()
    let presentLoginPage = PassthroughSubject<Void, Never>()
    
    private var cancellables = Set<AnyCancellable>()
    private let sidedishRepository: SidedishRepository
    private let resourceRepository: ResourceRepository
    private let loginRepository: LoginRepository
    
    private var menus = [Menu.Category: Menus]()
    private var thumbnailImages = [IndexPath: URL]()
    
    subscript(_ indexPath: IndexPath) -> Menu? {
        guard let type = Menu.Category(rawValue: indexPath.section),
              let menus = self.menus[type] else {
            return nil
        }
        
        return menus[indexPath.item]
    }
    
    deinit {
        Log.debug("DeInit MainViewModel")
    }
    
    init(sidedishRepository: SidedishRepository, resourceRepository: ResourceRepository, loginRepository: LoginRepository) {
        self.sidedishRepository = sidedishRepository
        self.resourceRepository = resourceRepository
        self.loginRepository = loginRepository
        
        action().viewDidLoad
            .compactMap { Container.userStore.user }
            .sink(receiveValue: state().userData.send(_:))
            .store(in: &cancellables)
        
        let request = action().viewDidLoad
            .map { [weak self] _ in
                Menu.Category.allCases.publisher.compactMap { menu in
                    self?.sidedishRepository.loadMenu(menu)
                }
            }
            .switchToLatest()
            .share()
        
        request
            .sink { [weak self] result in
                guard let self = self else { return }
                result
                    .compactMap { $0.value }
                    .sink { type, menus in
                        self.menus[type] = menus
                        self.state().loadedData.send(type)
                        self.loadThumbnailImage(type: type, menus: menus)
                    }.store(in: &self.cancellables)

                result
                    .compactMap { $0.error }
                    .sink { _ in
                        //TODO: 데이터 로드 시 에러 처리
                    }.store(in: &self.cancellables)
            }.store(in: &cancellables)

        action().tappedLogoutButton
            .compactMap { [weak self] _ in self?.loginRepository.signOut() }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.userStore.user = nil })
            .sink(receiveValue: state().presentLoginPage.send(_:))
            .store(in: &cancellables)
    }
    
    private func loadThumbnailImage(type: Menu.Category, menus: [Menu]) {
        let imageUrls = menus.enumerated().map {
            (IndexPath(item: $0.offset, section: type.index), $0.element.image)
        }
        imageUrls.forEach { indexPath, url in
            resourceRepository.loadImage(url)
                .sink { [weak self] fileUrl in
                    self?.thumbnailImages[indexPath] = fileUrl
                    self?.state().loadedImage.send(indexPath)
                }
                .store(in: &cancellables)
        }
    }
    
    func getThumbnailUrl(indexPath: IndexPath) -> URL? {
        thumbnailImages[indexPath]
    }
    
    func getMenuCount(_ type: Menu.Category) -> Int {
        menus[type]?.count ?? 8
    }
}
