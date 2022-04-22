import Foundation

struct Response<T: Codable>: Codable {
    let statusCode: Int
    let body: [T]
}
