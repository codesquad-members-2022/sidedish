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
        imageView.backgroundColor = .grey2
        return imageView
    }()
    
    private let stackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 8
        stackView.alignment = .leading
        stackView.distribution = .equalSpacing
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.backgroundColor = .grey3
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
        label.textColor = .black
        label.numberOfLines = 3
        return label
    }()
    
    private let priceLabel: UILabel = {
        let label = UILabel()
        label.font = .systemFont(ofSize: 14, weight: .bold)
        label.textColor = .lightGray
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
        contentView.backgroundColor = .grey3
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
