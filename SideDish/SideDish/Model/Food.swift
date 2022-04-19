import Foundation

/*
 - 고유번호
   - 이미지 주소
   - 이름(alt)
   - 설명
   - 제목(title)
   - 정가
   - 특가
   - 특가정보
 */

struct Food{
    private (set) var detailHash: String
    private (set) var alt: String
    private (set) var foodDescription: String
    private let category: String
    private (set) var normalPrice: Int
    private (set) var specialPrice: Int
    private let deliveryInformation: String
    private let deliveryCharge: Int
    private let amount:Int
    private let badges: [String]
    
    init(detailHash: String, alt: String, foodDescription: String, category: String, normalPrice: Int, specialPrice: Int, deliveryInformation: String, deliveryCharge: Int, amount: Int, badges: [String]){
        self.detailHash = detailHash
        self.alt = alt
        self.foodDescription = foodDescription
        self.category = category
        self.normalPrice = normalPrice
        self.specialPrice = specialPrice
        self.deliveryInformation = deliveryInformation
        self.deliveryCharge = deliveryCharge
        self.amount = amount
        self.badges = badges
    }
}
