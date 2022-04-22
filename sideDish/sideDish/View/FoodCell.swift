//
//  FoodCell.swift
//  sideDish
//
//  Created by 이건행 on 2022/04/19.
//

import Foundation
import UIKit

class FoodCell: UICollectionViewCell {
    private(set) var storageLabel = [UILabel]()
    
    private var titleLabel: UILabel = {
        var label = UILabel()
        label.text = "오리 주물럭_반조리"
        label.font = UIFont.boldSystemFont(ofSize: 14)
        return label
    }()
    
    private var bodyLabel: UILabel = {
        var label = UILabel()
        label.text = "감질맛 나는 매콤한 양념"
        label.font = UIFont.systemFont(ofSize: 14)
        label.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        return label
    }()
    
    private var originPriceLabel: UILabel = {
        var label = UILabel()
        label.text = "12,640원"
        label.font = UIFont.boldSystemFont(ofSize: 14)
        return label
    }()
    
    private var salePriceLabel: UILabel = {
        var label = UILabel()
        label.text = "15,800원"
        label.font = UIFont.systemFont(ofSize: 14)
        label.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        return label
    }()
    
    private var eventLabel: UILabel = {
        var label = UILabel()
        label.clipsToBounds = true
        label.backgroundColor = UIColor(red: 0.502, green: 0.737, blue: 1, alpha: 1)
        label.textColor = .white
        label.layer.cornerRadius = 100
        label.text = "이벤트특가"
        return label
    }()
    
    // MARK: Initiallize
    override init(frame: CGRect) {
        super.init(frame: frame)
        configureLayout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    // MARK: Image Attribute
    private let myImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "tempFood")
        imageView.contentMode = .scaleAspectFit
        
        return imageView
    }()
    
    // MARK: Label configure
    
    func configureLayout(){
        self.contentView.addSubview(myImageView)
        myImageView.translatesAutoresizingMaskIntoConstraints = false
        myImageView.widthAnchor.constraint(equalToConstant: 130).isActive = true
        myImageView.heightAnchor.constraint(equalToConstant: 130).isActive = true
        myImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor).isActive = true
        myImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor).isActive = true
        myImageView.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor).isActive = true
        
        self.contentView.addSubview(titleLabel)
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 13).isActive = true
        titleLabel.leadingAnchor.constraint(equalTo: myImageView.trailingAnchor, constant: 8).isActive = true
        titleLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        self.contentView.addSubview(bodyLabel)
        bodyLabel.translatesAutoresizingMaskIntoConstraints = false
        bodyLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor).isActive = true
        bodyLabel.leadingAnchor.constraint(equalTo: titleLabel.leadingAnchor).isActive = true
        bodyLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        self.contentView.addSubview(originPriceLabel)
        originPriceLabel.translatesAutoresizingMaskIntoConstraints = false
        originPriceLabel.topAnchor.constraint(equalTo: bodyLabel.bottomAnchor).isActive = true
        originPriceLabel.leadingAnchor.constraint(equalTo: bodyLabel.leadingAnchor).isActive = true
        originPriceLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        self.contentView.addSubview(salePriceLabel)
        salePriceLabel.translatesAutoresizingMaskIntoConstraints = false
        salePriceLabel.topAnchor.constraint(equalTo: originPriceLabel.topAnchor).isActive = true
        salePriceLabel.leadingAnchor.constraint(equalTo: originPriceLabel.trailingAnchor).isActive = true
        salePriceLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
        
        eventLabel.translatesAutoresizingMaskIntoConstraints = false
        eventLabel.topAnchor.constraint(equalTo: salePriceLabel.bottomAnchor, constant: 8).isActive = true
        eventLabel.leadingAnchor.constraint(equalTo: originPriceLabel.leadingAnchor).isActive = true
        eventLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
        eventLabel.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: 13).isActive = true
    }
    
}
