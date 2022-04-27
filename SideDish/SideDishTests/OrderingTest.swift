import XCTest
@testable import SideDish

class OrderingTests: XCTestCase {
    
    private var ordering: Ordering!
    private var food: Food!
    
    override func setUp() {
        ordering = Ordering(repository: MockRepository())
        food = Food(detailHash: "hash2", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        super.setUp()
    }
    
    func testOrderingInitialization() {
        XCTAssertNotNil(ordering)
        XCTAssertEqual(ordering.foodCount, 1)
    }
    
    func testAddingFood() {
        ordering.addFood(food: food, category: .main)
        XCTAssertEqual(ordering.foodCount, 2)
    }
    
    func testSelectingFood() {
        ordering.addFood(food: food, category: .main)
        XCTAssertNil(ordering.selectedMenu)
        ordering.selectFood(foodHash: "hash", category: .main)
        XCTAssertNotNil(ordering.selectedMenu)
    }
    
    func testIncresingCount() {
        ordering.addFood(food: food, category: .main)
        ordering.selectFood(foodHash: "hash", category: .main)
        ordering.increaseCount(foodHash: "hash")
        XCTAssertEqual(ordering.sum, 5000)
    }
    
    func testReturningSum() {
        ordering.addFood(food: food, category: .main)
        XCTAssertLessThan(ordering.sum, 0)

        ordering.selectFood(foodHash: "hash", category: .main)
        ordering.increaseCount(foodHash: "hash")
        XCTAssertGreaterThan(ordering.sum, 0)
    }
}
