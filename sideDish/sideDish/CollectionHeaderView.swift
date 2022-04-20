//
//  CollectionHeaderView.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/19.
//

import UIKit

class CollectionHeaderView: UICollectionReusableView {
    
    private var title: UILabel!
    
    override init(frame: CGRect){
        super.init(frame: frame)
        configureLayout()
    }
    
    required init?(coder: NSCoder){
        super.init(coder: coder)
        configureLayout()
    }
    
    func configureLayout(){
        title = UILabel(frame: CGRect(x: 0, y: 0, width: self.frame.width, height: self.frame.height))
        title.text = "모두가 좋아하는 든든한 메인요리"
        title.textColor = UIColor(red: 0.31, green: 0.31, blue: 0.31, alpha: 1)
        title.font = UIFont.systemFont(ofSize: 32)
        title.numberOfLines = 2
        self.addSubview(title)        
    }
    
    func setTitle(text: String){
        title.text = text
    }
}


