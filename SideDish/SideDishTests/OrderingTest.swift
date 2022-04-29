import XCTest
@testable import SideDish

class OrderingTests: XCTestCase {
    
    private var ordering: Ordering!
    private var food: Food!
    private var networkHandler: NetworkHandlable!
    private var jsonHandler: JSONHandlable!
    private var dataCache: DataCachingManagable!
    
    override func setUp(){
        networkHandler = MockNetworkHandler()
        jsonHandler = JSONHandler()
        dataCache = MockDataCachingManager()
        let repository = MockRepository(networkHandler: networkHandler, jsonHandler: jsonHandler, dataCache: dataCache)
        ordering = Ordering(repository: repository)
        food = Food(detailHash: "hash2", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        super.setUp()
    }
    
    //Ordering 인스턴스 초기화 테스트
    func testOrderingInitialization(){
        XCTAssertNotNil(ordering)
        XCTAssertEqual(ordering.foodCount, 1)
    }
    
    //addFood 메소드 테스트 - Food 인스턴스가 잘 추가되는 지 확인
    func testAddingFood(){
        ordering.addFood(food: food, category: .main)
        XCTAssertEqual(ordering.foodCount, 2)
    }
    
    //selectFood 테스트 - Food 인스턴스 추가 후, 선택이 잘 되는지 확인
    func testSelectingFood(){
        ordering.addFood(food: food, category: .main)
        XCTAssertNil(ordering.selectedMenu)
        ordering.selectFood(foodHash: "hash", category: .main)
        XCTAssertNotNil(ordering.selectedMenu)
    }
    
    //increaseCount 테스트 - Food 인스턴스 추가 및 선택 후, orderingCount에 맞춰 주문 총액 sum 값이 잘 변경되는 지 테스트
    func testIncresingCount(){
        ordering.addFood(food: food, category: .main)
        XCTAssertLessThan(ordering.sum, 0)

        ordering.selectFood(foodHash: "hash", category: .main)
        ordering.increaseCount(foodHash: "hash")
        XCTAssertGreaterThan(ordering.sum, 0)
    }
    
    //requestFoodImage 테스트1 - 성공적인 응답 수신 상황을 가정한 테스트
    func testRequstingFoodImage_success() throws{
        let expectation = XCTestExpectation()

        ordering.requesetFoodImage(imageUrl: food.imageUrl){ result in
            switch result{
            case .success(let data):
                XCTAssertNotNil(data)
                expectation.fulfill()
            case .failure(_):
                XCTFail()
            }
        }
    }
    
    //requestFoodImage 테스트2 - 응답 수신 실패 상황을 가정한 테스트
    func testRequstingFoodImage_failure() throws{
        let expectation = XCTestExpectation()
        let networkHandler = try XCTUnwrap(networkHandler) as? MockNetworkHandler
        networkHandler?.isResponseFailed = true
        
        ordering.requesetFoodImage(imageUrl: food.imageUrl){ result in
            switch result{
            case .success(_):
                XCTFail()
            case .failure(let error):
                XCTAssertEqual("\(error)", "Unknown Error")
                expectation.fulfill()
            }
        }        
    }
}
