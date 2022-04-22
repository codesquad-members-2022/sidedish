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
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "오리주물럭"
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.text = "맛있는 오리주물럭"
        return label
    }()
    
    private let priceView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let priceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.textAlignment = .left
        label.text = "12,300"
        return label
    }()
    
    private let salePriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.textAlignment = .left
        label.text = "15,000"
        return label
    }()
    
    private let badgeView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
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
        setBadge(["런칭특가"]) // 임시
        
        salePriceLabel.attributedText = salePriceLabel.text?.strikeThrough()
    
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func setBadge(_ badges: [String]?) {
        badges?.forEach { badge in
            let paddingLabel = makeBadge()
            paddingLabel.text = badge
            switch badge {
            case "이벤트특가":
                paddingLabel.backgroundColor = .primary3
            case "런칭특가":
                paddingLabel.backgroundColor = .primary1
            default:
                paddingLabel.backgroundColor = .primary3
            }
            badgeStackView.addArrangedSubview(paddingLabel)
            badgeStackView.trailingAnchor.constraint(equalTo: paddingLabel.trailingAnchor).isActive = true
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
