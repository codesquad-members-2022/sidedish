import XCTest
@testable import SideDish

class FoodTests: XCTestCase {

    func testFoodInitialization(){
        let food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", category: "category", normalPrice: 100, specialPrice: 100, deliveryInformation: "deliveryInformation", deliveryCharge: 100, amount: 100, badges: ["badge"])
        
        XCTAssertNotNil(food)
    }

}
