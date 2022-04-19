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
        label.font = .systemFont(ofSize: 40)
        label.numberOfLines = 0
        label.lineBreakStrategy = .hangulWordPriority
        label.text = "모두가 좋아하는 든든한 메인 요리"
        return label
    }()
    
    private lazy var captionLabel: UILabel = {
        var label = UILabel()
        label.text = "n개의 상품이 등록되어 있습니다."
        label.font = .systemFont(ofSize: 15)
        label.textColor =  .systemGray2
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUI()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setUI()
    }
    
    private func setUI() {
        self.addSubview(titleLabel)
        self.addSubview(captionLabel)
        setConstraints()
    }
    
    private func setConstraints() {
        setTitleLabelConstraint()
        setCaptionLabelConstraint()
    }
    
    private func setTitleLabelConstraint() {
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        titleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
        titleLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -15).isActive = true
    }
    
    private func setCaptionLabelConstraint() {
        captionLabel.translatesAutoresizingMaskIntoConstraints = false
        captionLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 15).isActive = true
        captionLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
        captionLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -15).isActive = true
    }
}
