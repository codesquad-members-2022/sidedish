//
//  MainViewCardInfo.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/26.
//

import UIKit

class MainViewCardInfo: UIStackView {

    let cardInfoVerticalStackView: MainCardInfoStackView = {
        var stackView = MainCardInfoStackView()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .equalCentering
        return stackView
    }()

    let badgeHorizontalStackView: BadgeStackView = {
        var stackView = BadgeStackView()
        stackView.axis = .horizontal
        stackView.alignment = .leading
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
        setUIConstraints()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
        setUIConstraints()
    }
    
    func setPropertiesValue(dish: MainCard.Body) {
        cardInfoVerticalStackView.setPropertiesValue(dish: dish)
        badgeHorizontalStackView.setPropertiesValue(dish)
    }


    private func setUI() {
        self.addArrangedSubview(cardInfoVerticalStackView)
        self.addArrangedSubview(badgeHorizontalStackView)
    }
    
    private func setUIConstraints() {
        configureCardInfoVerticalStackViewConstraint()
        configureBadgeStackViewConstraint()
    }
    
    private func configureCardInfoVerticalStackViewConstraint() {
        cardInfoVerticalStackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardInfoVerticalStackView.widthAnchor.constraint(equalTo: self.widthAnchor),
            cardInfoVerticalStackView.heightAnchor.constraint(equalToConstant: 80),
            cardInfoVerticalStackView.topAnchor.constraint(equalTo: self.topAnchor),
            cardInfoVerticalStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            cardInfoVerticalStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
    
    private func configureBadgeStackViewConstraint() {
        badgeHorizontalStackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            badgeHorizontalStackView.widthAnchor.constraint(equalTo: self.widthAnchor),
            badgeHorizontalStackView.topAnchor.constraint(equalTo: cardInfoVerticalStackView.bottomAnchor, constant: 20),
            badgeHorizontalStackView.bottomAnchor.constraint(equalTo: self.bottomAnchor),
            badgeHorizontalStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor),
            badgeHorizontalStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor)
        ])
    }
}

