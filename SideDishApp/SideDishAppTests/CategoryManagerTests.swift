//
//  CategoryManagerTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/20.
//

import XCTest

class CategoryManagerTests: XCTestCase {
    
    func testFetchCategory() throws {
        let categoryManager = CategoryManager()
        
        let promise = XCTestExpectation(description: "Fetch Category Success")
        
        categoryManager.fetchCategory(of: .main) { category in
            XCTAssertEqual(category.type, .main)
            XCTAssertTrue(category.product.count > 0)
            promise.fulfill()
        }
        
        wait(for: [promise], timeout: 1)
    }

}
