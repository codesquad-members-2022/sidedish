//
//  DishCommetHeaderView.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/22.
//

import UIKit

class DishCommentHeaderView: UICollectionReusableView{
    static let identifier = "DishCommentHeaderView"
    
    private lazy var dishTitleLabel: UILabel = {
        let label = UILabel()
        label.text = ""
        label.numberOfLines = 2
        label.font = UIFont.systemFont(ofSize: 28)
        return label
    }()
    
    override init(frame: CGRect){
        super.init(frame: frame)
        setupUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupUI()
    }

    private func setupUI(){
        addSubview(dishTitleLabel)
        dishTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        dishTitleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 10).isActive = true
        dishTitleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 10).isActive = true
        dishTitleLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -10).isActive = true
        dishTitleLabel.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -10).isActive = true
    }
    
    func setCommentLabel(text: String){
        dishTitleLabel.text = text
    }
}
