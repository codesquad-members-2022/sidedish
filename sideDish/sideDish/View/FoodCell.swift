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
        label.lineBreakMode = .byTruncatingTail
        label.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        return label
    }()
    
    private var salePriceLabel: UILabel = {
        var label = UILabel()
        label.text = "12,640원"
        label.font = UIFont.boldSystemFont(ofSize: 14)
        return label
    }()
    
    private var beforeSalePriceLabel: UILabel = {
        var label = UILabel()
        label.text = "15,800원"
        
        if let text = label.text {
            let attributeString = NSMutableAttributedString(string: label.text ?? "")

          attributeString.addAttribute(.strikethroughStyle,
                                        value: NSUnderlineStyle.single.rawValue,
                                        range: NSRange(location: 0, length: attributeString.length))

            label.attributedText = attributeString
        }
        
        label.font = UIFont.systemFont(ofSize: 14)
        label.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        return label
    }()
    
    private var eventBadgeLable: UILabel?
    private var launcingBadgeLabel: UILabel?
    
    private var stackView: UIStackView = {
        var stack = UIStackView()
        stack.axis = .horizontal
        stack.spacing = 10
        stack.distribution = .fillProportionally
        return stack
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
    
    func setDomainFood(data: Food){
        titleLabel.text = data.title
        bodyLabel.text = data.description
        salePriceLabel.text = data.salePrice
        beforeSalePriceLabel.text = data.beforeSalePrice
        guard let badge = data.badge else { return }
        setBadgeLabel(badge)
        myImageView.load(url: data.image)
        
    }
    
    func setBadgeLabel(_ badge: [String]){
        for str in badge{
            let label = makeEventLabel(text: str)
            stackView.addArrangedSubview(makeEventLabel(text: str))
        }
    }
    
    // MARK: Label configure
    func makeEventLabel(text: String) -> UILabel{
        let label = UILabel()
        label.adjustsFontSizeToFitWidth = true
        label.clipsToBounds = true
        label.backgroundColor = UIColor(red: 0.502, green: 0.737, blue: 1, alpha: 1)
        label.textColor = .white
        label.layer.cornerRadius = 13
        label.font = UIFont.systemFont(ofSize: 12)
        label.textAlignment = .center
        label.text = text
        return label
    }
    
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
        bodyLabel.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        bodyLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        self.contentView.addSubview(salePriceLabel)
        salePriceLabel.translatesAutoresizingMaskIntoConstraints = false
        salePriceLabel.topAnchor.constraint(equalTo: bodyLabel.bottomAnchor).isActive = true
        salePriceLabel.leadingAnchor.constraint(equalTo: bodyLabel.leadingAnchor).isActive = true
        salePriceLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        self.contentView.addSubview(beforeSalePriceLabel)
        beforeSalePriceLabel.translatesAutoresizingMaskIntoConstraints = false
        beforeSalePriceLabel.topAnchor.constraint(equalTo: salePriceLabel.topAnchor).isActive = true
        beforeSalePriceLabel.leadingAnchor.constraint(equalTo: salePriceLabel.trailingAnchor, constant: 4).isActive = true
        beforeSalePriceLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true
        
        self.contentView.addSubview(stackView)
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor).isActive = true
        stackView.heightAnchor.constraint(equalToConstant: 24).isActive = true
        stackView.topAnchor.constraint(equalTo: salePriceLabel.bottomAnchor, constant: 8).isActive = true
        stackView.leadingAnchor.constraint(equalTo: salePriceLabel.leadingAnchor).isActive = true
        stackView.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: -13).isActive = true
    }
    
}
