import Foundation

struct DetailResponse<T: Codable>: Codable {
    let hash: String
    let data: T
}
