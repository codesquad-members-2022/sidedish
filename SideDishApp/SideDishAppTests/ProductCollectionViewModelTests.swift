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

        productCollectionViewModel.cellViewModels.bind { sectionVM in
            XCTAssertTrue(sectionVM.count == 3)
            XCTAssertEqual(sectionVM[0].type, .main)
            promise.fulfill()
        }

        productCollectionViewModel.fetch()

        wait(for: [promise], timeout: 1)
    }

    func testFetchImage() throws {
        let promise = XCTestExpectation(description: "Image fetched")

        // Prepare Stub
        let fileName = "1155_ZIP_P_0081_T"
        let fileExtension = "jpg"

        guard let localImage = UIImage(named: fileName) else {
            return XCTFail()
        }

        var components = URLComponents()
        components.scheme = "https"
        components.host = "public.codesquad.kr"
        components.path = "/jk/storeapp/data/main/"
        components.path += "\(fileName).\(fileExtension)"
        guard let testURL = components.url else { return XCTFail() }

        productCollectionViewModel.fetchImage(from: testURL) { image in
            guard let image = image else { return }
            XCTAssertEqual(localImage, image)
            promise.fulfill()
        }
    }
}
