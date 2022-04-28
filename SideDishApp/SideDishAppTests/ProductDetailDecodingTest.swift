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

    var productDetailResponse: ProductDetailResponse!

    override func setUpWithError() throws {
        if let dataURL = Bundle.main.url(forResource: "mockProductDetailData", withExtension: "json") {
            let data = try Data(contentsOf: dataURL)
            let decoder = JSONDecoder()
            let fetchedData = try decoder.decode(ProductDetailResponse.self, from: data)
            self.productDetailResponse = fetchedData
            }
    }

    func testStringMatch() throws {
        let hash = "H4665"
        let description = "영양 듬뿍 프리미엄 간장 떡볶이"
        let deliveryInfo = "서울 경기 새벽 배송 / 전국 택배 배송"
        let deliveryFee = "2,500원 (40,000원 이상 구매 시 무료)"

        XCTAssertEqual(productDetailResponse.hash, hash)
        XCTAssertEqual(productDetailResponse.data.productDescription, description)
        XCTAssertEqual(productDetailResponse.data.deliveryInfo, deliveryInfo)
        XCTAssertEqual(productDetailResponse.data.deliveryFee, deliveryFee)

    }

    func testURL() throws {
        let URL = URL(string: "http://public.codesquad.kr/jk/storeapp/data/main/675_ZIP_P_0057_T.jpg")
        XCTAssertEqual(productDetailResponse.data.topImageURL, URL)
    }

    func testImageURLCount()  throws {
        let thumbImageURLCount = 2
        let detailSectionImageURLCount = 4

        XCTAssertEqual(productDetailResponse.data.thumbImagesURL.count, thumbImageURLCount)
        XCTAssertEqual(productDetailResponse.data.detailSectionURL.count, detailSectionImageURLCount)
    }

    func testMoneyMatch() throws {
        let point = "78원"
        let priceCount = 1
        let priceValue = "7,800원"
        XCTAssertEqual(productDetailResponse.data.point.priceTag, point)
        XCTAssertEqual(productDetailResponse.data.prices.count, priceCount)
        XCTAssertEqual(productDetailResponse.data.prices.first!.priceTag, priceValue)
    }

}
