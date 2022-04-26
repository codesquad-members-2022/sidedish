import UIKit

class BanchanViewModel {
    private let dish: Dish
    
    var image: UIImage? {
        let data = try? Data(contentsOf: self.dish.image)
        let image = UIImage(data: data!)
        return image
    }
    
    var discountPolicy: String? {
        return dish.discountPolicy
    }
    
    var title: String {
        return self.dish.name
    }
    var description: String {
        return self.dish.description
    }
    var price: String {
        return self.dish.price.convertToWon()
    }
    var listPrice: String? {
        return self.dish.listPrice?.convertToWon()
    }
    var reserve: String {
        return (self.dish.price/100).convertToWon()
    }
    var deliveryFee: Int {
        return 0
    }
    var totalAmount: Int {
        return 0
    }
    var orderCount: Int {
        return 0
    }
    
    init(dish: Dish) {
        self.dish = dish
    }

}
