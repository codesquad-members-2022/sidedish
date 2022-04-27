import UIKit

final class PaddingLabel: UILabel {
    private var padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)
    
    convenience init(title: String, color: UIColor) {
        self.init()
        self.layout(title: title, color: color)
    }
    
    override func drawText(in rect: CGRect) {
        super.drawText(in: rect.inset(by: padding))
    }
    
    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize
        contentSize.height += padding.top + padding.bottom
        contentSize.width += padding.left + padding.right
        
        return contentSize
    }
    
    private func layout(title: String, color: UIColor) {
        self.translatesAutoresizingMaskIntoConstraints = false
        self.text = title
        self.font = .caption
        self.backgroundColor = color
        self.textAlignment = .center
        self.textColor = .white
        self.clipsToBounds = true
        self.layer.cornerRadius = 10
    }
}
