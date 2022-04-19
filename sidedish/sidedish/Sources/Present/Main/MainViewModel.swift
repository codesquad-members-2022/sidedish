//
//  MainViewModel.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import Combine
import Foundation

struct MainViewModelAction {
    let loadData = PassthroughSubject<Void, Never>()
}

struct MainViewModelState {
    let loadedData = PassthroughSubject<Int, Never>()
}

protocol MainViewModelBinding {
    var action: MainViewModelAction { get }
    var state: MainViewModelState { get }
}

class MainViewModel: MainViewModelBinding {
    let action = MainViewModelAction()
    let state = MainViewModelState()
    private var cancellables = Set<AnyCancellable>()
    
    init() {
        action.loadData
            .sink {
                self.state.loadedData.send(1)
            }.store(in: &cancellables)
    }
}
