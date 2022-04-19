import Foundation

class Ordering{
    private (set) var foodList: [String:Food] = [:]
    private (set) var selectedMenu: Food?
    var count: Int = 0
    var deliveryMoney: Int = 0
    var sum: Int = 0
    
    func addFood(food: Food){
        foodList[food.detailHash] = food
    }
    
    func selectFood(foodHash: String){
        guard let unwrappedFood = foodList[foodHash] else { return }
        selectedMenu = unwrappedFood
    }
}
