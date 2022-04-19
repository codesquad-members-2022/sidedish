//
//  SidedishDetailViewModel.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import Foundation

struct MenuDetailViewModelAction {
    let viewDidLoad = PassthroughSubject<Void, Never>()
}

struct MenuDetailViewModelState {
    
}

protocol MenuDetailViewModelBinding {
    var action: MenuDetailViewModelAction { get }
    var state: MenuDetailViewModelState { get }
}

typealias MenuDetailViewModelProtcol = MenuDetailViewModelBinding

final class MenuDetailViewModel: MenuDetailViewModelProtcol {
    
    private var cancellables = Set<AnyCancellable>()
    
    let action = MenuDetailViewModelAction()
    let state = MenuDetailViewModelState()
    
    init() {
        action.viewDidLoad
            .sink {
                
            }.store(in: &cancellables)
    }
}
