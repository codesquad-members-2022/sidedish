import Foundation

struct Food: Codable {
    
    private (set) var detailHash: String
    private (set) var title: String
    private (set) var foodDescription: String
    private (set) var normalPrice: String
    private (set) var specialPrice: String
    private let deliveryInformation: [String]
    private let alt: String
    private (set) var imageUrl: String
    private (set) var badges: [String]
    
    init(detailHash: String, alt: String, foodDescription: String, normalPrice: String, specialPrice: String, deliveryInformation: [String], title: String, imageUrl: String, badges: [String]) {
        self.detailHash = detailHash
        self.alt = alt
        self.foodDescription = foodDescription
        self.normalPrice = normalPrice
        self.specialPrice = specialPrice
        self.deliveryInformation = deliveryInformation
        self.title = title
        self.imageUrl = imageUrl
        self.badges = badges
    }
    
    enum CodingKeys: String, CodingKey {
        case detailHash = "detail_hash"
        case alt = "alt"
        case foodDescription = "description"
        case title = "title"
        case normalPrice = "n_price"
        case specialPrice = "s_price"
        case deliveryInformation = "delivery_type"
        case badges = "badge"
        case imageUrl = "image"
    }
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        detailHash = try container.decode(String.self, forKey: .detailHash)
        alt = try container.decode(String.self, forKey: .alt)
        title = try container.decode(String.self, forKey: .title)
        foodDescription = try container.decode(String.self, forKey: .foodDescription)
        specialPrice = try container.decode(String.self, forKey: .specialPrice)
        normalPrice = (try? container.decode(String.self, forKey: .normalPrice)) ?? "0원"
        deliveryInformation = try container.decode([String].self, forKey: .deliveryInformation)
        badges = (try? container.decode([String].self, forKey: .badges)) ?? []
        imageUrl = try container.decode(String.self, forKey: .imageUrl)
    }

}

