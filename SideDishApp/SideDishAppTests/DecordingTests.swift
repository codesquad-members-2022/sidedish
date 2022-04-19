//
//  ProductModel.swift
//  SideDishAppTests
//
//  Created by Kai Kim on 2022/04/19.
//

import XCTest
import OSLog
@testable import SideDishApp

class ProductTest: XCTestCase {

    var products : [Product]!
    
    override func setUpWithError() throws {
        if let dataURL = Bundle.main.url(forResource: "mockProductData", withExtension: "json") {
            let data = try Data(contentsOf: dataURL)
            let decorder = JSONDecoder()
            let fetchedData = try decorder.decode(Response.self, from: data)
            self.products = fetchedData.body
            }
    }

    override func tearDownWithError() throws {

    }

    func testCountMatch() throws {
        XCTAssertEqual(products.count, 8)
    }
    
    
    func testTitleMatch() throws {
        XCTAssertEqual(products[0].title, "오리 주물럭_반조리")
        XCTAssertEqual(products[1].title, "잡채")
        XCTAssertEqual(products.last!.title, "쭈꾸미 한돈 제육볶음_반조림")
    }
    
    func testDeliveryMatch() throws {
        XCTAssertEqual(products[0].deliveryType.first!.rawValue, "새벽배송")
        XCTAssertEqual(products.last!.deliveryType.last!.rawValue, "전국택배")
    }
    
    func testbadgeMatch() throws {
        XCTAssertEqual(products[0].badge!.first!.rawValue, "런칭특가")
    }
    
    func testArithmetic() throws {
        let add = products[0].salePrice.value.adding(products[1].salePrice.value).adding(products[1].salePrice.value)
        let subtract = products[0].salePrice.value.subtracting(products[1].salePrice.value)
        XCTAssertEqual(add.wonFormat, "35,860원")
        XCTAssertEqual(subtract.wonFormat, "1,030원")
    }
    
    func testNotNill() throws {
        products.forEach({
            XCTAssertNotNil($0.detailHash)
            XCTAssertNotNil($0.title)
            XCTAssertNotNil($0.imageURL)
            XCTAssertNotNil($0.deliveryType)
            XCTAssertNotNil($0.description)
            XCTAssertNotNil($0.salePrice)
        })
    }

}
