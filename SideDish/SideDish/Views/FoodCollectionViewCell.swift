import Foundation
import UIKit

final class FoodCollectionViewCell: UICollectionViewCell{
    //
    private lazy var foodImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.backgroundColor = .orange
        imageView.translatesAutoresizingMaskIntoConstraints = false
        return imageView
    }()
    
    private lazy var foodInformationStackView: UIStackView = {
        let informationStackView = UIStackView()
        informationStackView.axis = .vertical
        informationStackView.alignment = .leading
        informationStackView.spacing = 5
        informationStackView.distribution = .fillEqually
        informationStackView.translatesAutoresizingMaskIntoConstraints = false
        return informationStackView
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
    
    func addViews(){
        contentView.addSubview(foodImageView)
        contentView.addSubview(foodInformationStackView)
        foodInformationStackView.addArrangedSubview(foodNameLabel)
        foodInformationStackView.addArrangedSubview(foodDescriptionLabel)
        foodInformationStackView.addArrangedSubview(foodNormalPriceLabel)
        foodInformationStackView.addArrangedSubview(foodSpecialPriceLabel)

    }
    
    func setLayout(){
        NSLayoutConstraint.activate([
            foodImageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            foodImageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            foodImageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor),
            foodImageView.widthAnchor.constraint(equalTo: contentView.widthAnchor, multiplier: 0.45),
            
            foodInformationStackView.leadingAnchor.constraint(equalTo: foodImageView.trailingAnchor, constant: 10),
            foodInformationStackView.topAnchor.constraint(equalTo: contentView.topAnchor),
            foodInformationStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            foodInformationStackView.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 0.7)
        ])
    }
    
    func receiveFood(food: Food){
        foodNameLabel.text = food.alt
        foodDescriptionLabel.text = food.foodDescription
        foodNormalPriceLabel.text = food.normalPrice
        foodSpecialPriceLabel.text = food.specialPrice
    }
}
