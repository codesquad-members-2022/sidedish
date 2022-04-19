//
//  MainViewHeader.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation
import UIKit

class MainViewHeader: UICollectionReusableView {
    
    static let identifier = "MainViewHeader"
    
    private lazy var titleLabel: UILabel = {
        var label = UILabel()
        label.text = "모두가 좋아하는 든든한 메인 요리"
        label.font = .systemFont(ofSize: 25)
        return label
    }()
    
    private lazy var captionLabel: UILabel = {
        var label = UILabel()
        label.text = "n개의 상품이 등록되어 있습니다."
        label.font = .systemFont(ofSize: 15)
        label.textColor =  .systemGray5
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    private func setUI() {
        self.addSubview(titleLabel)
        self.addSubview(captionLabel)
        setTitleLabelConstraint()
        setCaptionLabelConstraint()
    }
    
    private func setTitleLabelConstraint() {
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        titleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
    }
    
    private func setCaptionLabelConstraint() {
        captionLabel.translatesAutoresizingMaskIntoConstraints = false
        captionLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 15).isActive = true
        captionLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
    }
}
