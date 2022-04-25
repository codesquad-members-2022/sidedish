//
//  MenuStackView.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/25.
//

import UIKit

final class MenuStackView: UIStackView {
    
    private lazy var menuInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .fillEqually
        return stackView
    }()
    
    private lazy var titleLabel: UILabel = {
        let label = UILabel()
        label.font = .boldSystemFont(ofSize: 14)
        label.textColor = .black
        return label
    }()
    
    private lazy var descriptionLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14)
        label.textColor = .systemGray
        return label
    }()
    
    private(set) lazy var priceStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private lazy var currentPriceLabel: UILabel = {
        let label = UILabel()
        label.font = .boldSystemFont(ofSize: 14)
        return label
    }()
    
    private lazy var previousPriceLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14)
        return label
    }()
    
    private(set) lazy var badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .fillProportionally
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setUpView() {
        configureView()
        
        addArrangedSubview(menuInfoStackView)
        menuInfoStackView.addArrangedSubview(titleLabel)
        menuInfoStackView.addArrangedSubview(descriptionLabel)
        menuInfoStackView.addArrangedSubview(priceStackView)
        addArrangedSubview(badgeStackView)
        
        layoutMenuInfoStackView()
    }
    
    private func configureView() {
        axis = .vertical
        spacing = 8
        alignment = .leading
        distribution = .equalSpacing
    }
    
    private func convertTextStyleToStrikeThrough(label: UILabel) {
        guard let text = label.text else { return }
        let attributeString: NSMutableAttributedString = NSMutableAttributedString(string: text)
        attributeString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                     value: NSUnderlineStyle.single.rawValue,
                                     range: NSRange(location: 0, length: attributeString.length))
        label.textColor = .systemGray
        label.attributedText = attributeString
    }
    
    private func setCurrentPriceLabel(price text: String) {
        currentPriceLabel.text = text
    }
    
    private func setPreviousPriceLabel(price text: String) {
        previousPriceLabel.text = text
    }
}

// MARK: - View Layout

extension MenuStackView {
    private func layoutMenuInfoStackView() {
        menuInfoStackView.translatesAutoresizingMaskIntoConstraints = false
        menuInfoStackView.heightAnchor.constraint(greaterThanOrEqualToConstant: 72).isActive = true
    }
}

// MARK: - Providing Function

extension MenuStackView {
    func setTitle(by text: String) {
        titleLabel.text = text
    }
    
    func setDescription(by text: String) {
        descriptionLabel.text = text
    }
    
    func setPrice(originPrice: String?, discountedPrice: String?) {
        guard let discountedPrice = discountedPrice else { return }
        
        if let originPrice = originPrice {
            setCurrentPriceLabel(price: discountedPrice)
            setPreviousPriceLabel(price: originPrice)
            convertTextStyleToStrikeThrough(label: previousPriceLabel)
            priceStackView.addArrangedSubview(currentPriceLabel)
            priceStackView.addArrangedSubview(previousPriceLabel)
            
        } else {
            setCurrentPriceLabel(price: discountedPrice)
            priceStackView.addArrangedSubview(currentPriceLabel)
        }
    }
    
    func setBadges(by types: [String]?) {
        guard let types = types else { return }
        types.forEach { type in
            switch type {
            case "런칭특가":
                let badge = UILabel.makeBadge(title: "런칭특가", backgroundColor: UIColor.launchingBadgeBackground)
                badgeStackView.addArrangedSubview(badge)
            case "이벤트특가":
                let badge = UILabel.makeBadge(title: "이벤트특가", backgroundColor: UIColor.eventBadgeBackground)
                badgeStackView.addArrangedSubview(badge)
            default:
                let badge = UILabel.makeBadge(title: type, backgroundColor: UIColor.defaultBadgeBackground)
                badgeStackView.addArrangedSubview(badge)
            }
        }
    }
    
    func changeFontForDetailView() {
        titleLabel.font = .systemFont(ofSize: 32)
        descriptionLabel.font = .systemFont(ofSize: 18)
        currentPriceLabel.font = .boldSystemFont(ofSize: 18)
        currentPriceLabel.textColor = .darkGray
        previousPriceLabel.font = .systemFont(ofSize: 16)
    }
    
    func changeSpacingForDetailView() {
        spacing = 16
        menuInfoStackView.spacing = 8
        menuInfoStackView.distribution = .equalSpacing
        priceStackView.spacing = 8
    }
}

// MARK: - Private Extension

private extension UILabel {
    static func makeBadge(title: String, backgroundColor: UIColor) -> UILabel {
        let label = PaddingLabel(padding: UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16))
        label.text = title
        label.font = .boldSystemFont(ofSize: 14)
        label.adjustsFontSizeToFitWidth = true
        label.minimumScaleFactor = 0.5
        label.textAlignment = .center
        label.textColor = .white
        label.backgroundColor = backgroundColor
        label.layer.cornerRadius = 13
        label.layer.masksToBounds = true
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
