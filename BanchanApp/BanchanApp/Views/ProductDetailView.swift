//
//  ProductDetailView.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductDetailView: UIView {

    private let title: UILabel = UILabel()
    private let menuDescription: UILabel = UILabel()
    private let normalPrice: UILabel? = UILabel()
    private let salePrice: UILabel = UILabel()
    private let badges: UIStackView = UIStackView()
    private let badgeList: [String] = ["런칭특가", "이벤트특가"]

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    private func setup() {
        title.applySemiBold()
        menuDescription.applyColorGray()
        salePrice.applySemiBold()
        normalPrice?.applyColorGray()
        normalPrice?.applyStrikethoroughStyle()

        title.text = "오리 주물럭_반조리"
        menuDescription.text = "감칠맛 나는 매콤한 양념"
        normalPrice?.text = "12,640원"
        salePrice.text = "15,800원"
        badgeList.forEach {
            let badge = BadgeLabel(color: .systemBlue)
            badge.text = $0
            badges.addArrangedSubview(badge)
        }

        badges.addArrangedSubview(BadgeLabel(color: .systemBackground))
        badges.axis = .horizontal
        badges.spacing = 5
        badges.distribution = .fillProportionally

        let priceStackView: UIStackView = UIStackView(arrangedSubviews: [salePrice])
        if let normalPrice = normalPrice {
            priceStackView.addArrangedSubview(normalPrice)
        }

        salePrice.setContentHuggingPriority(.defaultHigh, for: .horizontal)
        priceStackView.axis = .horizontal
        priceStackView.spacing = 5
        priceStackView.distribution = .fill

        let stackView: UIStackView = UIStackView(arrangedSubviews: [title, menuDescription, priceStackView, badges])
        stackView.axis = .vertical
        stackView.distribution = .fillEqually

        self.addSubview(stackView)

        stackView.translatesAutoresizingMaskIntoConstraints = false

        NSLayoutConstraint.activate([
            stackView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor),
            stackView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            stackView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor)
        ])
    }

}

extension UILabel {

    func applyStrikethoroughStyle() {
        if let text = self.text {
            let attributeString = NSMutableAttributedString(string: text)
            attributeString.addAttribute(.strikethroughStyle, value: NSUnderlineStyle.single.rawValue, range: NSRange(location: 0, length: attributeString.length))
            self.attributedText = attributeString
        }
    }

    func applySemiBold() {
        self.font = .systemFont(ofSize: 14, weight: .semibold)
    }

    func applyColorGray() {
        self.font = .systemFont(ofSize: 14)
        self.textColor = .systemGray2
    }

}

class BadgeLabel: UILabel {

    private var padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)

    convenience init(color: UIColor) {
        self.init()
        setupStyle(with: color)
    }

    private func setupStyle(with color: UIColor) {
        self.font = .systemFont(ofSize: 12, weight: .semibold)
        self.textColor = .white
        self.backgroundColor = color
        self.textAlignment = .center
        self.layer.masksToBounds = true
        self.layer.cornerCurve = .continuous
        self.layer.cornerRadius = 15
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
