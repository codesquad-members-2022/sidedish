//
//  DishCollectionViewCell.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import Foundation
import UIKit

class DishCollectionViewCell: UICollectionViewCell{
    static let identifier = "DishCollectionViewCell"
    
    override func prepareForReuse() {
        super.prepareForReuse()
        print("disappear from view")
    }
    
    private lazy var view = UIView()
    private lazy var dishImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.backgroundColor = .blue
        imageView.layer.cornerRadius = 10
        return imageView
    }()
    
    private lazy var dishTitleLabel: UILabel = {
        let label = UILabel()
        label.text = "dish title"
        label.font = UIFont.boldSystemFont(ofSize: 16)
        return label
    }()
    
    private lazy var descriptionTitleLabel: UILabel = {
        let label = UILabel()
        label.text = "dish descricsdckldsocjwdiption!!dsafadf!"
        label.textColor = .gray
        label.font = UIFont.boldSystemFont(ofSize: 16)
        return label
    }()
    
    private lazy var priceLabel: UILabel = {
        let label = UILabel()
        label.text = "27000원"
        label.font = UIFont.boldSystemFont(ofSize: 16)
        return label
    }()
    
    private lazy var eventButton: UIButton = {
        let button = UIButton()
        button.setTitle("런칭특가", for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 15)
        button.layer.cornerRadius = 15
        button.backgroundColor = .blue
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupUI()
    }
    
    private func setupUI(){
        contentView.addSubview(view)
        view.addSubview(dishImageView)
        view.addSubview(dishTitleLabel)
        view.addSubview(descriptionTitleLabel)
        view.addSubview(priceLabel)
        view.addSubview(eventButton)
        setDefaultUIConstraint()
    }
    
    private func setDefaultUIConstraint(){
        view.translatesAutoresizingMaskIntoConstraints = false
        view.widthAnchor.constraint(equalTo: contentView.widthAnchor).isActive = true
        view.heightAnchor.constraint(equalTo: contentView.heightAnchor).isActive = true
        view.centerXAnchor.constraint(equalTo: contentView.centerXAnchor).isActive = true
        
        dishImageView.translatesAutoresizingMaskIntoConstraints = false
        dishImageView.topAnchor.constraint(equalTo: topAnchor).isActive = true
        dishImageView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 10).isActive = true
        dishImageView.widthAnchor.constraint(equalToConstant: 125).isActive = true
        dishImageView.heightAnchor.constraint(equalToConstant: 125).isActive = true
    }
    
    private func setEventUIConstraint(){
        descriptionTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        descriptionTitleLabel.bottomAnchor.constraint(equalTo: dishImageView.centerYAnchor, constant: -10).isActive = true
        descriptionTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        descriptionTitleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor,constant: -10).isActive = true
        
        dishTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        dishTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        dishTitleLabel.bottomAnchor.constraint(equalTo: descriptionTitleLabel.topAnchor, constant: -5).isActive = true
        dishTitleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        priceLabel.topAnchor.constraint(equalTo: descriptionTitleLabel.bottomAnchor, constant: 5).isActive = true
        priceLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        
        eventButton.translatesAutoresizingMaskIntoConstraints = false
        eventButton.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        eventButton.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 10).isActive = true
        eventButton.widthAnchor.constraint(equalToConstant: 80).isActive = true
    }
    
    private func setNonEventUIConstraint(){
        descriptionTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        descriptionTitleLabel.centerYAnchor.constraint(equalTo: dishImageView.centerYAnchor).isActive = true
        descriptionTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        descriptionTitleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor,constant: -10).isActive = true
        
        dishTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        dishTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        dishTitleLabel.bottomAnchor.constraint(equalTo: descriptionTitleLabel.topAnchor, constant: -5).isActive = true
        dishTitleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10).isActive = true
        priceLabel.topAnchor.constraint(equalTo: descriptionTitleLabel.bottomAnchor, constant: 5).isActive = true
        priceLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
    }
    
    func setProperties(product: Product){
        dishTitleLabel.text = product.name
        descriptionTitleLabel.text = product.description
        priceLabel.text = "\(product.price)"
        print("setting")
        if product.event.contains(.none) {
           setNonEventUIConstraint()
        }else{
           setEventUIConstraint()
        }
        
    }
    
}
