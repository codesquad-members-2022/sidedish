//
//  ProductCollectionViewModelTests.swift
//  SideDishAppTests
//
//  Created by Kai Kim on 2022/04/21.
//

import XCTest

class ProductCollectionViewModelTests: XCTestCase {

    let productCollectionViewModel = ProductCollectionViewModel()

    func testFetch() throws {
        let promise = XCTestExpectation(description: "Section View Model fetched")

        productCollectionViewModel.categoryVMs[.main]?.bind { sectionVM in
            XCTAssertTrue(sectionVM?.productVMs.count == 8)
            promise.fulfill()
        }

        productCollectionViewModel.fetchAllCategories()

        wait(for: [promise], timeout: 1)
    }
}
