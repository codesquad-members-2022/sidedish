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
        informationStackView.translatesAutoresizingMaskIntoConstraints = false
        return informationStackView
    }()
    
    private lazy var foodNameLabel: UILabel = {
        let label = UILabel()
        label.backgroundColor = .gray
        label.text = "푸드 네임 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDescriptionLabel: UILabel = {
        let label = UILabel()
        label.backgroundColor = .red
        label.text = "푸드 설명 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodNormalPriceLabel: UILabel = {
        let label = UILabel()
        label.backgroundColor = .blue
        label.text = "푸드 정가 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodSpecialPriceLabel: UILabel = {
        let label = UILabel()
        label.backgroundColor = .brown
        label.text = "푸드 특가 라벨"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    func addViews(){
        foodInformationStackView.addArrangedSubview(foodNameLabel)
        foodInformationStackView.addArrangedSubview(foodDescriptionLabel)
        foodInformationStackView.addArrangedSubview(foodNormalPriceLabel)
        foodInformationStackView.addArrangedSubview(foodSpecialPriceLabel)
        contentView.addSubview(foodImageView)
        contentView.addSubview(foodInformationStackView)
    }
    
    func setLayout(){
        
        foodImageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor).isActive = true
        foodImageView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        foodImageView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        foodImageView.widthAnchor.constraint(equalTo: contentView.widthAnchor, multiplier: 0.3).isActive = true
        
        foodInformationStackView.leadingAnchor.constraint(equalTo: foodImageView.trailingAnchor, constant: 10).isActive = true
        foodInformationStackView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        foodInformationStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor).isActive = true
        foodInformationStackView.heightAnchor.constraint(equalTo: contentView.heightAnchor, multiplier: 1).isActive = true
    }
}
