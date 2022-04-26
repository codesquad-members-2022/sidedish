import UIKit

class BanchanViewModel {
    private let dish: Dish
    
    var dishTitle: String {
        return self.dish.name
    }
    var dishDescription: String {
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
