protocol SideDishable {
    var allDishes: [Dishes] { get }
    
    var count: Int { get }
    
    subscript(index: Int) -> Dishes { get }
    
    func addDishes(with dishes: Dishes)
}
