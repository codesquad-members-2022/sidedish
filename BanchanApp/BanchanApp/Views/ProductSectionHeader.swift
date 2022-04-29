//
//  ProductSectionHeader.swift
//  BanchanApp
//
//  Created by Se Eun Lee on 2022/04/19.
//

import UIKit

protocol ProductSectionHeaderDelegate: AnyObject {
    func didTapTitle()
}

class ProductSectionHeader: UICollectionReusableView {

    static let identifier = "ProductSectionHeader"

    weak var delegate: ProductSectionHeaderDelegate?

    private lazy var titleButton: UIButton = {
        let button = UIButton(type: .system)

        button.titleLabel?.numberOfLines = 0
        button.titleLabel?.font = .textLargeBold
        button.setTitleColor(.gray1, for: .normal)

        return button
    }()

    override init(frame: CGRect) {
        super.init(frame: frame)
        setup()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setup()
    }

    private func setup() {
        self.addSubview(titleButton)
        titleButton.translatesAutoresizingMaskIntoConstraints = false
        titleButton.topAnchor.constraint(equalTo: self.safeAreaLayoutGuide.topAnchor).isActive = true
        titleButton.bottomAnchor.constraint(equalTo: self.safeAreaLayoutGuide.bottomAnchor).isActive = true
        titleButton.leadingAnchor.constraint(equalTo: self.safeAreaLayoutGuide.leadingAnchor).isActive = true
    }

    private func handleTitleTapped(_ action: UIAction) {
        self.delegate?.didTapTitle()
    }

    func setTitleText(_ text: String) {
        self.titleButton.setTitle(text, for: .normal)
    }

}
