//
//  TableViewHeader.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/22.
//

import UIKit

class MainCollectionViewSectionHeader: UICollectionReusableView {

    static let identifier = "MainCollectionViewSectionHeader"

    private let label: UILabel = {
        let label = UILabel()
        label.text = ""
        label.font = UIFont(name: "SF Pro Display Regular ", size: 32)
        label.backgroundColor = .blue
        return label
    }()

    func configureHeader(title: String) {
        backgroundColor = .systemGreen
        label.text = title
        addSubview(label)
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        label.frame = bounds
    }

}
