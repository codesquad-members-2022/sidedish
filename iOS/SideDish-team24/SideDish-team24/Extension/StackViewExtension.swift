import UIKit

extension UIStackView {
    static func customStackView(_ axis: NSLayoutConstraint.Axis, _ distribution: UIStackView.Distribution, spacing: CGFloat? = nil) -> UIStackView {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = axis
        stackView.distribution = distribution
        if let spacing = spacing {
            stackView.spacing = spacing            
        }
        return stackView
    }
}
