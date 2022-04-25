import Foundation

final class Dish {
    private let id: String
    private(set) var name: String
    private(set) var price: Int
    private(set) var stock: Int
    private(set) var type: String
    private(set) var image: URL
    private(set) var description: String
    
    private(set) var discountPrice: Int?
    private(set) var discountPolicy: String?
    
    init(id: String, name: String, price: Int, stock: Int, type: String, image: URL, description: String, discountPrice: Int?, discountPolicy: String?) {
        self.id = id
        self.name = name
        self.price = price
        self.stock = stock
        self.type = type
        self.image = image
        self.description = description
        self.discountPrice = discountPrice
        self.discountPolicy = discountPolicy
    }
    
}
