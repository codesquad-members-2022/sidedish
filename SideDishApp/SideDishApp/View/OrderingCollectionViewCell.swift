//
//  OrderingCollectionViewCell.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

final class OrderingCollectionViewCell: UICollectionViewCell {
    
    private let identifier = Constant.Identifier.orderingViewCell
 
    private lazy var cellView = UIView()
    
    private lazy var dishImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleToFill
        imageView.frame.size = CGSize(width: 130, height: 130)
        imageView.layer.cornerRadius = 5
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private(set) lazy var menuStackView = MenuStackView()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        prepareForReuse(stackView: menuStackView.priceStackView)
        prepareForReuse(stackView: menuStackView.badgeStackView)
    }
    
    private func prepareForReuse(stackView: UIStackView) {
        stackView.subviews.forEach {
            $0.removeFromSuperview()
        }
    }
    
    private func setUpView() {
        contentView.addSubview(cellView)
        cellView.addSubview(dishImageView)
        cellView.addSubview(menuStackView)
        
        layoutCellView()
        layoutMenuStackView()
    }
}

// MARK: - View Layout

extension OrderingCollectionViewCell {
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
}

// MARK: - Providing Function

extension OrderingCollectionViewCell {
    func setMenu(image: UIImage) {
        self.dishImageView.image = image
    }
}
