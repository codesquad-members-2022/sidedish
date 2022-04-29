//
//  ProductDetailView.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductDetailView: UIView {
    private let title: UILabel = .init()
    private let menuDescription: UILabel = .init()
    private let normalPrice: UILabel? = UILabel()
    private let salePrice: UILabel = .init()
    private let badges: UIStackView = .init()
    private var badgeList: [String] = [] {
        didSet {
            self.configureBadges()
        }
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    private func configureBadges() {
        if badges.subviews.count != .zero {
            badges.clearSubviews()
        }

        badgeList.forEach {
            let badge = BadgeLabel(color: UIColor(named: "Primary Dark") ?? .systemBlue)
            badge.text = $0
            badges.addArrangedSubview(badge)
        }
    }

    private func setup() {
        menuDescription.textColor = .gray2
        normalPrice?.textColor = .gray2

        badges.axis = .horizontal
        badges.spacing = 5
        badges.alignment = .center
        badges.distribution = .fillProportionally

        let priceStackView = UIStackView(arrangedSubviews: [salePrice])
        if let normalPrice = normalPrice {
            priceStackView.addArrangedSubview(normalPrice)
        }

        salePrice.setContentHuggingPriority(.defaultHigh, for: .horizontal)
        priceStackView.axis = .horizontal
        priceStackView.spacing = 5
        priceStackView.distribution = .fill

        let stackView = UIStackView(arrangedSubviews: [title, menuDescription, priceStackView, badges])
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .fill
        stackView.spacing = 5

        addSubview(stackView)

        stackView.translatesAutoresizingMaskIntoConstraints = false

        NSLayoutConstraint.activate([
            stackView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor),
            stackView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            stackView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor)
        ])
    }

    func setTitleText(_ text: String, font: UIFont = .textSmallBold) {
        title.text = text
        title.font = font
    }

    func setDescriptionText(_ text: String, font: UIFont = .textSmallRegular) {
        menuDescription.text = text
        menuDescription.font = font
    }

    func setSalePrice(_ text: String, font: UIFont = .textSmallBold) {
        salePrice.text = text
        salePrice.font = font
    }

    func setNormalPrice(_ text: String, font: UIFont = .textSmallRegular) {
        normalPrice?.text = text
        normalPrice?.font = font
        normalPrice?.applyStrikethoroughStyle()
    }

    func setBadgeList(_ list: [String]) {
        badgeList = list
    }
}
