import Foundation

struct MainResponse<T: Codable>: Codable {
    let statusCode: Int
    let body: [T]
}
