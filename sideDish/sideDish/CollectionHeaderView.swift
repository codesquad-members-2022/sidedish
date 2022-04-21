//
//  CollectionHeaderView.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/19.
//

import UIKit

class CollectionHeaderView: UICollectionReusableView {
    
    private var title: UILabel = {
        let tempTitle = UILabel()
        tempTitle.text = "모두가 좋아하는 든든한 메인요리"
        tempTitle.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        tempTitle.font = UIFont.systemFont(ofSize: 32)
        tempTitle.numberOfLines = 2
        return tempTitle
    }()
    
    override init(frame: CGRect){
        super.init(frame: frame)
        configureLayout()
    }
    
    required init?(coder: NSCoder){
        super.init(coder: coder)
        configureLayout()
    }
    
    func configureLayout(){
        self.addSubview(title)
        title.translatesAutoresizingMaskIntoConstraints = false
        title.topAnchor.constraint(equalTo: self.topAnchor).isActive = true
        title.leadingAnchor.constraint(equalTo: self.leadingAnchor).isActive = true
        title.widthAnchor.constraint(equalTo: self.widthAnchor).isActive = true
        title.bottomAnchor.constraint(equalTo: self.bottomAnchor).isActive = true
    }
    
    
    func setTitle(text: String){
        title.text = text
    }
}


