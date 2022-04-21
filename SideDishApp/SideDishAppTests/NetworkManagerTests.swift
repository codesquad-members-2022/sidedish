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
    
    func testFetchProducts() throws {
        let promise = XCTestExpectation(description: "Fetch products success")
        
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

    func testFetchImageData() throws {
        let promise = XCTestExpectation(description: "Fetch Image data success")
        
        let fileName = "1155_ZIP_P_0081_T"
        let fileExtension = "jpg"
        guard let localImageURL = Bundle.main.url(forResource: fileName, withExtension: fileExtension), let localImageData = try? Data(contentsOf: localImageURL) else {
            return
        }
        
        var components = URLComponents()
        components.scheme = "https"
        components.host = "public.codesquad.kr"
        components.path = "/jk/storeapp/data/main/"
        components.path += "\(fileName).\(fileExtension)"
        guard let url = components.url else { return }
        
        SystemLog.info(url.debugDescription)
        networkManager.fetchImageData(url: url) { result in
            switch result {
            case .success(let data):
                SystemLog.info(data.debugDescription)
                XCTAssertEqual(localImageData, data)
                promise.fulfill()
            case .failure(let error):
                SystemLog.fault(error.localizedDescription)
            }
        }
        
        wait(for: [promise], timeout: 2)
    }
}
