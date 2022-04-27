import Foundation
import UIKit

final class FoodCollectionViewCell: UICollectionViewCell{

    private lazy var foodImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private lazy var foodInformationStackView: UIStackView = {
        let informationStackView = UIStackView()
        informationStackView.axis = .vertical
        informationStackView.alignment = .leading
        informationStackView.distribution = .fillEqually
        informationStackView.translatesAutoresizingMaskIntoConstraints = false
        return informationStackView
    }()
    
    private lazy var foodPriceStackView: UIStackView = {
        let priceStackView = UIStackView()
        priceStackView.axis = .horizontal
        priceStackView.alignment = .leading
        priceStackView.distribution = .fillEqually
        priceStackView.translatesAutoresizingMaskIntoConstraints = false
        return priceStackView
    }()
    
    private lazy var foodBadgeStackView: UIStackView = {
        let badgeStackView = UIStackView()
        badgeStackView.axis = .horizontal
        badgeStackView.alignment = .leading
        badgeStackView.spacing = 5
        badgeStackView.distribution = .fillEqually
        badgeStackView.translatesAutoresizingMaskIntoConstraints = false
        return badgeStackView
    }()
    
    private lazy var foodNameLabel: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDescriptionLabel: UILabel = {
        let label = UILabel()
        label.text = "푸드 설명 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodNormalPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "푸드 정가 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        if let text = label.text {
            let attributeString = NSMutableAttributedString(string: label.text ?? "해당없음")
            attributeString.addAttributes([NSAttributedString.Key.strikethroughStyle: NSUnderlineStyle.single.rawValue], range: NSMakeRange(0, attributeString.length))
            label.attributedText = attributeString
        }
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodSpecialPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "푸드 특가 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var badgeLaunchingLabel: UILabel = {
        let label = UILabel()
        label.layer.masksToBounds = true
        label.layer.cornerRadius = 8.0
        label.backgroundColor = UIColor(red: 0/255, green: 122/255, blue: 255/255, alpha: 1)
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 13)
        label.textAlignment = .center
        return label
    }()
    
    private lazy var badgeMainLabel: UILabel = {
        let label = UILabel()
        label.layer.masksToBounds = true
        label.layer.cornerRadius = 8.0
        label.backgroundColor = UIColor(red: 0/255, green: 102/255, blue: 214/255, alpha: 1)
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 13)
        label.textAlignment = .center
        return label
    }()
    
    private lazy var badgeEventLabel: UILabel = {
        let label = UILabel()
        label.layer.masksToBounds = true
        label.layer.cornerRadius = 8.0
        label.backgroundColor = UIColor(red: 0/255, green: 122/255, blue: 255/255, alpha: 1)
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 13)
        label.textAlignment = .center
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        addViews()
        setLayout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    private func addViews(){
        contentView.addSubview(foodImageView)
        contentView.addSubview(foodInformationStackView)
        contentView.addSubview(foodPriceStackView)
        contentView.addSubview(foodBadgeStackView)
        foodInformationStackView.addArrangedSubview(foodNameLabel)
        foodInformationStackView.addArrangedSubview(foodDescriptionLabel)
        foodPriceStackView.addArrangedSubview(foodSpecialPriceLabel)
        foodPriceStackView.addArrangedSubview(foodNormalPriceLabel)
        foodBadgeStackView.addArrangedSubview(badgeEventLabel)
        foodBadgeStackView.addArrangedSubview(badgeMainLabel)
        foodBadgeStackView.addArrangedSubview(badgeLaunchingLabel)
    }
    
    private func setLayout(){
        NSLayoutConstraint.activate([
            foodImageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            foodImageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            foodImageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor),
            foodImageView.widthAnchor.constraint(equalTo: contentView.widthAnchor, multiplier: 0.45),
            
            foodInformationStackView.leadingAnchor.constraint(equalTo: foodImageView.trailingAnchor, constant: 10),
            foodInformationStackView.topAnchor.constraint(equalTo: contentView.topAnchor),
            foodInformationStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            foodInformationStackView.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 0.6),
            
            foodPriceStackView.leadingAnchor.constraint(equalTo: foodImageView.trailingAnchor, constant: 10),
            foodPriceStackView.topAnchor.constraint(equalTo: foodInformationStackView.bottomAnchor, constant: 5),
            foodPriceStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            foodPriceStackView.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 0.2),
            
            foodBadgeStackView.leadingAnchor.constraint(equalTo: foodImageView.trailingAnchor, constant: 10),
            foodBadgeStackView.topAnchor.constraint(equalTo: foodPriceStackView.bottomAnchor, constant: 5),
            foodBadgeStackView.widthAnchor.constraint(equalTo: contentView.widthAnchor, multiplier: 0.5),
            foodBadgeStackView.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 0.3),
        ])
    }
    
    func receiveFood(food: Food){
        foodNameLabel.text = food.title
        foodDescriptionLabel.text = food.foodDescription
        foodNormalPriceLabel.text = food.normalPrice
        foodSpecialPriceLabel.text = food.specialPrice
        
        if foodNormalPriceLabel.text == "0원"{
            foodNormalPriceLabel.text = ""
        }
        
        for badge in food.badges{
            if badge.contains("런칭"){
                badgeLaunchingLabel.text = badge
            } else if badge.contains("메인") {
                badgeMainLabel.text = badge
            } else if badge.contains("이벤트") {
                badgeEventLabel.text = badge
            }
        }
    }
    
    func updateFoodImage(imageData: Data){
        foodImageView.image = UIImage(data: imageData)
    }
}



