import Foundation

enum Category: CaseIterable {
    case main
    case side
    case soup
}

class Ordering{
    private (set) var foodMap: [Category:[String:Food]] = [:]
    private (set) var selectedMenu: Food?
    private var orderingCount: Int = 0
    var foodCount: Int{
        var count = 0
        for category in foodMap.keys{
            count += foodMap[category]?.count ?? 0
        }
        return count
    }
    var deliveryMoney: Int = 2500
    
    init(){
        for category in Category.allCases {
            foodMap[category] = [String:Food]()
        }
    }
    
    var sum: Int{
        //가격정보가 String으로 응답이 와서, 우선 이를 Int로 형변환 처리하기 전이라 임시로 Int값을 할당해서 처리
        guard let _ = selectedMenu else { return -1}
        let price = 5000
        if orderingCount * price > 40000 {
            return (orderingCount * price) + deliveryMoney
        } else {
            return orderingCount * price
        }
    }
    
    func increaseCount(foodHash: String){
        guard let _ = selectedMenu else { return }
        orderingCount += 1
    }
    
    func addFood(food: Food, category: Category){
        foodMap[category]?[food.detailHash] = food
    }
    
    func selectFood(foodHash: String, category: Category){
        guard let food = foodMap[category]?[foodHash] else { return }
        selectedMenu = food
    }
    
    private func getSampleJSONData(fileName: String)-> Data?{
        guard let path = Bundle.main.url(forResource: fileName, withExtension: "json") else { return nil }
        guard let data: Data = try? Data(contentsOf: path) else { return nil }
        return data
    }
    
    func getSampleFoodList(){
        for category in Category.allCases {
            guard let data = getSampleJSONData(fileName: "\(category)") else { continue }
            guard let response = JSONHandler.convertJSONToObject(from: data, to: Response<Food>.self) else { continue }
            
            let foods = response.body
            for food in foods {
                foodMap[category]?[food.detailHash] = food
            }
        }
    }
    
    subscript(index: Int = 0 , category: Category)->Food?{
        guard let foods = foodMap[category]?.values else { return nil }
        let foodArray = Array(foods).sorted(by: { lhs, rhs in
            return lhs.specialPrice > rhs.specialPrice
        })
        return foodArray[index]
    }
}


