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
        setStyle()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
}

extension MainBackgroundView {
    func setStyle() {
        backgroundColor = .secondarySystemBackground
    }

}
