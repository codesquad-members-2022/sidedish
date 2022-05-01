import Foundation

enum UserInfoKey: String{
    case foodDetailRespose = "foodDetailResponse"
    case foodTitleResponse = "foodTitleResponse"
    case dataRequestFailureMessage = "dataRequestFailureMessage"
}

struct NotificationName{
    static let foodSelected = Notification.Name("foodSelected")
    static let dataRequestFailed = Notification.Name("dataRequestFailed")
}

final class Ordering{
    private var foodMap: [Category:[String:Food]] = {
        var map: [Category:[String:Food]] = [:]
        for category in Category.allCases {
            map[category] = [String:Food]()
        }
        return map
    }()
    private (set) var selectedFoodDetail: FoodDetail? {
        didSet {
            orderingCount = 0
            deliveryFee = 0
        }
    }
    private var orderingCount: Int = 0
    private var repository: RepositoryApplicable
    var foodCount: Int {
        var count = 0
        for category in foodMap.keys{
            count += foodMap[category]?.count ?? 0
        }
        return count
    }
    var categoryCount: Int {
        return Category.allCases.count
    }
    private var deliveryFee: Int = 0
    
    init(repository: RepositoryApplicable) {
        self.repository = repository
        self.repository.delegate = self
        getSampleFoodList()
    }
    
    var sum: Int {
        //가격정보가 String으로 응답이 와서, 우선 이를 Int로 형변환 처리하기 전이라 임시로 Int값을 할당해서 처리
        guard let _ = selectedMenu else { return -1 }
        let price = 5000
        if orderingCount * price > 40000 {
            return (orderingCount * price) + deliveryMoney
        } else {
            return orderingCount * price
        }
    }
    
    func increaseCount(foodHash: String) {
        guard let _ = selectedMenu else { return }
        orderingCount += 1
    }
    
    func addFood(food: Food, category: Category) {
        foodMap[category]?[food.detailHash] = food
    }
    
    func selectFood(foodHash: String, category: Category) {
        guard let food = foodMap[category]?[foodHash] else { return }
        requestFoodDetail(detailHash: foodHash){ result in
            switch result {
            case .success(let response):
                self.selectedFoodDetail = response.data
                self.deliveryFee = setDeliveryFee(stringLiteral: response.data.deliveryFee)
                NotificationCenter.default.post(name: NotificationName.foodSelected,
                                                object: self,
                                                userInfo: [UserInfoKey.foodTitleResponse:food.title])
            case .failure(let error):
                NotificationCenter.default.post(name: NotificationName.dataRequestFailed,
                                                object: self,
                                                userInfo: [UserInfoKey.dataRequestFailureMessage:error.localizedDescription])
            }            
        }
        
        func setDeliveryFee(stringLiteral: String) -> Int {
            let deliveryFeeStringLiteral = stringLiteral.components(separatedBy: " ")[0].components(separatedBy: CharacterSet.decimalDigits.inverted).joined()
            guard let deliveryFee = Int(deliveryFeeStringLiteral) else { return 0 }
            return deliveryFee
        }
    }
    }
    
    func getCategoryWithIndex(index: Int) -> Category{
        return Category.allCases[index]
    }
    
    private func getSampleFoodList() {
        for category in Category.allCases{
            repository.fetchBackgroundData(category: category, dataType: Food.self)
        }
    }
    
    func getFoodCountInCertainCategory(category: Category) -> Int {
       return foodMap[category]?.count ?? 0
    }
    
    func requesetFoodImage(imageUrl: String, completionHandler: @escaping (Result<Data,Error>)->Void) {
        let url = EndPoint.mainImage(rawUrl: imageUrl)
        repository.requestBinaryData(method: .get, contentType: .image, url: url, completionHandler: completionHandler)
    }
    
    private func requestFoodDetail(detailHash: String, completionHandler: @escaping (Result<DetailResponse<FoodDetail>,Error>)->Void) {
        let url = EndPoint.detail(detailHash: detailHash)
        repository.requestModelData(method: .get, contentType: .json, url: url, completionHandler: completionHandler)
    }
    
    subscript(index: Int = 0 , category: Category) -> Food? {
        guard let foods = foodMap[category]?.values else { return nil }
        let foodArray = Array(foods).sorted(by: { lhs, rhs in
            return lhs.specialPrice > rhs.specialPrice
        })
        return foodArray[index]
    }
}

extension Ordering: RepositoryDelegate {
    func fetchBackgroundData(category: Category, backgroundData: Codable) {
        guard let food = backgroundData as? Food else { return }
        foodMap[category]?[food.detailHash] = food
    }
}


