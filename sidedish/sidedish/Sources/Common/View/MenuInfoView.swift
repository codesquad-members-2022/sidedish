//
//  MenuInfoView.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/21.
//

import SnapKit
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
        return stackView
    }()
    
    private let titleLabel = UILabel()
    private let descriptionLabel = UILabel()
    private let priceView = UIView()

    private let priceLabel = UILabel()
    
    private let salePriceLabel = UILabel()
    
    private let badgeView = UIView()
    
    private let badgeStackView: UIStackView = {
        let stackView = UIStackView()
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
        
        stackView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
        
        priceView.snp.makeConstraints { make in
            make.height.equalTo(priceLabel)
        }
        
        priceLabel.snp.makeConstraints { make in
            make.leading.centerY.equalTo(priceView)
        }
        
        salePriceLabel.snp.makeConstraints { make in
            make.leading.equalTo(priceLabel.snp.trailing).offset(8)
            make.bottom.equalTo(priceLabel)
        }
        
        badgeView.snp.makeConstraints { make in
            make.height.equalTo(34)
        }
        
        badgeStackView.snp.makeConstraints { make in
            make.top.equalTo(badgeView).offset(10)
            make.bottom.leading.equalTo(badgeView)
        }
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
