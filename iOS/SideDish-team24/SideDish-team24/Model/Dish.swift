import Foundation

class Dish {
    private let id: String
    private let name: String
    private let price : Int
    private let stock : Int
    private let type : String
    private let image: URL
    private let description: String
    
    private let discountPrice : Int?
    private let discountPolicy : String?
    
    init(id: String, name: String, price: Int, stock: Int, type: String, image: URL, description: String) {
        self.id = id
        self.name = name
        self.price = price
        self.stock = stock
        self.type = type
        self.image = image
        self.description = description
        self.discountPrice = nil
        self.discountPolicy = nil
    }
    
    init(id: String, name: String, price: Int, stock: Int, type: String, image: URL, description: String, discountPrice: Int, discountPolicy: String) {
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
