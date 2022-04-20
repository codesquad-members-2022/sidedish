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
    private(set) var storageLabel = [UILabel]()
    
    //MARK: Initiallize
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        configure()
        contentView.addSubview(storageLabel[0])
        contentView.addSubview(storageLabel[1])
        contentView.addSubview(storageLabel[2])
        contentView.addSubview(storageLabel[3])
        contentView.addSubview(myImageView)
        contentView.backgroundColor = .systemBlue
        contentView.clipsToBounds = true
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    //MARK: Image Attribute
    private let myImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "tempFood")
        imageView.contentMode = .left
        imageView.clipsToBounds = true
        
        let imageSize = CGSize(width: 130.0, height: 130.0)
        UIGraphicsBeginImageContextWithOptions(imageSize, false, 0.0)
        let imageRect = CGRect(x: 0.0, y: 0.0, width: imageSize.width, height: imageSize.height)
        imageView.frame = imageRect
        
        return imageView
    }()
    
    //MARK: Label configure
    func configure() {
        let dumyContentArr = ["오리 주물럭_반조리","감질맛 나는 매콤한 양념","12,640원 15,800원" , "런칭특가"]
        
        for index in 0...3 {
            let repeatLabel = UILabel()
            repeatLabel.text = dumyContentArr[index]
            repeatLabel.backgroundColor = .white
            repeatLabel.textAlignment = .center
            repeatLabel.frame = CGRect(x: 0, y: 50 * index, width: Int(contentView.frame.size.width), height: 50)
            storageLabel.append(repeatLabel)
        }
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()

    }
    
}
