import Foundation

enum ProductSort: String, CaseIterable {
    case main = "/main"
    case soup = "/soup"
    case side = "/side"
}

typealias ProductModel = [ProductSort: [Product]]
