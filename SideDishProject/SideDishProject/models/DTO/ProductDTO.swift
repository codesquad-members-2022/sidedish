import Foundation

struct CategoryDTO: Codable {
    let id: Int
    let name: String
    let count: Int
}

struct ProductDTO: Codable {
    let id: Int
    let name: String
    let imageUrl: String
    let description: String
    let price: Int
    let discountPrice: Int
    let events: [String]
    
    enum CodingKeys: String, CodingKey {
        case id, name, imageUrl, description, price, events
        case discountPrice = "discount_price"
    }
}
