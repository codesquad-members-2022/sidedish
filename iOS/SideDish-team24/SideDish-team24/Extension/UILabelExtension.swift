import UIKit

extension UILabel {
    static func customLabel(_ title: String,_ color: UIColor,_ fontSize: CGFloat,_ fontWeight: CGFloat = 400,_ bold: Bool = false ) -> UILabel {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = bold ? UIFont.boldSystemFont(ofSize: fontSize) : UIFont.systemFont(ofSize: fontSize, weight: UIFont.Weight(fontWeight))
        label.textColor = color
        label.text = title
        return label
    }
}
