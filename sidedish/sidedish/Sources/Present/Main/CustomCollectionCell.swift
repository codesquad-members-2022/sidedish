//
//  CustomCollectionCell.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/19.
//

import UIKit

class CustomCollectionCell: UICollectionViewCell {
    static let identifier = "CustomCollectionCell"
    private let imageSize = 130.0
    
    private let imageView: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        imageView.layer.cornerRadius = 8
        imageView.layer.shadowOffset = CGSize(width: 2, height: 2)
        imageView.layer.shadowOpacity = 0.1
        imageView.layer.shadowRadius = 3
        imageView.layer.shadowColor = UIColor.black.cgColor
        return imageView
    }()
    
    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 4
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .bold)
        label.textColor = .black
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .regular)
        label.textColor = .grey2
        label.numberOfLines = 3
        return label
    }()
    
    private let priceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 14, weight: .bold)
        label.textAlignment = .left
        label.textColor = .black
        return label
    }()
    
    private let salePriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 14)
        label.textAlignment = .left
        label.textColor = .grey2
        return label
    }()
    
    private let badgeView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()

    private let badgeButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.backgroundColor = .primary1
        button.setTitle("런칭특가", for: .normal)
        button.titleLabel?.font = .systemFont(ofSize: 12, weight: .bold)
        button.layer.cornerRadius = 12
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    
        layout()
    }

    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }

    private func layout() {
        contentView.addSubview(imageView)
        contentView.addSubview(stackView)
        
        stackView.addArrangedSubview(titleLabel)
        stackView.addArrangedSubview(descriptionLabel)
        stackView.addArrangedSubview(priceLabel)
        stackView.addArrangedSubview(salePriceLabel)
        stackView.addArrangedSubview(badgeView)
        
        badgeView.addSubview(badgeButton)
        
        NSLayoutConstraint.activate([
            imageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            imageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            imageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor),
            imageView.widthAnchor.constraint(equalToConstant: imageSize),
            imageView.heightAnchor.constraint(equalToConstant: imageSize),
            
            stackView.centerYAnchor.constraint(equalTo: imageView.centerYAnchor),
            stackView.bottomAnchor.constraint(equalTo: badgeView.bottomAnchor),
            stackView.leadingAnchor.constraint(equalTo: imageView.trailingAnchor, constant: 16),
            stackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            
            badgeView.heightAnchor.constraint(equalTo: badgeButton.heightAnchor),
            
            badgeButton.widthAnchor.constraint(equalToConstant: 77),
            badgeButton.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
}

extension CustomCollectionCell {
    func changeImage(name: String) {
        imageView.image = UIImage(named: "\(name)")
    }
    
    func changeTitleLabel(text: String) {
        titleLabel.text = text
    }
    
    func changeDescriptionLabel(text: String) {
        descriptionLabel.text = text
    }
    
    func changePriceLabel(text: String) {
        priceLabel.text = text
    }
}
