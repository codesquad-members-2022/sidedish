import Foundation

class MockData {
    let mainDishes: Dishes = Dishes(type: "메인 요리")
    let soupDishes: Dishes = Dishes(type: "국물 요리")
    let sideDishes: Dishes = Dishes(type: "반찬 요리")
    
    let mainDish1: Dish = Dish(id: "1", name: "감자조림", price: 10000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 감자조림", discountPrice: 7000, discountPolicy: "특가 할인")
    let mainDish2: Dish = Dish(id: "2", name: "잡채", price: 10000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 잡채", discountPrice: 7000, discountPolicy: "특가 할인")
    let mainDish3: Dish = Dish(id: "3", name: "소갈비찜", price: 10000, stock: 3, type: "메인 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 소갈비찜", discountPrice: 7000, discountPolicy: "특가 할인")
    let soupDish1: Dish = Dish(id: "4", name: "된장국", price: 10000, stock: 3, type: "국물 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 된장국", discountPrice: 7000, discountPolicy: "특가 할인")
    let soupDish2: Dish = Dish(id: "5", name: "김치찌개", price: 10000, stock: 3, type: "국물 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 김치찌개", discountPrice: 7000, discountPolicy: "특가 할인")
    let sideDish: Dish = Dish(id: "6", name: "김치", price: 10000, stock: 3, type: "반찬 요리", image: URL(string: "https://i.imgur.com/A14QwVW.jpeg")!, description: "맛있는 김치", discountPrice: 7000, discountPolicy: "특가 할인")
    
    init() {
        mainDishes.addDish(with: mainDish1)
        mainDishes.addDish(with: mainDish2)
        mainDishes.addDish(with: mainDish3)
        
        soupDishes.addDish(with: soupDish1)
        soupDishes.addDish(with: soupDish2)
        
        sideDishes.addDish(with: sideDish)
    }
}
