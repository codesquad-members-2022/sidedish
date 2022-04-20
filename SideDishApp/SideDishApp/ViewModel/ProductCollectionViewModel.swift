//
//  ProductCollectionViewModel.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation
//This is going to represent single viewModel that drives productCollectionView
struct ProductCollectionViewModel {
    
    var categoryManager = CategoryManager()
    var cellViewModels : [Observable<[ProductCellViewModel]>] = [Observable([])]
    
    func countProduct(section: Int) -> Int {
        self.cellViewModels[section].value.count
    }
    
    func countSection() -> Int {
        self.cellViewModels.count
    }
    
    subscript(_ indexPath: IndexPath) -> ProductCellViewModel? {
        return self.cellViewModels[indexPath.section].value[indexPath.item]
    }
    
}


