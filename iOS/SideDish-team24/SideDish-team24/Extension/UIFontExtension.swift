import UIKit.UIFont

extension UIFont {
    
    static let largeRegular = UIFont(name: "SFProDisplay-Regular", size: 32)
    
    static let mediumRegular = UIFont(name: "SFProDisplay-Regular", size: 18)
    
    static let middleRegular = UIFont(name: "SFProDisplay-Regular", size: 18)
    
    static let smallRegular = UIFont(name: "SFProDisplay-Regular", size: 14)
    
    static let largeBold = UIFont(name: "SFProDisplay-Regular", size: 32)?.semibold
    
    static let mediumBold = UIFont(name: "SFProDisplay-Regular", size: 18)?.semibold
    
    static let smallBold = UIFont(name: "SFProDisplay-Regular", size: 14)?.semibold
    
    static let caption = UIFont(name: "SFProDisplay-Regular", size: 12)?.semibold
    
}

private extension UIFont {
    var semibold: UIFont { return withWeight(.semibold) }
    
    func withWeight(_ weight: UIFont.Weight) -> UIFont {
        var attributes = fontDescriptor.fontAttributes
        var traits = (attributes[.traits] as? [UIFontDescriptor.TraitKey: Any]) ?? [:]
        
        traits[.weight] = weight
        
        attributes[.name] = nil
        attributes[.traits] = traits
        attributes[.family] = familyName
        
        let descriptor = UIFontDescriptor(fontAttributes: attributes)
        
        return UIFont(descriptor: descriptor, size: pointSize)
    }
}
