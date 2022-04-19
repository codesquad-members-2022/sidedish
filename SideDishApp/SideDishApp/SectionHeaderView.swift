//
//  SectionHeaderView.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/19.
//

import UIKit

final class SectionHeaderView: UICollectionReusableView {
    
    private let identifier = Constant.Identifier.sectionHeaderView
    private let fontSize: CGFloat = 32.0
    
    private lazy var sectionTitleLabel: UILabel = {
        let label: UILabel = UILabel()
        label.font = .systemFont(ofSize: fontSize, weight: .medium)
        label.numberOfLines = 2
        return label
    }()
    
    private lazy var sectionCountLabel: UILabel = {
        let label: UILabel = UILabel()
        label.font = .systemFont(ofSize: fontSize / 2)
        label.text = "밥 밥바밥바밥바밥 밥밥~"
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
        setGesture()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    func setTitle(title: String) {
        self.sectionTitleLabel.text = title
    }
    
    private func setGesture() {
        let gesture = UITapGestureRecognizer(target: self, action: #selector(showSectionCount))
        self.addGestureRecognizer(gesture)
    }
    
    @objc func showSectionCount() {
        self.sectionCountLabel.isHidden = !sectionCountLabel.isHidden
    }
    
    private func setup() {
        self.backgroundColor = .systemBackground
        let sectionInset: CGFloat = 16.0
        
        [sectionTitleLabel, sectionCountLabel].forEach {
            $0.translatesAutoresizingMaskIntoConstraints = false
            self.addSubview($0)
        }
        
        NSLayoutConstraint.activate([
            self.sectionTitleLabel.topAnchor.constraint(equalTo: self.topAnchor, constant: sectionInset + 8.0),
            self.sectionTitleLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: sectionInset),
            self.sectionTitleLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: sectionInset),
            
            self.sectionCountLabel.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: sectionInset),
            self.sectionCountLabel.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -sectionInset),
            self.sectionCountLabel.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: sectionInset)
        ])
        
        sectionCountLabel.isHidden = true
        
    }
}
