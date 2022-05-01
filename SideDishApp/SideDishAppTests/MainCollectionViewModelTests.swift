//
//  ProductCollectionViewModelTests.swift
//  SideDishAppTests
//
//  Created by Kai Kim on 2022/04/21.
//

import XCTest

class MainCollectionViewModelTests: XCTestCase {

    let mainCollectionViewModel = MainCollectionViewModel()

    func testFetch() throws {
        let promise = XCTestExpectation(description: "Section View Model fetched")

        mainCollectionViewModel.categoryVMs[.main]?.bind { sectionVM in
            XCTAssertTrue(sectionVM?.productVMs.count == 8)
            promise.fulfill()
        }

        mainCollectionViewModel.fetchAllCategories()

        wait(for: [promise], timeout: 1)
    }
}
