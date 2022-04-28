import Foundation

final class Dishes {
    private var dishes: [Dish] = []
    private(set) var type: String
    
    subscript(index: Int) -> Dish? {
        guard index >= 0 && index <= dishes.count-1 else { return nil }
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
