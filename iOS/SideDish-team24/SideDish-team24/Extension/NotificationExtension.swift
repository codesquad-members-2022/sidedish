import Foundation

extension Notification.Name {
    static let stepperTouched: Notification.Name = Notification.Name("stepperTouched")
    
    static let counterValueChanged: Notification.Name = Notification.Name("valueChanged")
}

enum NotificationKeyValue: String {
    case count
    case amount
    case stepperValue
}
