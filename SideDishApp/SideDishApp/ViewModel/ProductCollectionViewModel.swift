//
//  ProductCollectionViewModel.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation
// This is going to represent single viewModel that drives productCollectionView

struct CategorySectionViewModel {
    var type: ProductType
    var productViewModel: [ProductCellViewModel]
}

struct ProductCollectionViewModel {

    var categoryManager = CategoryManager()
    var cellViewModels: Observable<[CategorySectionViewModel]> = Observable<[CategorySectionViewModel]>([])

    func countProduct(section: Int) -> Int {
        self.cellViewModels.value[section].productViewModel.count
    }

    func countSection() -> Int {
        self.cellViewModels.value.count
    }

    subscript(_ indexPath: IndexPath) -> ProductCellViewModel? {
        let categoryVM = cellViewModels.value[indexPath.section]
        return categoryVM.productViewModel[indexPath.item]
    }

    func fetch() {
        var temp = [CategorySectionViewModel]()

        let dispatchGroup = DispatchGroup()

        for type in ProductType.allCases {
            dispatchGroup.enter()
            categoryManager.fetchCategory(of: type) { category in
                let productCellVMs = category.product.compactMap { product in
                    ProductCellViewModel(title: product.title, description: product.description, imageURL: product.imageURL, originalPrice: product.originalPrice, salePrice: product.salePrice, badge: product.badge)
                }
                let categorySectionVM = CategorySectionViewModel(type: .main, productViewModel: productCellVMs)
                temp.append(categorySectionVM)
                dispatchGroup.leave()
            }
        }

        dispatchGroup.notify(queue: .global(), work: DispatchWorkItem {
            cellViewModels.value = temp
        })

    }

}
