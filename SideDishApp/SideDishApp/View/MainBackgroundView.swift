//
//  MainBackgroundView.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/24.
//

import UIKit

class MainBackgroundView: UICollectionReusableView {

    static let identifier = "MainBackgroundView"

    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
    }

    required init?(coder: NSCoder) {
        fatalError("not implemented")
    }
}

extension MainBackgroundView {
    func configure() {
        backgroundColor = .secondarySystemBackground
    }

}
