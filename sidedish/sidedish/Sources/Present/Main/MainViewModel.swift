//
//  MainViewModel.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

struct MainViewModelAction {
    let loadData = PassthroughSubject<[Sidedish.Menu], Never>()
}

struct MainViewModelState {
    let loadedData = PassthroughSubject<Sidedish.Menu, Never>()
    let loadedImage = PassthroughSubject<IndexPath, Never>()
}

protocol MainViewModelBinding {
    var action: MainViewModelAction { get }
    var state: MainViewModelState { get }
}

protocol MainViewModelProperty {
    subscript(_ indexPath: IndexPath) -> Sidedish? { get }
    func getThumbnailUrl(indexPath: IndexPath) -> URL?
    func getMenuCount(_ type: Sidedish.Menu) -> Int
}

typealias MainViewModelProtocol = MainViewModelBinding & MainViewModelProperty

class MainViewModel: MainViewModelBinding, MainViewModelProperty {
    private var cancellables = Set<AnyCancellable>()
    
    private let sidedishRepository: SidedishRepository = SidedishRepositoryImpl()
    private let resourceRepository: ResourceRepository = ResourceRepositoryImpl()
    
    private var menus = [Sidedish.Menu: [Sidedish]]()
    private var thumbnailImages = [IndexPath:URL]()
    
    let action = MainViewModelAction()
    let state = MainViewModelState()
    
    subscript(_ indexPath: IndexPath) -> Sidedish? {
        guard let type = Sidedish.Menu(rawValue: indexPath.section),
              let menus = self.menus[type] else {
            return nil
        }
        
        return menus[indexPath.item]
    }
    
    init() {
        let request = action.loadData
            .map { $0.publisher.map { self.sidedishRepository.loadMenu($0) } }
            .switchToLatest()
            .share()
        
        request
            .sink { result in
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
    }
    
    private func loadThumbnailImage(type: Sidedish.Menu, menus: [Sidedish]) {
        let imageUrls = menus.enumerated().map {
            (IndexPath(item: $0.offset, section: type.index), $0.element.image)
        }
        imageUrls.forEach { indexPath, url in
            resourceRepository.loadImage(url)
                .sink {
                    self.thumbnailImages[indexPath] = $0
                    self.state.loadedImage.send(indexPath)
                }
                .store(in: &cancellables)
        }
    }
    
    func getThumbnailUrl(indexPath: IndexPath) -> URL? {
        thumbnailImages[indexPath]
    }
    
    func getMenuCount(_ type: Sidedish.Menu) -> Int {
        menus[type]?.count ?? 0
    }
}
