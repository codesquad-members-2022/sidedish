import Foundation

enum Category: CaseIterable {
    case main
    case side
    case soup
}

class Ordering{
    //추후 foodList 제거하고, foodMap으로 통일해서 사용할 예정
    var foodMap: [Category:[Food]] = [:]
    var foodList: [String:Food] = [:]
    private (set) var selectedMenu: Food?
    private var count: Int = 0
    var deliveryMoney: Int = 2500
    
    init(){
        getSampleFoodList()
    }
    
    var sum: Int{
        //가격정보가 String으로 응답이 와서, 우선 이를 Int로 형변환 처리하기 전이라 임시로 Int값을 할당해서 처리
        //guard let price = selectedMenu?.specialPrice else { return -1}
        let price = 5000
        if count * price > 40000 {
            return (count * price) + deliveryMoney
        } else {
            return count * price
        }
    }
    
    func increaseCount(foodHash: String){
        if foodList[foodHash] != nil {
            count += 1
        }
    }
    
    func addFood(food: Food){
        foodList[food.detailHash] = food
    }
    
    func selectFood(foodHash: String){
        guard let unwrappedFood = foodList[foodHash] else { return }
        selectedMenu = unwrappedFood
    }
    
    private func getSampleJSONData(fileName: String)-> Data?{
        guard let path = Bundle.main.url(forResource: fileName, withExtension: "json") else { return nil }
        guard let data: Data = try? Data(contentsOf: path) else { return nil }
        return data
    }
    
    private func getSampleFoodList(){
        for category in Category.allCases {
            guard let data = getSampleJSONData(fileName: "\(category)") else { continue }
            guard let response = JSONHandler.convertJSONToObject(from: data, to: Response<Food>.self) else { continue }
            
            let foods = response.body
            foodMap[category] = foods
            //추후 foodList 속성 제거되면 아래 로직도 제거
            for food in foods {
                foodList[food.detailHash] = food
            }
        }
    }
    
}
