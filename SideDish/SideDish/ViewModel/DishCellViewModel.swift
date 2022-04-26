//
//  DishCellViewModel.swift
//  SideDish
//
//  Created by YEONGJIN JANG on 2022/04/25.
//

import Foundation

protocol DishCellViewModelProtocol {
    func fetchData()
    var onUpdate: () -> Void { get }
}

final class DishCellViewModel: DishCellViewModelProtocol {
    private let repository: DishCellRepositoryProtocol
    var onUpdate: () -> Void = { }
    
    init(repository: DishCellRepositoryProtocol) {
        self.repository = repository
    }
    
    func fetchData() {
        //
    }
}
