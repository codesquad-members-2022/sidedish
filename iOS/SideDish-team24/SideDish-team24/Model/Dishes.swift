import Foundation

final class Dishes {
    private var dishes: [Dish] = []
    private(set) var type: String
    
    subscript(index: Int) -> Dish? {
        return dishes[index]
    }
    
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
