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
    
    var headerText: String{
        switch self {
        case .main:
            return "모두가 좋아하는 \n든든한 메인 요리"
        case .side:
            return "정성이 담긴 \n뜨끈뜨끈 국물 요리"
        case .soup:
            return "식탁을 풍성하게 하는 \n정갈한 밑반찬"
        }
    }
}
