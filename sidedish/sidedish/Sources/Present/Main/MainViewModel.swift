//
//  MainViewModel.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

struct MainViewModelAction {
    let loadMain = PassthroughSubject<Void, Never>()
    let loadSide = PassthroughSubject<Void, Never>()
    let loadSoup = PassthroughSubject<Void, Never>()
}

struct MainViewModelState {
    let loadedData = PassthroughSubject<Sidedish.Menu, Never>()
}

protocol MainViewModelBinding {
    var action: MainViewModelAction { get }
    var state: MainViewModelState { get }
}

protocol MainViewModelProperty {
    subscript(_ indexPath: IndexPath) -> Sidedish? { get }
}

typealias MainViewModelProtocol = MainViewModelBinding & MainViewModelProperty

class MainViewModel: MainViewModelBinding, MainViewModelProperty {
    let action = MainViewModelAction()
    let state = MainViewModelState()
    
    subscript(_ indexPath: IndexPath) -> Sidedish? {
        guard let type = Sidedish.Menu(rawValue: indexPath.section),
              let menus = self.menus[type] else {
            return nil
        }
        
        return menus[indexPath.item]
    }
    
    private var cancellables = Set<AnyCancellable>()
    
    private let sidedishRepository: SidedishRepository = SidedishRepositoryImpl()
    private var menus = [Sidedish.Menu: [Sidedish]]()
    
    init() {
        
        let requestLoadMain = action.loadMain
            .map { self.sidedishRepository.loadMenu(.main) }
            .switchToLatest()
            .share()
        
        let requestLoadSide = action.loadSide
            .map { self.sidedishRepository.loadMenu(.side) }
            .switchToLatest()
            .share()
        
        let requestLoadSoup = action.loadSoup
            .map { self.sidedishRepository.loadMenu(.soup) }
            .switchToLatest()
            .share()
        
        Publishers
            .Merge3( requestLoadMain.map { ($0.value, Sidedish.Menu.main) }, requestLoadSide.map { ($0.value, Sidedish.Menu.side) }, requestLoadSoup.map { ($0.value, Sidedish.Menu.soup) }
            )
            .compactMap { result -> ([Sidedish], Sidedish.Menu)? in
                guard let menus = result.0 else {
                    return nil
                }
                return (menus, result.1)
            }
            .sink { menus, type in
                self.menus[type] = menus
                self.state.loadedData.send(type)
            }
            .store(in: &cancellables)
        
        Publishers
            .Merge3( requestLoadMain.compactMap { $0.error }, requestLoadSide.compactMap { $0.error }, requestLoadSoup.compactMap { $0.error }
            )
            .sink { error in
                print(error)
            }
            .store(in: &cancellables)
        
//        action.loadData
//            .map { menu in self.sidedishRepository.loadMenu(menu) }
//            .switchToLatest()
//            .sink { result in
//                print(result.error)
//                guard let sidedish = result.value else {
//                    return
//                }
//                print(sidedish)
//            }.store(in: &cancellables)
    }
}
