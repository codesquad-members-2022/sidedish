//
//  NetworkManagerTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/20.
//

import XCTest
import OSLog
@testable import SideDishApp

class NetworkManagerTests: XCTestCase {

    func testExample() throws {
        let two = 2
        XCTAssertEqual(1+1, two)
    }
    
    func testFetchProducts() throws {
        let promise = XCTestExpectation(description: "Fetch products success")
        
        let networkManager = NetworkManager()
        networkManager.fetchProducts { result in
            switch result {
            case .success(let products):
                debugPrint(products)
                promise.fulfill()
            case .failure(let error):
                print(error.localizedDescription)
            }
        }
        
        wait(for: [promise], timeout: 1)
    }

}
