import Foundation

extension Int {
    func convertToWon() -> String {
        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .decimal
        guard let won = numberFormatter.string(from: NSNumber(value: self)) else { return "" }
        
        return "\(won)원"
    }
}
