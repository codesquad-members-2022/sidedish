//
//  MenuInfoView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import UIKit

class MenuInfoView: UIView {
    private let infoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.spacing = 8
        return stackView
    }()
    
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
    
    private let priceView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
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
    
    private let badgeView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
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
        addSubview(infoStackView)
        infoStackView.addArrangedSubview(nameLabel)
        infoStackView.addArrangedSubview(descriptionLabel)
        infoStackView.addArrangedSubview(priceView)
        infoStackView.addArrangedSubview(badgeView)
        infoStackView.addArrangedSubview(bottomBar)
        
        priceView.addSubview(priceLabel)
        priceView.addSubview(salePriceLabel)
        
        badgeView.addSubview(badgeStackView)
        
        infoStackView.setCustomSpacing(16, after: priceView)
        infoStackView.setCustomSpacing(24, after: badgeView)
        
        NSLayoutConstraint.activate([
            infoStackView.topAnchor.constraint(equalTo: topAnchor),
            infoStackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            infoStackView.trailingAnchor.constraint(equalTo: trailingAnchor),
            
            priceView.heightAnchor.constraint(equalTo: priceLabel.heightAnchor),
            salePriceLabel.leadingAnchor.constraint(equalTo: priceLabel.trailingAnchor, constant: 8),
            salePriceLabel.bottomAnchor.constraint(equalTo: priceLabel.bottomAnchor),
            
            badgeView.heightAnchor.constraint(equalToConstant: 24),
            
            badgeStackView.topAnchor.constraint(equalTo: badgeView.topAnchor),
            badgeStackView.bottomAnchor.constraint(equalTo: badgeView.bottomAnchor),
            badgeStackView.leadingAnchor.constraint(equalTo: badgeView.leadingAnchor),
            
            bottomBar.heightAnchor.constraint(equalToConstant: 1),
            
            bottomAnchor.constraint(equalTo: bottomBar.bottomAnchor)
        ])
    }
    
    func setData(_ data: Sidedish) {
        nameLabel.text = data.title
        descriptionLabel.text = data.description
        setPrice(data.price, sale: data.salePrice)
        setBadge(data.badge)
    }
    
    private func setPrice(_ price: String, sale: String?) {
        priceLabel.text = price
        if let salePrice = sale {
            let attributeString = NSMutableAttributedString(string: salePrice)
            attributeString.addAttribute(.strikethroughStyle,
                                         value: NSUnderlineStyle.single.rawValue,
                                         range: NSMakeRange(0, attributeString.length))
            salePriceLabel.attributedText = attributeString
        } else {
            salePriceLabel.text = ""
        }
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
}
