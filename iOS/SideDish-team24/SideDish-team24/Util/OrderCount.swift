import Foundation


@propertyWrapper
struct OrderCount {
    private var number = 1
    
    var wrappedValue: Int {
        get { return number }
        set { number = max(newValue, 1) }
    }
    
}
