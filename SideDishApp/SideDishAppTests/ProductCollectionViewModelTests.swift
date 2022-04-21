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
        let promise = XCTestExpectation(description: "cellViewModels")

        productCollectionViewModel.cellViewModels.bind { cellViewModels in
            XCTAssertTrue(cellViewModels.count == 3)
            print(cellViewModels)
            promise.fulfill()
        }

        productCollectionViewModel.fetch()

        wait(for: [promise], timeout: 1)

    }

}
