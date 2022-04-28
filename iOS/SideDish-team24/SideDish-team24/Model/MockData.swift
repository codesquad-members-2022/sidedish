import Foundation

class MockData: SideDishable {
    private(set) var allDishes: [Dishes] = [Dishes(type: "메인 요리"), Dishes(type: "국물 요리"), Dishes(type: "반찬 요리")]
    
    subscript(index: Int) -> Dishes {
            assert(index >= 0 && index <= allDishes.count-1, "Index out of range")
            return allDishes[index]
    }
    
    var count: Int {
        return allDishes.count
    }
    
    private let mainDish1: Dish = Dish(id: "1", name: "감자조림", price: 7000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 감자조림", listPrice: 10000, discountPolicy: "특가 할인")
    private let mainDish2: Dish = Dish(id: "2", name: "잡채", price: 6000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 잡채", listPrice: 9000, discountPolicy: "특가 할인")
    private let mainDish3: Dish = Dish(id: "3", name: "소갈비찜", price: 20000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 소갈비찜", listPrice: nil, discountPolicy: "특가 할인")
    private let soupDish1: Dish = Dish(id: "4", name: "된장국", price: 6400, stock: 3, type: "국물 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 된장국", listPrice: 8700, discountPolicy: "특가 할인")
    private let soupDish2: Dish = Dish(id: "5", name: "김치찌개", price: 8200, stock: 3, type: "국물 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 김치찌개", listPrice: 9800, discountPolicy: "특가 할인")
    private let sideDish: Dish = Dish(id: "6", name: "김치", price: 36000, stock: 3, type: "반찬 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg"), description: "맛있는 김치", listPrice: 40000, discountPolicy: "특가 할인")
    
    init() {
        allDishes[0].addDish(with: mainDish1)
        allDishes[0].addDish(with: mainDish2)
        allDishes[0].addDish(with: mainDish3)
        
        allDishes[1].addDish(with: soupDish1)
        allDishes[1].addDish(with: soupDish2)
        
        allDishes[2].addDish(with: sideDish)
    }
    
    func addDishes(with dishes: Dishes) {
        self.allDishes.append(dishes)
    }
}
