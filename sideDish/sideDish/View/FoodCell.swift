//
//  FoodCell.swift
//  sideDish
//
//  Created by 이건행 on 2022/04/19.
//

import Foundation
import UIKit

class FoodCell: UICollectionViewCell {
    static let identifier = "foodCell"
    
    //MARK: Initiallize
    override init(frame: CGRect) {
        super.init(frame: frame)
        contentView.backgroundColor = .systemBlue
        contentView.addSubview(tempFirstLabel)
        contentView.addSubview(tempSecondLabel)
        contentView.addSubview(tempThirdLabel)
        contentView.addSubview(tempFourLabel)
        
        contentView.addSubview(myImageView)
        contentView.clipsToBounds = true
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    //MARK: Image Attribute
    private let myImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "tempFood")
        imageView.contentMode = .left
        imageView.clipsToBounds = true
        return imageView
    }()
    
    //MARK: Label configure
    private let tempFirstLabel: UILabel = {
        let firstLabel = UILabel()
        firstLabel.text = "런칭특가"
        firstLabel.backgroundColor = .yellow
        firstLabel.textAlignment = .center
        
        return firstLabel
    }()
    
    private let tempSecondLabel: UILabel = {
        let secondLabel = UILabel()
        secondLabel.text = "12,640 15,800"
        secondLabel.backgroundColor = .green
        secondLabel.textAlignment = .center
        
        return secondLabel
    }()
    
    private let tempThirdLabel: UILabel = {
        let thirdLabel = UILabel()
        //thirdLabel.text = "12,640 15,800"
        thirdLabel.backgroundColor = .brown
        thirdLabel.textAlignment = .center
        
        return thirdLabel
    }()
    
    private let tempFourLabel: UILabel = {
        let fourLabel = UILabel()
        //fourLabel.text = "12,640 15,800"
        fourLabel.backgroundColor = .gray
        fourLabel.textAlignment = .center
        
        return fourLabel
    }()
    
    //MARK: Layout configure
    override func layoutSubviews() {
        super.layoutSubviews()
        
        tempFirstLabel.frame = CGRect(x:0,
                               y:0,
                               width: contentView.frame.size.width,
                               height: 50)

        tempSecondLabel.frame = CGRect(x:0,
                                y:50,
                                width: contentView.frame.size.width,
                                height: 50)
        
        tempThirdLabel.frame = CGRect(x:0,
                                y:100,
                                width: contentView.frame.size.width,
                                height: 50)
        
        tempFourLabel.frame = CGRect(x:0,
                                y:150,
                                width: contentView.frame.size.width,
                                height: 50)
        
        let imageSize = CGSize(width: 130.0, height: 130.0)
        UIGraphicsBeginImageContextWithOptions(imageSize, false, 0.0)
        let imageRect = CGRect(x: 0.0, y: 0.0, width: imageSize.width, height: imageSize.height)
        myImageView.frame = imageRect
    }
    
    func configure(firLabel: String, secLabel: String,thiLabel: String, fouLabel:String) {
        tempFirstLabel.text = firLabel
        tempSecondLabel.text = secLabel
        tempThirdLabel.text = thiLabel
        tempFourLabel.text = fouLabel
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        tempFirstLabel.text = nil
    }
    
}
