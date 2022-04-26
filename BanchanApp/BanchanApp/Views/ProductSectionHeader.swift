//
//  ProductSectionHeader.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

class ProductSectionHeader: UICollectionReusableView {

	static let identifier = "ProductSectionHeader"

    let title: UILabel = UILabel()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    private func setup() {
        self.addSubview(title)
        title.numberOfLines = 0
		title.font = .textLargeRegular
		title.textColor = .gray1
        title.translatesAutoresizingMaskIntoConstraints = false
		title.topAnchor.constraint(equalTo: self.safeAreaLayoutGuide.topAnchor).isActive = true
		title.bottomAnchor.constraint(equalTo: self.safeAreaLayoutGuide.bottomAnchor).isActive = true
		title.leadingAnchor.constraint(equalTo: self.safeAreaLayoutGuide.leadingAnchor).isActive = true
    }

}
