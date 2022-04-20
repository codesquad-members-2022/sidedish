//
//  NetworkManagerTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/20.
//

import XCTest
@testable import SideDishApp

class NetworkManagerTests: XCTestCase {

    func testExample() throws {
        let two = 2
        XCTAssertEqual(1+1, two)
    }
    
    func testFetchProducts() throws {
        let promise = XCTestExpectation(description: "Fetch products success")
        
        let networkManager = NetworkManager()
        networkManager.fetchProducts(of: ProductType.main) { result in
            switch result {
            case .success(let products):
                SystemLog.info(products.debugDescription)
                promise.fulfill()
            case .failure(let error):
                SystemLog.fault(error.localizedDescription)
            }
        }
        
        wait(for: [promise], timeout: 1)
    }

}
