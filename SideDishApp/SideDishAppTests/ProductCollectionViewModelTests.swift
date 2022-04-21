//
//  ProductCollectionViewModelTests.swift
//  SideDishAppTests
//
//  Created by Kai Kim on 2022/04/21.
//

import XCTest

class ProductCollectionViewModelTests: XCTestCase {

    let productCollectionViewModel = ProductCollectionViewModel()

    func testBinding() throws {
        let promise = XCTestExpectation(description: "CellModel ")

        productCollectionViewModel.categoryManager.fetchCategory(of: .main) { category in
                self.productCollectionViewModel.cellViewModels[category.type.index].value = category.product.compactMap({
                    ProductCellViewModel(title: $0.title, description: $0.description, imageURL: $0.imageURL, originalPrice: $0.originalPrice, salePrice: $0.salePrice, badge: $0.badge)
                })
                promise.fulfill()
            }
            wait(for: [promise], timeout: 1)

        productCollectionViewModel.cellViewModels[0].bind { listener in
            print(listener.count)
        }
    }

    func testBindResult() throws {
    }

}
