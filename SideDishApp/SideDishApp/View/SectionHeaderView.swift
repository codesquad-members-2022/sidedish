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
    private var sectionNumber: Int?

    weak var delegate: SectionHeaderViewDelegate?
    
    private lazy var sectionStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.distribution = .fillProportionally
        return stackView
    }()
    
    private lazy var sectionTitleLabel: UILabel = {
        let label: UILabel = UILabel()
        label.font = .systemFont(ofSize: fontSize, weight: .medium)
        label.numberOfLines = 2
        return label
    }()
    
    private lazy var sectionCountLabel: UILabel = {
        let label: UILabel = UILabel()
        label.font = .systemFont(ofSize: fontSize / 2)
        return label
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
        setUpGesture()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        setTitle(title: nil)
        if isCountLableVisible() {
            sectionCountLabel.removeFromSuperview()
        }
    }
    
    private func setUpView() {
        addSubview(sectionStackView)
        [sectionTitleLabel].forEach {
            sectionStackView.addArrangedSubview($0)
        }
        
        layoutSectionStackView()
    }

    private func setUpGesture() {
        let gesture = UITapGestureRecognizer(target: self, action: #selector(tapSectionHeaderView))
        addGestureRecognizer(gesture)
    }
    
    private func showNumberOfItemInSection() {
        let isCountVisible = isCountLableVisible()
        
        isCountVisible == true ? sectionCountLabel.removeFromSuperview() : sectionStackView.addArrangedSubview(sectionCountLabel)
    }
    
    private func isCountLableVisible() -> Bool {
        sectionStackView.subviews.contains { $0 == sectionCountLabel }
    }
}

// MARK: - View Layout

extension SectionHeaderView {
    private func layoutSectionStackView() {
        sectionStackView.translatesAutoresizingMaskIntoConstraints = false
        let sectionInset: CGFloat = 16.0
        NSLayoutConstraint.activate([
            sectionStackView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: sectionInset),
            sectionStackView.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -sectionInset),
            sectionStackView.topAnchor.constraint(equalTo: topAnchor, constant: sectionInset),
            sectionStackView.bottomAnchor.constraint(equalTo: bottomAnchor, constant: -sectionInset)
        ])
    }
}

// MARK: - Providing Function

extension SectionHeaderView {
    func setTitle(title: String?) {
        sectionTitleLabel.text = title
    }
    
    func setCountLabel(count: Int) {
        sectionCountLabel.text = "\(count)개의 상품이 등록되어 있습니다."
    }
    
    func setSectionNumber(number: Int) {
        sectionNumber = number
    }
}

// MARK: - Selector Function

extension SectionHeaderView {
    @objc private func tapSectionHeaderView() {
        showNumberOfItemInSection()
        guard let sectionNumber = sectionNumber else { return }
        delegate?.didTapSectionHeader(section: self, sectionNumber: sectionNumber)
    }
}
