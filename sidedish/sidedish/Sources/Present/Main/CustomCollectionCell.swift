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
        imageView.layer.shadowOffset = CGSize(width: 2, height: 2)
        imageView.layer.shadowOpacity = 0.1
        imageView.layer.shadowRadius = 3
        imageView.layer.shadowColor = UIColor.black.cgColor
        return imageView
    }()
    
    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 8
        stackView.alignment = .leading
        stackView.distribution = .equalSpacing
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .bold)
        label.textColor = .black
        return label
    }()
    
    private let contentLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .regular)
        label.textColor = .grey2
        label.numberOfLines = 3
        return label
    }()
    
    private let priceLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .bold)
        label.textColor = .black
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        bind()
        attritbute()
        layout()
    }

    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func bind() {
        contentView.addSubview(imageView)
        contentView.addSubview(stackView)
        
        stackView.addArrangedSubview(titleLabel)
        stackView.addArrangedSubview(contentLabel)
        stackView.addArrangedSubview(priceLabel)
    }
    
    private func attritbute() {

    }
    
    private func layout() {
        NSLayoutConstraint.activate([
            imageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            imageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            imageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor),
            imageView.widthAnchor.constraint(equalToConstant: imageSize),
            imageView.heightAnchor.constraint(equalToConstant: imageSize),
            
            stackView.centerYAnchor.constraint(equalTo: imageView.centerYAnchor),
            stackView.leadingAnchor.constraint(equalTo: imageView.trailingAnchor, constant: 8),
            stackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor)
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
    
    func changeContentLabel(text: String) {
        contentLabel.text = text
    }
    
    func changePriceLabel(text: String) {
        priceLabel.text = text
    }
}
