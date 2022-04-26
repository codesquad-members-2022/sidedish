import Foundation

enum NetworkError: Error {
    case noData
    case transferError
    case wrongEndPoint
    case serverError(statusCode: Int)
    case unDecoded
}
