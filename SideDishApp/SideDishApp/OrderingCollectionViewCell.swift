//
//  OrderingCollectionViewCell.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingCollectionViewCell: UICollectionViewCell {
    
    private let identifier = Constant.Identifier.orderingViewCell
    
    private let cellView: UIView = {
        let label = UIView()
        label.backgroundColor = .green
        return label
    }()
    
    private let dishImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "mockImage.png")
        imageView.contentMode = .scaleToFill
        imageView.frame.size = CGSize(width: 130, height: 130)
        imageView.layer.cornerRadius = 5
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private let menuStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 8
        stackView.alignment = .leading
        stackView.backgroundColor = .cyan
        return stackView
    }()
    
    private let menuInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.backgroundColor = .orange
        stackView.distribution = .fillEqually
        return stackView
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "보노보노 주물럭 요리"
        label.textColor = .black
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.text = "감질맛 나는 매콤한 보노보노"
        label.textColor = .systemGray5
        return label
    }()
    
    private let priceStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private let discountedPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "15,800원"
        label.textColor = .systemGray5
        return label
    }()
    
    private let originPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "12,640원"
        label.textColor = .black
        return label
    }()
    
    private let badgeLabel: UILabel = {
        let label = UILabel()
        label.text = "런칭특가"
        label.textAlignment = .center
        label.textColor = .white
        label.backgroundColor = .systemBlue
        label.layer.cornerRadius = 11
        label.layer.masksToBounds = true
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    private func setUpView() {
        configureView()
        
        contentView.addSubview(cellView)
        
        cellView.addSubview(dishImageView)
        cellView.addSubview(menuStackView)
        
        menuStackView.addArrangedSubview(menuInfoStackView)
        menuInfoStackView.addArrangedSubview(titleLabel)
        menuInfoStackView.addArrangedSubview(descriptionLabel)
        menuInfoStackView.addArrangedSubview(priceStackView)
        priceStackView.addArrangedSubview(discountedPriceLabel)
        priceStackView.addArrangedSubview(originPriceLabel)
        
        menuStackView.addArrangedSubview(badgeLabel)
        
        layoutCellView()
        layoutMenuStackView()
        layoutMenuInfoStackView()
        layoutBadgeLabel()
    }
    
    private func configureView() {
        contentView.backgroundColor = .red
    }
    
    private func layoutCellView() {
        cellView.translatesAutoresizingMaskIntoConstraints = false
        cellView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        cellView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        cellView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16).isActive = true
        cellView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16).isActive = true
    }
    
    private func layoutMenuStackView() {
        menuStackView.translatesAutoresizingMaskIntoConstraints = false
        menuStackView.centerYAnchor.constraint(equalTo: cellView.centerYAnchor).isActive = true
        menuStackView.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor, constant: 8).isActive = true
        menuStackView.trailingAnchor.constraint(equalTo: cellView.trailingAnchor).isActive = true
    }
    
    private func layoutMenuInfoStackView() {
        menuInfoStackView.translatesAutoresizingMaskIntoConstraints = false
        menuInfoStackView.heightAnchor.constraint(greaterThanOrEqualToConstant: 72).isActive = true
    }
    
    private func layoutBadgeLabel() {
        badgeLabel.translatesAutoresizingMaskIntoConstraints = false
        badgeLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
        badgeLabel.widthAnchor.constraint(equalToConstant: 77).isActive = true
    }
}
