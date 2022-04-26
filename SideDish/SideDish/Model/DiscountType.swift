import Foundation

enum DiscountType {
    case event
    case launching

    var description: String {
        switch self {
        case .event:
            return "이벤트특가"
        case .launching:
            return "런칭특가"
        }
    }

    init?(_ rawValue: String) {
        switch rawValue {
        case "이벤트특가":
            self = .event
        case "런칭특가":
            self = .launching
        default:
            return nil
        }
    }
}
