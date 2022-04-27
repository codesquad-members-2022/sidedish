import Foundation

struct FoodDetail: Codable {
    private (set) var topImageUrl: String
    private (set) var thumbImageUrls: [String]
    private (set) var productDescription: String
    private (set) var point: String
    private (set) var deliveryInfo: String
    private (set) var deliveryFee: String
    private (set) var prices: [String]
    private (set) var detailImageUrls: [String]
    
    enum CodingKeys: String, CodingKey {
        case topImageUrl = "top_image"
        case thumbImageUrls = "thumb_images"
        case productDescription = "product_description"
        case point = "point"
        case deliveryInfo = "delivery_info"
        case deliveryFee = "delivery_fee"
        case prices = "prices"
        case detailImageUrls = "detail_section"
    }
        
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
    
        topImageUrl = (try? container.decode(String.self, forKey: .topImageUrl)) ?? ""
        thumbImageUrls = (try? container.decode([String].self, forKey: .thumbImageUrls)) ?? []
        productDescription = (try? container.decode(String.self, forKey: .productDescription)) ?? ""
        point = (try? container.decode(String.self, forKey: .point)) ?? ""
        deliveryInfo = (try? container.decode(String.self, forKey: .deliveryInfo)) ?? ""
        deliveryFee = (try? container.decode(String.self, forKey: .deliveryFee)) ?? ""
        prices = (try? container.decode([String].self, forKey: .prices)) ?? []
        detailImageUrls = (try? container.decode([String].self, forKey: .detailImageUrls)) ?? []
    }
}
