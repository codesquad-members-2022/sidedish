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
    
    var delegate: SectionHeaderViewDelegate?
    
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
        setup()
        setGesture()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    func setTitle(title: String?) {
        self.sectionTitleLabel.text = title
    }
    
    func setCountLabel(count: Int) {
        self.sectionCountLabel.text = "\(count)개의 상품이 등록되어 있습니다."
    }
    
    func setSectionNumber(number: Int) {
        self.sectionNumber = number
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        setTitle(title: nil)
    }
    
    private func setGesture() {
        let gesture = UITapGestureRecognizer(target: self, action: #selector(tapSectionHeaderView))
        self.addGestureRecognizer(gesture)
    }
    
    @objc func tapSectionHeaderView() {
        showNumberOfItemInSection()
        guard let sectionNumber = sectionNumber else { return }
        delegate?.didTapSectionHeader(section: self, sectionNumber: sectionNumber)
    }
    
    private func showNumberOfItemInSection() {
        let isCountVisible = isCountLableVisible()
        
        isCountVisible == true ? sectionCountLabel.removeFromSuperview() : self.sectionStackView.addArrangedSubview(sectionCountLabel)
    }
    
    private func isCountLableVisible() -> Bool {
        self.sectionStackView.subviews.contains { $0 == sectionCountLabel }
    }
    
    private func setup() {
        self.backgroundColor = .systemBackground
        let sectionInset: CGFloat = 16.0
        sectionStackView.translatesAutoresizingMaskIntoConstraints = false
        
        addSubview(sectionStackView)
        
        [sectionTitleLabel].forEach {
            self.sectionStackView.addArrangedSubview($0)
        }
        
        NSLayoutConstraint.activate([
            self.sectionStackView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: sectionInset),
            self.sectionStackView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -sectionInset),
            self.sectionStackView.topAnchor.constraint(equalTo: self.topAnchor, constant: sectionInset),
            self.sectionStackView.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -sectionInset)
        ])
    }
}

protocol SectionHeaderViewDelegate: AnyObject {
    func didTapSectionHeader(section: SectionHeaderView, sectionNumber: Int)
}
