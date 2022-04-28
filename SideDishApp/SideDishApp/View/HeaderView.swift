//
//  HeaderView.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/25.
//

import UIKit

class HeaderView: UICollectionReusableView {

    static let identifier = "HeaderView"

    private let title =  UILabel()

    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
    }

    required init?(coder: NSCoder) {
        fatalError("Not implemented")
    }

    private func configure() {
        addSubview(title)
        title.frame = self.bounds
        title.font = .largeRegular
        title.textColor = .grey1
        title.text = ""
        title.numberOfLines = 2

        title.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            title.topAnchor.constraint(equalTo: self.topAnchor, constant: 24)
        ])

    }

    func setTitle(text: String) {
        title.text = text
    }

}
