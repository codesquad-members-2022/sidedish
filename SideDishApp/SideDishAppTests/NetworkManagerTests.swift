//
//  NetworkManagerTests.swift
//  SideDishAppTests
//
//  Created by Bumgeun Song on 2022/04/20.
//

import XCTest
@testable import SideDishApp

class NetworkManagerTests: XCTestCase {

    let networkManager = NetworkManager()

    func testExample() throws {
        let two = 2
        XCTAssertEqual(1+1, two)
    }

    func testFetchProductDetail() throws {
        let promise = XCTestExpectation(description: "Fetch product detail success")

        let testHash = "HBDEF"
        let request = ProductDetailRequest(from: testHash)
        XCTAssertNotNil(request)

        networkManager.request(request!) { data in
            XCTAssertNotNil(data)
            XCTAssertEqual(data?.hash, testHash)
            promise.fulfill()
        }

        wait(for: [promise], timeout: 1)
    }

    func testFetchImage() throws {
        let promise = XCTestExpectation(description: "Fetch Image data success")

        // Prepare Stub
        let fileName = "1155_ZIP_P_0081_T"
        let fileExtension = "jpg"

        guard let localImageURL = Bundle.main.url(forResource: fileName, withExtension: fileExtension),
              let localImageData = try? Data(contentsOf: localImageURL) else {
            return XCTFail("Could not load test Image from bundle")
        }

        let request = ImageRequest(fileName: fileName, fileExtension: fileExtension)
        XCTAssertNotNil(request)

        networkManager.request(request!) { data in
            XCTAssertEqual(data, localImageData)
            promise.fulfill()
        }

        wait(for: [promise], timeout: 1)

    }

    func testFetchCategory() throws {
        let promise = XCTestExpectation(description: "Fetch Category success")

        let request = CategoryRequest(from: .main)
        XCTAssertNotNil(request)

        networkManager.request(request!) { data in
            XCTAssertNotNil(data)
            promise.fulfill()
        }

        wait(for: [promise], timeout: 1)
    }
}
