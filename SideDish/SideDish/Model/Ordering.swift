import Foundation

class Ordering{
    private (set) var foodList: [String:Food] = [:]
    private (set) var selectedMenu: Food?
    var count: Int = 0
    var deliveryMoney: Int = 2500
    
    var sum: Int{
        guard let price = selectedMenu?.specialPrice else { return -1}
        if count * price > 40000 {
            return (count * price) + deliveryMoney
        } else {
            return count * price
        }
    }
    
    func addFood(food: Food){
        foodList[food.detailHash] = food
    }
    
    func selectFood(foodHash: String){
        guard let unwrappedFood = foodList[foodHash] else { return }
        selectedMenu = unwrappedFood
    }
}
