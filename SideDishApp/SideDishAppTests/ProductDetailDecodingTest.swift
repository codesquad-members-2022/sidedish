//
//  ProductDetailDecordingTest.swift
//  SideDishAppTests
//
//  Created by Kai Kim on 2022/04/20.
//

import XCTest
import OSLog
@testable import SideDishApp

class ProductDetailDecordingTest: XCTestCase {

    var prodcutDetail : ProductDetail!
    
    override func setUpWithError() throws {
        if let dataURL = Bundle.main.url(forResource: "mockProductDetailData", withExtension: "json") {
            let data = try Data(contentsOf: dataURL)
            let decorder = JSONDecoder()
            let fetchedData = try decorder.decode(ProductDetail.self, from: data)
            self.prodcutDetail = fetchedData
            }
    }

    override func tearDownWithError() throws {
    }

    func testStringMatch() throws {
        let hash = "H4665"
        let description = "영양 듬뿍 프리미엄 간장 떡볶이"
        let deliveryInfo = "서울 경기 새벽 배송 / 전국 택배 배송"
        let deliveryFee = "2,500원 (40,000원 이상 구매 시 무료)"
        
        XCTAssertEqual(prodcutDetail.hash, hash)
        XCTAssertEqual(prodcutDetail.data.productDescription, description)
        XCTAssertEqual(prodcutDetail.data.deliveryInfo, deliveryInfo)
        XCTAssertEqual(prodcutDetail.data.deliveryFee, deliveryFee)
        
    }
    
    func testURL() throws {
        let URL = URL(string: "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg")
        XCTAssertEqual(prodcutDetail.data.topImageURL,URL)
    }
    
    func testImageURLCount()  throws {
        let thumbImageURLCount = 2
        let detailSectionImageURLCount = 4
        
        XCTAssertEqual(prodcutDetail.data.thumbImagesURL.count, thumbImageURLCount)
        XCTAssertEqual(prodcutDetail.data.detailSectionURL.count, detailSectionImageURLCount)
    }
        
    func testMoneyMatch() throws {
        let point = "78원"
        let priceCount = 1
        let priceValue = "7,800원"
        XCTAssertEqual(prodcutDetail.data.point.krwFormat, point)
        XCTAssertEqual(prodcutDetail.data.prices.count, priceCount)
        XCTAssertEqual(prodcutDetail.data.prices.first!.krwFormat, priceValue)
    }

    

}
