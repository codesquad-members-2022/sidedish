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
        title.snp.makeConstraints { make in
            make.top.centerY.equalToSuperview()
            make.leading.equalToSuperview().offset(16)
            make.trailing.equalToSuperview().offset(-16)
        }
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
