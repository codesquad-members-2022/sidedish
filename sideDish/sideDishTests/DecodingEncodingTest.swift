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
        guard let url = Bundle.main.url(forResource: "mock", withExtension: "json") else { return nil }
        guard let dummyJSONData = try? Data(contentsOf: url) else { return nil }
        return dummyJSONData
    }()
    
    let decoder = JSONDecoder()
    
    func testFoodJSONParsing() throws {
        guard let dummyFoodJSONData = dummyFoodTestData else { return }
        
        let foods = try self.decoder.decode([Food].self, from: dummyFoodJSONData)
        XCTAssertTrue(foods.count > 0)
    }
}
