//
//  DishCollectionViewCell.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import UIKit

final class DishCollectionViewCell: UICollectionViewCell{
    
    override func prepareForReuse() {
        super.prepareForReuse()
        eventConstraints.map{$0.isActive = false}
        nonEventConstraints.map{$0.isActive = false}
        eventButton.removeFromSuperview()
        eventButton.translatesAutoresizingMaskIntoConstraints = true
    }
    
    private lazy var basicView = UIView()
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
    
    private lazy var eventConstraints: [NSLayoutConstraint] = []
    private lazy var nonEventConstraints: [NSLayoutConstraint] = []
    
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupUI()
    }
    
    private func setupUI(){
        contentView.addSubview(basicView)
        basicView.addSubview(dishImageView)
        basicView.addSubview(dishTitleLabel)
        basicView.addSubview(descriptionTitleLabel)
        basicView.addSubview(priceLabel)
        
        setDefaultUIConstraint()
    }
    
    private func setDefaultUIConstraint(){
        basicView.translatesAutoresizingMaskIntoConstraints = false
        basicView.widthAnchor.constraint(equalTo: contentView.widthAnchor).isActive = true
        basicView.heightAnchor.constraint(equalTo: contentView.heightAnchor).isActive = true
        basicView.centerXAnchor.constraint(equalTo: contentView.centerXAnchor).isActive = true
        
        dishImageView.translatesAutoresizingMaskIntoConstraints = false
        dishImageView.topAnchor.constraint(equalTo: topAnchor).isActive = true
        dishImageView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 10).isActive = true
        dishImageView.widthAnchor.constraint(equalToConstant: 125).isActive = true
        dishImageView.heightAnchor.constraint(equalToConstant: 125).isActive = true
        
        descriptionTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        dishTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        priceLabel.translatesAutoresizingMaskIntoConstraints = false
    }
    
    func setEventUIConstraint(){
        basicView.addSubview(eventButton)
        eventButton.translatesAutoresizingMaskIntoConstraints = false
        eventConstraints = [descriptionTitleLabel.bottomAnchor.constraint(equalTo: dishImageView.centerYAnchor, constant: -10),
                            descriptionTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                            descriptionTitleLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor,constant: -10),
                            dishTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                            dishTitleLabel.bottomAnchor.constraint(equalTo: descriptionTitleLabel.topAnchor, constant: -5),
                            dishTitleLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor),
                            priceLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                            priceLabel.topAnchor.constraint(equalTo: descriptionTitleLabel.bottomAnchor, constant: 5),
                            priceLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor),
                            eventButton.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                            eventButton.topAnchor.constraint(equalTo: priceLabel.bottomAnchor, constant: 10),
                            eventButton.widthAnchor.constraint(equalToConstant: 80)]
        eventConstraints.map{$0.isActive = true}
    }
    
    func setNonEventUIConstraint(){
        nonEventConstraints = [ descriptionTitleLabel.centerYAnchor.constraint(equalTo: dishImageView.centerYAnchor),
                                descriptionTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                                descriptionTitleLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor,constant: -10),
                                dishTitleLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                                dishTitleLabel.bottomAnchor.constraint(equalTo: descriptionTitleLabel.topAnchor, constant: -5),
                                dishTitleLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor),
                                priceLabel.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor,constant: 10),
                                priceLabel.topAnchor.constraint(equalTo: descriptionTitleLabel.bottomAnchor, constant: 5),
                                priceLabel.trailingAnchor.constraint(equalTo: basicView.trailingAnchor)]
        nonEventConstraints.map{$0.isActive = true}
        eventButton.removeFromSuperview()
    }
    
    func updateUIProperty(with product: Product){
        dishTitleLabel.text = product.name
        descriptionTitleLabel.text = product.description
    }
    
    func updateImage(data: Data){
        dishImageView.image = UIImage(data: data)
    }
}
extension UICollectionViewCell{
    static var identifier = String(describing: self)
}
