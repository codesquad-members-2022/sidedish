import XCTest
@testable import SideDish

class OrderingTests: XCTestCase {
    
    private var ordering: Ordering!
    private var food: Food!
    
    override func setUp(){
        ordering = Ordering()
        food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", category: "category", normalPrice: 100, specialPrice: 100, deliveryInformation: "deliveryInformation", deliveryCharge: 100, amount: 100, badges: ["badge"])

        super.setUp()
    }
    
    func testOrderingInitialization(){
        XCTAssertNotNil(ordering)
    }
    
    func testAddingFood(){
        ordering.addFood(food: food)
        XCTAssertGreaterThan(ordering.foodList.count, 0)
    }
    
    func testSelectingFood(){
        ordering.addFood(food: food)
        XCTAssertNil(ordering.selectedMenu)
        ordering.selectFood(foodHash: "hash")
        XCTAssertNotNil(ordering.selectedMenu)
    }
    
    func testReturningSum(){
        ordering.addFood(food: food)
        XCTAssertLessThan(ordering.sum, 0)

        ordering.selectFood(foodHash: "hash")
        XCTAssertGreaterThan(ordering.sum, 0)

    }
}
