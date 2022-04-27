//
//  MenuInfoView.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/21.
//

import UIKit

class MenuInfoAttribute {
    var stackViewSpacing: CGFloat = 0
    var titleFont: UIFont = .systemFont(ofSize: 15)
    var titleTextColor: UIColor = .white
    var discriptionFont: UIFont = .systemFont(ofSize: 15)
    var discriptionTextColor: UIColor = .white
    var priceFont: UIFont = .systemFont(ofSize: 15)
    var priceTextColor: UIColor = .white
    var salePriceFont: UIFont = .systemFont(ofSize: 15)
    var salePriceTextColor: UIColor = .white
    var badgeStackViewSpacing: CGFloat = 0
}

class MenuInfoView: UIView {
    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()
    
    private let titleLabel = UILabel()
    private let descriptionLabel = UILabel()
    private let priceView = UIView()

    private let priceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let salePriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private let badgeView = UIView()
    
    private let badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        return stackView
    }()
    
    init(attribute: MenuInfoAttribute) {
        super.init(frame: .zero)
        
        self.stackView.spacing = attribute.stackViewSpacing
        self.titleLabel.font = attribute.titleFont
        self.titleLabel.textColor = attribute.titleTextColor
        self.priceLabel.font = attribute.priceFont
        self.priceLabel.textColor = attribute.priceTextColor
        self.salePriceLabel.font = attribute.salePriceFont
        self.salePriceLabel.textColor = attribute.salePriceTextColor
        self.badgeStackView.spacing = attribute.badgeStackViewSpacing
        
        layout()
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func layout() {
        addSubview(stackView)
        stackView.addArrangedSubview(titleLabel)
        stackView.addArrangedSubview(descriptionLabel)
        stackView.addArrangedSubview(priceView)
        stackView.addArrangedSubview(badgeView)
        
        priceView.addSubview(priceLabel)
        priceView.addSubview(salePriceLabel)
        
        badgeView.addSubview(badgeStackView)
    
        NSLayoutConstraint.activate([
            stackView.topAnchor.constraint(equalTo: topAnchor),
            stackView.bottomAnchor.constraint(equalTo: bottomAnchor),
            stackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            priceView.heightAnchor.constraint(equalTo: priceLabel.heightAnchor),
            salePriceLabel.leadingAnchor.constraint(equalTo: priceLabel.trailingAnchor, constant: 8),
            salePriceLabel.bottomAnchor.constraint(equalTo: priceLabel.bottomAnchor),
            
            badgeView.heightAnchor.constraint(equalToConstant: 34),
            
            badgeStackView.topAnchor.constraint(equalTo: badgeView.topAnchor, constant: 10),
            badgeStackView.bottomAnchor.constraint(equalTo: badgeView.bottomAnchor),
            badgeStackView.leadingAnchor.constraint(equalTo: badgeView.leadingAnchor)
        ])
    }
}

extension MenuInfoView {
    func changeTitleLabel(text: String) {
        titleLabel.text = text
    }
    
    func changeDescriptionLabel(text: String) {
        descriptionLabel.text = text
    }
    
    func changePriceLabel(price: Int) {
        priceLabel.text = price.printCurrency()
    }
    
    func changeSalePriceLabel(price: String?) {
        guard let price = price else {
            return
        }
        salePriceLabel.attributedText = price.strikeThrough()
    }
    
    func changeSaleBadge(_ badges: [String]?) {
        badgeView.isHidden = (badges == nil)
        
        badgeStackView.subviews.forEach { $0.removeFromSuperview() }
        
        badges?.forEach { badge in
            let paddingLabel = makeBadge()
            paddingLabel.text = badge
            switch badge {
            case "이벤트특가":
                paddingLabel.backgroundColor = .primary3
            case "런칭특가":
                paddingLabel.backgroundColor = .primary1
            default:
                paddingLabel.backgroundColor = .primary2
            }
            badgeStackView.addArrangedSubview(paddingLabel)
        }
    }
    
    private func makeBadge() -> PaddingLabel {
        let paddingLabel = PaddingLabel()
        paddingLabel.padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)
        paddingLabel.font = .systemFont(ofSize: 12, weight: .bold)
        paddingLabel.textColor = .white
        paddingLabel.clipsToBounds = true
        paddingLabel.layer.cornerRadius = 12
        return paddingLabel
    }
}
