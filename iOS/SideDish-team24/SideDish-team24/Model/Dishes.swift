import Foundation

class Dishes {
    private var dishes: [Dish] = []
    private let type: String
    
    var count: Int {
        return dishes.count
    }
    
    init(type: String) {
        self.type = type
    }
    
    func addDish(with dish: Dish) {
        self.dishes.append(dish)
    }
}
