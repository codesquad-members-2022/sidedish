import UIKit

extension UILabel {
    static func customLabel(_ color: UIColor, _ title: String = "", _ fontSize: CGFloat = 14, _ fontWeight: CGFloat = 400) -> UILabel {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: fontSize, weight: UIFont.Weight(fontWeight))
        label.textColor = color
        label.text = title
        return label
    }
    
    static func customBadge(_ title: String, _ backGroundColor: UIColor) -> UILabel {
        let label = PaddingLabel(padding: UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16))
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 12, weight: UIFont.Weight(600))
        label.text = title
        label.backgroundColor = backGroundColor
        label.textAlignment = .center
        label.textColor = .white
        label.clipsToBounds = true
        label.layer.cornerRadius = 10
        return label
    }
}

final class PaddingLabel: UILabel {
    private var padding = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
    
    convenience init(padding: UIEdgeInsets) {
        self.init()
        self.padding = padding
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
}
