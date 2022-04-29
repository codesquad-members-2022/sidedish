import Foundation

struct DetailStringData {
    let description: String
    let finalPrice: String
    var normalPrice: String?
    let point: String
    let deliveryInfo: String
    let deliveryFee: String

    init(entity: DetailData) {
        description = entity.productDescription
        finalPrice = entity.prices[0]
        point = entity.point
        deliveryInfo = entity.deliveryInfo
        deliveryFee = entity.deliveryFee

        if entity.prices.count > 1 {
            normalPrice = entity.prices[1]
        }
    }
}
