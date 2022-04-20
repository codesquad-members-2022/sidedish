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

struct Food {
    
    private (set) var detailHash: String
    private (set) var alt: String
    private (set) var foodDescription: String
    private (set) var normalPrice: String
    private (set) var specialPrice: String
    private let deliveryInformation: [String]
    private let title: String
    private let imageUrl: String
    private let badges: [String]
}

extension Food: Codable {
    
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
