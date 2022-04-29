import Foundation

struct CategoryDTO: Codable {
    let id: Int
    let name: String
    let count: Int
    
    func convertDTOtoEntity() -> DishCategory{
        return DishCategory(id: id, name: name, count: count)
    }
}

struct ProductDTO: Codable {
    let id: Int
    let name: String
    let imageUrl: String
    let description: String
    let price: Int
    let discountPrice: Int
    let events: [String]
    
    func convertDTOtoEntity(category: DishCategory) -> Product{
        var productEvents: [ProductEvent] = []
        for event in events {
            var eventState = ProductEvent.none(disCount: 1)
            switch event{
            case "런칭특가":
                eventState = ProductEvent.launchingPrice(disCount: 0.15)
            case "이벤트특가":
                eventState = ProductEvent.eventPrice(disCount: 0.2)
            default :
                eventState = ProductEvent.none(disCount: 1)
            }
            productEvents.append(eventState)
        }
        return Product(name: name, price: price, description: description, stock: 1, category: category, imageUrl: imageUrl, event: productEvents)
    }
}
