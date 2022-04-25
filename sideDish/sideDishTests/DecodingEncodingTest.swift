//
//  DecodingEncodingTest.swift
//  sideDishTests
//
//  Created by 이건행 on 2022/04/22.
//

import XCTest
@testable import sideDish

class DecodingEncodingTest: XCTestCase {
    
    let dummyFoodTestData: Data? = {
        guard let url = Bundle.main.url(forResource: "main", withExtension: "json") else { return nil }
        guard let dummyJSONData = try? Data(contentsOf: url) else { return nil }
        return dummyJSONData
    }()

    let decoder = JSONDecoder()

    func testFoodJSONParsing() throws {
        let fileName = "main"
        let type = "json"
        
        guard let fileLocation = Bundle.main.url(forResource: fileName, withExtension: type) else { return }
        let data = try Data(contentsOf: fileLocation)
        let result = try JSONDecoder().decode(Response.self, from: data)
        
        XCTAssertTrue(result.body.count > 0)
    }
    
}
