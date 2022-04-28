import UIKit

extension UIStackView {
    static func customStackView(_ axis: NSLayoutConstraint.Axis, _ distribution: UIStackView.Distribution, spacing: CGFloat = 0) -> UIStackView {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = axis
        stackView.distribution = distribution
        stackView.spacing = spacing
        return stackView
    }
    
    func addBorder(with view: UIView) {
        self.addArrangedSubview(view)
        self.addArrangedSubview(DetailViewBorder())
    }
}
