import UIKit

class CustomLabel: UILabel {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    convenience init(title: String, font: UIFont?, color: UIColor?) {
        self.init()
        self.initialSet(title: title, font: font, color: color)
    }
    
    private func initialSet(title: String, font: UIFont?, color: UIColor?) {
        self.translatesAutoresizingMaskIntoConstraints = false
        self.text = title
        self.font = font
        self.textColor = color
    }
    
    func setFont(font: UIFont?, color: UIColor?) {
        self.font = font
        self.textColor = color
    }
}
