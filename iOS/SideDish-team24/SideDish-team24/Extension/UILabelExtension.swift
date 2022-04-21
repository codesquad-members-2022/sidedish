import UIKit

extension UILabel {
    static let customLabel = { (title: String, color: UIColor) -> UILabel in
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 14, weight: UIFont.Weight(400))
        label.textColor = color
        label.text = title
        
        return label
    }
}
