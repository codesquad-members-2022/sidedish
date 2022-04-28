import UIKit

class BanchanViewModel {
    private let dish: Dish
    
    lazy var image: UIImage? = {
        guard let data = try? Data(contentsOf: self.dish.image) else { return nil }
        let image = UIImage(data: data)
        return image
    }()
    
    @OrderCount var count: Int {
        didSet {
            NotificationCenter.default.post(name: .counterValueChanged,
                                            object: nil,
                                            userInfo: [NotificationKeyValue.count: count,
                                                       NotificationKeyValue.amount: totalAmount])
        }
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
        return self.dish.price * count
    }
    var orderCount: Int {
        return 0
    }
    
    init(dish: Dish) {
        self.dish = dish
    }

}
