//
//  MenuInfoView.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/21.
//

import UIKit

struct MenuInfoAttribute {
    let stackViewSpacing: CGFloat
    let titleFont: UIFont
    let titleTextColor: UIColor
    let discriptionFont: UIFont
    let discriptionTextColor: UIColor
    let priceFont: UIFont
    let priceTextColor: UIColor
    let salePriceFont: UIFont
    let salePriceTextColor: UIColor
    let badgeStackViewSpacing: CGFloat
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
    
    func changePriceLabel(text: String) {
        priceLabel.text = text
    }
    
    func changeSalePriceLabel(text: String) {
        salePriceLabel.attributedText = text.strikeThrough()
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
