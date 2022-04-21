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
        configureLayout()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    //MARK: Image Attribute
    private let myImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "tempFood")
        imageView.contentMode = .scaleAspectFit
        
        return imageView
    }()
    
    //MARK: Label configure
    func configure() {
        let dumyContentArr = ["오리 주물럭_반조리","감질맛 나는 매콤한 양념","12,640원","15,800원","런칭특가"]
        
        for index in 0...4 {
            let repeatLabel = UILabel()
            repeatLabel.text = dumyContentArr[index]
            repeatLabel.backgroundColor = .white
            repeatLabel.textAlignment = .center
            storageLabel.append(repeatLabel)
            self.contentView.addSubview(repeatLabel)
        }
    }
    
    func configureLayout(){
        self.contentView.addSubview(myImageView)
        myImageView.translatesAutoresizingMaskIntoConstraints = false
        myImageView.widthAnchor.constraint(equalToConstant: 130).isActive = true
        myImageView.heightAnchor.constraint(equalToConstant: 130).isActive = true
        myImageView.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor).isActive = true
        myImageView.topAnchor.constraint(equalTo: self.contentView.topAnchor).isActive = true
        myImageView.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor).isActive = true
        
        storageLabel[0].translatesAutoresizingMaskIntoConstraints = false
        storageLabel[0].topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 13).isActive = true
        storageLabel[0].leadingAnchor.constraint(equalTo: myImageView.trailingAnchor, constant: 8).isActive = true
        storageLabel[0].heightAnchor.constraint(equalToConstant: 24).isActive = true

        storageLabel[1].translatesAutoresizingMaskIntoConstraints = false
        storageLabel[1].topAnchor.constraint(equalTo: storageLabel[0].bottomAnchor).isActive = true
        storageLabel[1].leadingAnchor.constraint(equalTo: storageLabel[0].leadingAnchor).isActive = true
        storageLabel[1].heightAnchor.constraint(equalToConstant: 24).isActive = true

        storageLabel[2].translatesAutoresizingMaskIntoConstraints = false
        storageLabel[2].topAnchor.constraint(equalTo: storageLabel[1].bottomAnchor).isActive = true
        storageLabel[2].leadingAnchor.constraint(equalTo: storageLabel[1].leadingAnchor).isActive = true
        storageLabel[2].heightAnchor.constraint(equalToConstant: 24).isActive = true

        storageLabel[3].translatesAutoresizingMaskIntoConstraints = false
        storageLabel[3].topAnchor.constraint(equalTo: storageLabel[2].topAnchor).isActive = true
        storageLabel[3].leadingAnchor.constraint(equalTo: storageLabel[2].trailingAnchor).isActive = true
        storageLabel[3].heightAnchor.constraint(equalToConstant: 24).isActive = true

        storageLabel[4].translatesAutoresizingMaskIntoConstraints = false
        storageLabel[4].topAnchor.constraint(equalTo: storageLabel[3].bottomAnchor, constant: 8).isActive = true
        storageLabel[4].leadingAnchor.constraint(equalTo: storageLabel[2].leadingAnchor).isActive = true
        storageLabel[4].heightAnchor.constraint(equalToConstant: 24).isActive = true
        storageLabel[4].bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: 13).isActive = true
        
        
        
        
    }

    
}
