//
//  MainViewModel.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

struct MainViewModelAction {
    let viewDidLoad = PassthroughSubject<Void, Never>()
    let tappedLogoutButton = PassthroughSubject<Void, Never>()
}

struct MainViewModelState {
    let userData = PassthroughSubject<User, Never>()
    let loadedData = PassthroughSubject<Menu.Category, Never>()
    let loadedImage = PassthroughSubject<IndexPath, Never>()
    let presentLoginPage = PassthroughSubject<Void, Never>()
}

protocol MainViewModelBinding {
    var action: MainViewModelAction { get }
    var state: MainViewModelState { get }
}

protocol MainViewModelProperty {
    subscript(_ indexPath: IndexPath) -> Menu? { get }
    func getThumbnailUrl(indexPath: IndexPath) -> URL?
    func getMenuCount(_ type: Menu.Category) -> Int
}

typealias MainViewModelProtocol = MainViewModelBinding & MainViewModelProperty
typealias Menus = [Menu]

class MainViewModel: MainViewModelBinding, MainViewModelProperty {
    private var cancellables = Set<AnyCancellable>()
    
    private let sidedishRepository: SidedishRepository = SidedishRepositoryImpl()
    private let resourceRepository: ResourceRepository = ResourceRepositoryImpl()
    private let loginRepository: LoginRepository = LoginRepositoryImpl()
    
    private var menus = [Menu.Category: Menus]()
    private var thumbnailImages = [IndexPath: URL]()
    
    let action = MainViewModelAction()
    let state = MainViewModelState()
    
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
    
    init() {
        action.viewDidLoad
            .compactMap { Container.shared.userStore.user }
            .sink(receiveValue: state.userData.send(_:))
            .store(in: &cancellables)
        
        let request = action.viewDidLoad
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
                        self.state.loadedData.send(type)
                        self.loadThumbnailImage(type: type, menus: menus)
                    }.store(in: &self.cancellables)

                result
                    .compactMap { $0.error }
                    .sink { _ in
                        //TODO: 데이터 로드 시 에러 처리
                    }.store(in: &self.cancellables)
            }.store(in: &cancellables)

        action.tappedLogoutButton
            .compactMap { [weak self] _ in self?.loginRepository.signOut() }
            .switchToLatest()
            .handleEvents(receiveOutput: { Container.shared.userStore.user = nil })
            .sink(receiveValue: state.presentLoginPage.send(_:))
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
                    self?.state.loadedImage.send(indexPath)
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
