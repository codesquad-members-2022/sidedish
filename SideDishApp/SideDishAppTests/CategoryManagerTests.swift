//
//  CategoryManagerTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/20.
//

import XCTest

class CategoryManagerTests: XCTestCase {

    let categoryManager = CategoryManager()

    func testFetchCategory() throws {

        let promise = XCTestExpectation(description: "Fetch Category Success")

        categoryManager.fetchCategory(of: .main) { category in
            XCTAssertEqual(category.type, .main)
            XCTAssertTrue(category.product.count > 0)
            promise.fulfill()
        }

        wait(for: [promise], timeout: 1)
    }

    func testFetchImage() {

        // Prepare Product to test fetch Image
        var testProduct: Product?

        let fetchProductPromise = XCTestExpectation(description: "Fetch Product Success")

        categoryManager.fetchCategory(of: .main) { category in
            testProduct = category.product[0]
            fetchProductPromise.fulfill()
        }

        wait(for: [fetchProductPromise], timeout: 1)
        guard let testProduct = testProduct else { return XCTFail() }

        // Prepare Stub
        let fileName = "1155_ZIP_P_0081_T"
        let fileExtension = "jpg"
        guard let localImageURL = Bundle.main.url(forResource: fileName, withExtension: fileExtension), let localImageData = try? Data(contentsOf: localImageURL) else {
            return
        }

        // Test Fetch method
        let fetchImagePromise = XCTestExpectation(description: "Fetch Image Success")
//
//        categoryManager.fetchImageData(of: testProduct) { data in
//            XCTAssertEqual(localImageData, data)
//            fetchImagePromise.fulfill()
//        }

        wait(for: [fetchImagePromise], timeout: 1)
    }

    func testCaching() {

        print(nsURL)
    }

}
