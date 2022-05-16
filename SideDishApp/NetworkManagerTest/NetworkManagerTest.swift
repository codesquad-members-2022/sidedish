//
//  NetworkManagerTest.swift
//  NetworkManagerTest
//
//  Created by 박진섭 on 2022/05/11.
//

import XCTest

class NetworkManagerTest: XCTestCase {
    
    var sut: NetworkManagable!
    
    override func setUpWithError() throws {
        try super.setUpWithError()
        sut = NetworkManager(session: .shared)
        sut = ImageNetworkManager(session: .shared)
    }

    override func tearDownWithError() throws {
        sut = nil
        try super.tearDownWithError()
    }

    func testNetworkManager() throws {
        func testRequest() {
            //MockData - Main
            guard let path = Bundle.main.path(forResource: "MainMockData", ofType: "json") else { return }
            guard let jsonString = try? String(contentsOfFile: path) else { return }
            guard let mainDishMockdata = jsonString.data(using: .utf8) else { return }
            
            //MockData - detail
            guard let path = Bundle.main.path(forResource: "DetailMockData", ofType: "json") else { return }
            guard let jsonString = try? String(contentsOfFile: path) else { return }
            guard let dishDetailMockdata = jsonString.data(using: .utf8) else { return }
            
            //MockData - Image
            guard let path = Bundle.main.path(forResource: "739_ZIP_P__T", ofType: "jpg") else { return }
            guard let jsonString = try? String(contentsOfFile: path) else { return }
            guard let imageMockdata = jsonString.data(using: .utf8) else { return }

            
            //Decoded MockData with specific type
            guard let expectedMainDish = try? JSONDecoder().decode(SideDishInfo.self, from: mainDishMockdata) else { return }
            guard let expectedDishDetail = try? JSONDecoder().decode(SideDishInfo.self, from: dishDetailMockdata) else { return }
            guard let expectedimage = try? JSONDecoder().decode(SideDishInfo.self, from: imageMockdata) else { return }
            
            //mockEndpoint
            let mainDishMockEndPoint = EndPointCase.get(category: .main).endpoint
            let detailMockEndPoint = EndPointCase.getDetail(hash: "H1AA9").endpoint
            
            
            //loadingHandler 만들기
            URLMockProtocol.loadingHandler = { request in
                let response = HTTPURLResponse(url: request.url!, statusCode: 200, httpVersion: nil, headerFields: nil)!
                switch request.url {
                case mainDishMockEndPoint.getURL():
                    return (response,mainDishMockdata,nil)
                case detailMockEndPoint.getURL():
                    return (response,dishDetailMockdata,nil)
                default:
                    return (response, nil, nil)
                }
            }
            
            //Make networkManger with session for test
            let expectation = XCTestExpectation(description: "Loading")
            let configuration = URLSessionConfiguration.ephemeral
            configuration.protocolClasses = [URLMockProtocol.self]
            //Dependency injection
            let networkmanager = NetworkManager(session: URLSession(configuration: configuration))
            
            networkmanager.request(endpoint: mainDishMockEndPoint)  { (result:Result<SideDishInfo?,NetworkError>) in
                switch result {
                case .failure(let error):
                    XCTFail("Request was not successful: \(error.localizedDescription)")
                case .success(let result):
                    XCTAssertEqual(result, expectedMainDish)
                }
                expectation.fulfill()
            }
            wait(for: [expectation], timeout: 1)
        }
}
    
    func testImageNetworkManager() throws {
        
    }
    
}
