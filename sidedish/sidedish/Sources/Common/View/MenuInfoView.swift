//
//  MenuInfoView.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/21.
//

import SnapKit
import UIKit

class MenuInfoAttribute {
    var lineSpacing: CGFloat = 0
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
    private let titleLabel = UILabel()
    private let descriptionLabel = UILabel()

    private let priceLabel = UILabel()
    
    private let salePriceLabel = UILabel()
    
    private let badgeView = UIView()
    
    private let attribute: MenuInfoAttribute
    
    init(attribute: MenuInfoAttribute) {
        self.attribute = attribute
        
        super.init(frame: .zero)
        self.titleLabel.font = attribute.titleFont
        self.titleLabel.textColor = attribute.titleTextColor
        self.priceLabel.font = attribute.priceFont
        self.priceLabel.textColor = attribute.priceTextColor
        self.salePriceLabel.font = attribute.salePriceFont
        self.salePriceLabel.textColor = attribute.salePriceTextColor
        layout()
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func layout() {
        let subViews = [titleLabel, descriptionLabel, priceLabel, salePriceLabel, badgeView]
        subViews.forEach {
            addSubview($0)
        }
        
        titleLabel.snp.makeConstraints {
            $0.top.leading.trailing.equalToSuperview()
        }
        
        descriptionLabel.snp.makeConstraints {
            $0.top.equalTo(titleLabel.snp.bottom).offset(attribute.lineSpacing)
            $0.leading.trailing.equalToSuperview()
        }
        
        priceLabel.snp.makeConstraints {
            $0.top.equalTo(descriptionLabel.snp.bottom).offset(attribute.lineSpacing)
            $0.leading.equalToSuperview()
        }
        
        salePriceLabel.snp.makeConstraints {
            $0.leading.equalTo(priceLabel.snp.trailing).offset(4)
            $0.bottom.equalTo(priceLabel)
        }
        
        badgeView.snp.makeConstraints {
            $0.top.equalTo(priceLabel.snp.bottom).offset(8)
            $0.leading.trailing.equalToSuperview()
            $0.height.equalTo(1)
        }
        
        snp.makeConstraints {
            $0.bottom.equalTo(subViews[subViews.count - 1])
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
        updateBadgeAutoLayout(targetView: priceLabel)
        badgeView.subviews.forEach { $0.removeFromSuperview() }

        guard let badges = badges else {
            return
        }
        
        let badgeLabels = badges.map { badge -> PaddingLabel in
            let label = makeBadge()
            label.text = badge
            switch badge {
            case "이벤트특가":
                label.backgroundColor = .primary3
            case "런칭특가":
                label.backgroundColor = .primary1
            default:
                label.backgroundColor = .primary2
            }
            badgeView.addSubview(label)
            
            label.snp.makeConstraints {
                $0.leading.top.equalToSuperview()
            }
            return label
        }
        
        layoutIfNeeded()
        
        let maxWidth = badgeView.frame.size.width
        
        var sortLabel = [Int: [PaddingLabel]]()
        var sortKey = 0
        var currentWidth = 0.0
        badgeLabels.forEach { label in
            currentWidth += label.frame.width
            if currentWidth >= maxWidth {
                sortKey += 1
                currentWidth = label.frame.width
            }
            
            if sortLabel.keys.contains(sortKey) == false {
                sortLabel[sortKey] = []
            }
            sortLabel[sortKey]?.append(label)
        }
                
        let keys = sortLabel.keys.sorted()
        var topAnchor = badgeView.snp.top
        var leadingAnchor = badgeView.snp.leading
        keys.enumerated().forEach { keyIndex, key in
            guard let array = sortLabel[key] else {
                return
            }
            array.enumerated().forEach { index, label in
                label.snp.removeConstraints()
                label.snp.makeConstraints {
                    $0.leading.equalTo(leadingAnchor).offset(index == 0 ? 0 : 4)
                    $0.top.equalTo(topAnchor).offset(keyIndex == 0 ? 0 : 4)
                }
                leadingAnchor = label.snp.trailing
            }
            
            topAnchor = array[0].snp.bottom
            leadingAnchor = badgeView.snp.leading
        }
        
        updateBadgeAutoLayout(targetView: badgeLabels[badgeLabels.count - 1])
    }
    
    private func updateBadgeAutoLayout(targetView: UIView) {
        badgeView.snp.remakeConstraints {
            $0.top.equalTo(priceLabel.snp.bottom).offset(8)
            $0.leading.trailing.equalToSuperview()
            if targetView == priceLabel {
                $0.height.equalTo(1)
            } else {
                $0.bottom.equalTo(targetView)
            }
        }
    }
    
    private func makeBadge() -> PaddingLabel {
        let paddingLabel = PaddingLabel(frame: .zero)
        paddingLabel.padding = UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16)
        paddingLabel.font = .systemFont(ofSize: 12, weight: .bold)
        paddingLabel.textColor = .white
        paddingLabel.clipsToBounds = true
        paddingLabel.layer.cornerRadius = 12
        return paddingLabel
    }
}
