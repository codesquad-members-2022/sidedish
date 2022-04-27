import XCTest
@testable import SideDish

class JSONHandlerTest: XCTestCase {
    
    private var jsonHandler: JSONHandlable!
    private var food: Food!
    
    override func setUp() {
        jsonHandler = JSONHandler()
        food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
    }

    func testConvertingObjectToJSON() {
        XCTAssertNotNil(jsonHandler.convertObjectToJSON(from: food))
    }

    func testConvertingJSONToObject() throws {
        XCTAssertNil(jsonHandler.convertJSONToObject(from: Data(), to: Food.self))
        
        let data = try XCTUnwrap(jsonHandler.convertObjectToJSON(from: food))
        XCTAssertNotNil(jsonHandler.convertJSONToObject(from: data, to: Food.self))
    }
    
}
