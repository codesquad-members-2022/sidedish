import XCTest
@testable import SideDish

class FoodTests: XCTestCase {

    func testFoodInitialization() {
        let food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        XCTAssertNotNil(food)
    }

}
