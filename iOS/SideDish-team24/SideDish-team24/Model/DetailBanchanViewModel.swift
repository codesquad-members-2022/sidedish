import UIKit

class DetailBanchanViewModel {
    let dishTitle: String
    let dishDescription: String
    let discountPrice: Int
    let normalPrice: Int
    let reserve: String
    let deliveryFee: Int
    let totalAmount: Int
    
    init() {
        dishTitle = "요리 제목"
        dishDescription = "감질맛 나는 요리 설명"
        discountPrice = 12640
        normalPrice = 15800
        reserve = "126원"
        deliveryFee = 2500
        totalAmount = 12640
    }

}
