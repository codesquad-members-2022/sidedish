//
//  CollectionViewHeader.swift
//  sidedish
//
//  Created by Jihee hwang on 2022/04/20.
//

import UIKit

class CollectionViewHeader: UICollectionReusableView {
    static let identifier = "HeaderView"
    
    private let title: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = .systemFont(ofSize: 32)
        label.textColor = .black
        label.numberOfLines = 2
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        addSubview(title)
        layout()
    }

    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func layout() {
        NSLayoutConstraint.activate([
            title.topAnchor.constraint(equalTo: topAnchor),
            title.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            title.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16),
            title.centerYAnchor.constraint(equalTo: centerYAnchor)
        ])
    }
}

extension CollectionViewHeader {
    func changeTitle(text: String) {
        title.text = text
    }
    
    func changeBackgroundColor(_ color: UIColor) {
        backgroundColor = color
    }
}
