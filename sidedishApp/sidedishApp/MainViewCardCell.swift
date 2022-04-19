//
//  MainViewCardCell.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation
import UIKit

class MainViewCardCell: UICollectionViewCell {
    
    static let identifier = "MainViewCardCell"
    
    private lazy var cardImageView: UIImageView = {
        var image = UIImageView()
        image.backgroundColor = .systemGray5
        return image
    }()
    
    private lazy var cardTitleLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 20)
        label.text = "오리 주물럭_반조리"
        return label
    }()
    
    private lazy var cardBodyLabel: UILabel = {
        var label = UILabel()
        label.text = "감칠맛 나는 매콤한 양념"
        return label
    }()
    
    private lazy var priceLabel: UILabel = {
        var label = UILabel()
        label.font = .boldSystemFont(ofSize: 18)
        label.text = "15,800원"
        return label
    }()
    
    private lazy var eventTagLabel: UILabel = {
        var label = UILabel()
        label.text = "이벤트특가"
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
    }
    
//    private func setView() {
//        self.contentView
//    }
    
    private func setUI() {
        self.addSubview(cardImageView)
        self.addSubview(cardTitleLabel)
        self.addSubview(cardBodyLabel)
        self.addSubview(priceLabel)
        self.addSubview(eventTagLabel)
        setUIConstraints()
    }
    
    private func setUIConstraints() {
        setCardImageViewConstraint()
        setCardTitleLabelConstraint()
        setCardBodyLabelConstraint()
        setPriceLabelConstraint()
        setEventTagLabelConstraint()
    }
    
    private func setCardImageViewConstraint() {
        cardImageView.translatesAutoresizingMaskIntoConstraints = false
        cardImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10).isActive = true
        cardImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 10).isActive = true
        cardImageView.widthAnchor.constraint(equalToConstant: 120).isActive = true
        cardImageView.heightAnchor.constraint(equalToConstant: 120).isActive = true
    }
    
    private func setCardTitleLabelConstraint() {
        cardTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        cardTitleLabel.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10).isActive = true
        cardTitleLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setCardBodyLabelConstraint() {
        cardBodyLabel.translatesAutoresizingMaskIntoConstraints = false
        cardBodyLabel.topAnchor.constraint(equalTo: cardTitleLabel.bottomAnchor, constant: 5).isActive = true
        cardBodyLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setPriceLabelConstraint() {
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.topAnchor.constraint(equalTo: cardBodyLabel.bottomAnchor, constant: 5).isActive = true
        priceLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
    private func setEventTagLabelConstraint() {
        eventTagLabel.translatesAutoresizingMaskIntoConstraints = false
        eventTagLabel.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 5).isActive = true
        eventTagLabel.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor, constant: 5).isActive = true
    }
    
}
