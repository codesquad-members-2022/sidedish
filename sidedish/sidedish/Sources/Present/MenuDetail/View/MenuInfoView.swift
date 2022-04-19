//
//  MenuInfoView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import UIKit

class MenuInfoView: UIView {    
    private let nameLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 32)
        label.textAlignment = .left
        label.textColor = .black
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 18)
        label.textAlignment = .left
        label.textColor = .grey2
        return label
    }()
    
    private let priceStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        stackView.alignment = .bottom
        stackView.spacing = 8
        return stackView
    }()
    
    private let priceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 18, weight: .bold)
        label.textAlignment = .left
        label.textColor = .grey1
        return label
    }()
    
    private let salePriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 16)
        label.textAlignment = .left
        label.textColor = .grey2
        return label
    }()
    
    private let badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        stackView.spacing = 4
        return stackView
    }()
    
    private let bottomBar: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .grey3
        return view
    }()
    
    init() {
        super.init(frame: .zero)
        layout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        layout()
    }
    
    private func layout() {
        addSubview(nameLabel)
        addSubview(descriptionLabel)
        addSubview(priceStackView)
        priceStackView.addArrangedSubview(priceLabel)
        priceStackView.addArrangedSubview(salePriceLabel)
        addSubview(badgeStackView)
        addSubview(bottomBar)
        
        NSLayoutConstraint.activate([
            nameLabel.topAnchor.constraint(equalTo: topAnchor),
            nameLabel.leadingAnchor.constraint(equalTo: leadingAnchor),
            nameLabel.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            descriptionLabel.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 8),
            descriptionLabel.leadingAnchor.constraint(equalTo: leadingAnchor),
            descriptionLabel.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            priceStackView.topAnchor.constraint(equalTo: descriptionLabel.bottomAnchor, constant: 8),
            priceStackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            priceStackView.trailingAnchor.constraint(equalTo: salePriceLabel.trailingAnchor),
            priceStackView.heightAnchor.constraint(equalTo: priceLabel.heightAnchor),
            
            badgeStackView.topAnchor.constraint(equalTo: priceStackView.bottomAnchor, constant: 16),
            badgeStackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            badgeStackView.heightAnchor.constraint(equalToConstant: 24),
            
            bottomBar.topAnchor.constraint(equalTo: badgeStackView.bottomAnchor, constant: 24),
            bottomBar.leadingAnchor.constraint(equalTo: leadingAnchor),
            bottomBar.trailingAnchor.constraint(equalTo: trailingAnchor),
            bottomBar.heightAnchor.constraint(equalToConstant: 1),
            
            bottomAnchor.constraint(equalTo: bottomBar.bottomAnchor)
        ])
    }
    
    func setData(_ data: Sidedish) {
        nameLabel.text = data.title
        descriptionLabel.text = data.description
        priceLabel.text = data.price
        if let salePrice = data.salePrice {
            let attributeString = NSMutableAttributedString(string: salePrice)
            attributeString.addAttribute(.strikethroughStyle,
                                         value: NSUnderlineStyle.single.rawValue,
                                         range: NSMakeRange(0, attributeString.length))
            salePriceLabel.attributedText = attributeString
        } else {
            salePriceLabel.text = ""
        }
        
        data.badge?.forEach { badge in
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
}
