//
//  ProductDetailViewModelTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/28.
//

import XCTest

class ProductDetailViewModelTests: XCTestCase {

    func testFetch() throws {
        let testHash = "HBDEF"
        let productDetailViewModel = ProductDetailViewModel(from: testHash)

        let promise = XCTestExpectation(description: "Product Detail Point data fetched")

        productDetailViewModel.point.bind { point in
            XCTAssertEqual(point?.value, Decimal(126))
            promise.fulfill()
        }

        productDetailViewModel.fetchDetail()

        wait(for: [promise], timeout: 1)
    }
}
