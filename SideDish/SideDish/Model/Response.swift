import Foundation

struct Response: Codable {
    let statusCode: Int
    let body: [Food]
}
