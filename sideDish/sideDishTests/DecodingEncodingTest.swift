//
//  DecodingEncodingTest.swift
//  sideDishTests
//
//  Created by 이건행 on 2022/04/22.
//

import XCTest

class DecodingEncodingTest: XCTestCase {
    
    let dummyFoodTestData: Data? = {
        guard let url = Bundle.main.url(forResource: "mock", withExtension: "json") else { return nil }
        guard let dummyJSONData = try? Data(contentsOf: url) else { return nil }
        return dummyJSONData
    }()
    
    
}
