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
    
    private let titleLabel: UILabel = {
        var label = UILabel()
        label.font = .systemFont(ofSize: 40)
        label.numberOfLines = 0
        label.lineBreakStrategy = .hangulWordPriority
        return label
    }()
    
    private let captionLabel: UILabel = {
        var label = UILabel()
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
    
    func setUIValue(indexPath: IndexPath, dishCount: Int) {
        print("여기는 메인뷰헤더")
        switch indexPath.section {
        case 0:
            titleLabel.text = "모두가 좋아하는 든든한 메인 요리"
        case 1:
            titleLabel.text = "정성이 담긴 뜨끈뜨끈 국물 요리"
        case 2:
            titleLabel.text = "식탁을 풍성하게 하는 정갈한 밑반찬"
        default:
            return
        }
        captionLabel.text = "\(dishCount)개의 상품이 등록되어 있습니다."
    }
    
    private func setUI() {
        self.addSubview(titleLabel)
        self.addSubview(captionLabel)
        setConstraints()
    }
    
    private func setConstraints() {
        configureTitleLabelConstraint()
        configureCaptionLabelConstraint()
    }
    
    private func configureTitleLabelConstraint() {
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            titleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: 15),
            titleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15),
            titleLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -15)
        ])
    }
    
    private func configureCaptionLabelConstraint() {
        captionLabel.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            captionLabel.topAnchor.constraint(equalTo: titleLabel.bottomAnchor, constant: 15),
            captionLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15),
            captionLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -15)
        ])
    }
}
