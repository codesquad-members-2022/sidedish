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
    
    private let cardImageView: UIImageView = {
        var image = UIImageView()
        image.backgroundColor = .systemGray5
        image.layer.cornerRadius = 5
        return image
    }()
    
    private let cardInfoVerticalStackView: MainViewCardInfo = {
        var stackView = MainViewCardInfo()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .fillProportionally
        stackView.spacing = 5
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
    }
    
    func setPropertiesValue(imageData: Data, dish: MainCard.Body) {
        DispatchQueue.main.async {
            self.cardImageView.image = UIImage(data: imageData)
            
        }
        self.cardInfoVerticalStackView.setPropertiesValue(dish: dish)
    }
    
    private func setUI() {
        self.addSubview(cardImageView)
        self.addSubview(cardInfoVerticalStackView)
        setUIConstraints()
    }
    
    private func setUIConstraints() {
        congifureCardImageViewConstraint()
        configureCardInfoVerticalStackViewConstraint()
        
    }
    
    private func congifureCardImageViewConstraint() {
        cardImageView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 10),
            cardImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 10),
            cardImageView.widthAnchor.constraint(equalToConstant: 120),
            cardImageView.heightAnchor.constraint(equalToConstant: 120)
        ])
    }
    
    private func configureCardInfoVerticalStackViewConstraint() {
        cardInfoVerticalStackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            cardInfoVerticalStackView.topAnchor.constraint(equalTo: self.contentView.topAnchor),
            cardInfoVerticalStackView.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor),
            cardInfoVerticalStackView.leadingAnchor.constraint(equalTo: cardImageView.trailingAnchor),
            cardInfoVerticalStackView.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor)
        ])
    }
    
}
