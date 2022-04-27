import Foundation

struct DetailResponse<T: Codable>: Codable {
    let hash: Int
    let data: T
}
