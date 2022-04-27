import Foundation

enum Category: CaseIterable {
    case main
    case side
    case soup
    
    var fileName: String {
        switch self {
        case .main:
            return "main"
        case .side:
            return "side"
        case .soup:
            return "soup"
        }
    }
}
