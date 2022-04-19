import Foundation
import UIKit

extension UIColor {
    static let dishBlack = UIColor(rgb: 0x010101)
    static let dishGrey = UIColor(rgb: 0x828282)
    static let dishLightGrey = UIColor(rgb: 0x4F4F4F)
    static let dishWhite = UIColor(rgb: 0xFFFFFF)
    static let dishBlue = UIColor(rgb: 0x0066D6)
    static let dishSkyBlue = UIColor(rgb: 0x80BCFF)
    
    convenience init(red: Int, green: Int, blue: Int) {
        assert(red >= 0 && red <= 255, "Invalid red component")
        assert(green >= 0 && green <= 255, "Invalid green component")
        assert(blue >= 0 && blue <= 255, "Invalid blue component")
        
        self.init(red: CGFloat(red) / 255.0, green: CGFloat(green) / 255.0, blue: CGFloat(blue) / 255.0, alpha: 1.0)
    }
    
    convenience init(rgb: Int) {
        self.init(
            red: (rgb >> 16) & 0xFF,
            green: (rgb >> 8) & 0xFF,
            blue: rgb & 0xFF
        )
    }
}
