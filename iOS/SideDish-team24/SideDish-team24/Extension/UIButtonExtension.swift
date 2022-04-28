import UIKit

extension UIButton {
    static func customButton(_ title: String, _ backgroundColor: UIColor) -> UIButton {
        var attribute = AttributeContainer()
        attribute.font = UIFont.systemFont(ofSize: 18, weight: UIFont.Weight(600))
        attribute.foregroundColor = UIColor.white
        
        var configuration = UIButton.Configuration.filled()
        configuration.attributedTitle = AttributedString(title, attributes: attribute)
        configuration.contentInsets = NSDirectionalEdgeInsets(top: CGFloat.defaultInset, leading: 0, bottom: CGFloat.defaultInset, trailing: 0)
        configuration.cornerStyle = .large
        configuration.baseBackgroundColor = backgroundColor
        
        let button = UIButton(configuration: configuration)
        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }
}
