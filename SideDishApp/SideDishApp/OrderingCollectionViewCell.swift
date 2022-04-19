//
//  OrderingCollectionViewCell.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

class OrderingCollectionViewCell: UICollectionViewCell {
    
    private let identifier = Constant.Identifier.orderingViewCell
    
    private let cellView = UIView()
    
    private let dishImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleToFill
        imageView.frame.size = CGSize(width: 130, height: 130)
        imageView.layer.cornerRadius = 5
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private let menuStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 8
        stackView.alignment = .leading
        return stackView
    }()
    
    private let menuInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .fillEqually
        return stackView
    }()
    
    private let titleLabel: UILabel = {
        let label = UILabel()
        label.textColor = .black
        return label
    }()
    
    private let descriptionLabel: UILabel = {
        let label = UILabel()
        label.textColor = .systemGray
        return label
    }()
    
    private let priceStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private let badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    private func setUpView() {
        contentView.addSubview(cellView)
        cellView.addSubview(dishImageView)
        cellView.addSubview(menuStackView)
        
        menuStackView.addArrangedSubview(menuInfoStackView)
        menuInfoStackView.addArrangedSubview(titleLabel)
        menuInfoStackView.addArrangedSubview(descriptionLabel)
        menuInfoStackView.addArrangedSubview(priceStackView)
        menuStackView.addArrangedSubview(badgeStackView)
        
        layoutCellView()
        layoutMenuStackView()
        layoutMenuInfoStackView()
        
        setDishImage(by: "mockImage.png")
        setMenuTitle(by: "보노보노 주물럭 요리")
        setMenuDescription(by: "감질맛 나는 매콤한 보노보노")
        setMenuPrice(origin: "15,800원", discounted: "12,640원")
        setBadges(by: [.launchingPrice, .eventPrice])
    }
    
    private func layoutCellView() {
        cellView.translatesAutoresizingMaskIntoConstraints = false
        cellView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        cellView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        cellView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16).isActive = true
        cellView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16).isActive = true
    }
    
    private func layoutMenuStackView() {
        menuStackView.translatesAutoresizingMaskIntoConstraints = false
        menuStackView.centerYAnchor.constraint(equalTo: cellView.centerYAnchor).isActive = true
        menuStackView.leadingAnchor.constraint(equalTo: dishImageView.trailingAnchor, constant: 8).isActive = true
        menuStackView.trailingAnchor.constraint(equalTo: cellView.trailingAnchor).isActive = true
    }
    
    private func layoutMenuInfoStackView() {
        menuInfoStackView.translatesAutoresizingMaskIntoConstraints = false
        menuInfoStackView.heightAnchor.constraint(greaterThanOrEqualToConstant: 72).isActive = true
    }
}

// MARK: - Providing Function

enum BadgeType {
    case launchingPrice
    case eventPrice
}

extension OrderingCollectionViewCell {
    func setDishImage(by imageName: String) {
        dishImageView.image = UIImage(named: imageName)
    }
    
    func setMenuTitle(by text: String) {
        titleLabel.text = text
    }
    
    func setMenuDescription(by text: String) {
        descriptionLabel.text = text
    }
    
    func setMenuPrice(origin: String?, discounted: String?) {
        guard let origin = origin else { return }
        let originPriceLabel = UILabel.makePriceLabel(price: origin)
        
        if let discounted = discounted {
            let discountdPriceLabel = UILabel.makePriceLabel(price: discounted)
            convertTextStyleToStrikeThrough(label: originPriceLabel)
            priceStackView.addArrangedSubview(discountdPriceLabel)
        }
        
        priceStackView.addArrangedSubview(originPriceLabel)
    }
    
    private func convertTextStyleToStrikeThrough(label: UILabel) {
        guard let text = label.text else { return }
        let attributeString: NSMutableAttributedString = NSMutableAttributedString(string: text)
        attributeString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                     value: NSUnderlineStyle.single.rawValue,
                                     range: NSRange(location: 0, length: attributeString.length))
        label.textColor = .systemGray
        label.attributedText = attributeString
    }
    
    func setBadges(by types: [BadgeType]) {
        types.forEach { type in
            switch type {
            case .eventPrice:
                let badge = UILabel.makeBadge(title: "런칭특가", backgroundColor: UIColor(red: 0.0, green: 102/255, blue: 214/255, alpha: 1.0))
                badgeStackView.addArrangedSubview(badge)
            case .launchingPrice:
                let badge = UILabel.makeBadge(title: "이벤트특가", backgroundColor: UIColor(red: 128/255, green: 188/255, blue: 255/255, alpha: 1.0))
                badgeStackView.addArrangedSubview(badge)
            }
        }
    }
    
}

// MARK: - Private Extension

private extension UILabel {
    static func makeBadge(title: String, backgroundColor: UIColor) -> UILabel {
        let label = PaddingLabel(padding: UIEdgeInsets(top: 4, left: 16, bottom: 4, right: 16))
        label.text = title
        label.textAlignment = .center
        label.textColor = .white
        label.backgroundColor = backgroundColor
        label.layer.cornerRadius = 13
        label.layer.masksToBounds = true
        return label
    }
    
    static func makePriceLabel(price text: String) -> UILabel {
        let label = UILabel()
        label.text = text
        label.textColor = .black
        return label
    }
}

class PaddingLabel: UILabel {
    private var padding = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
    
    convenience init(padding: UIEdgeInsets) {
        self.init()
        self.padding = padding
    }
    
    override func drawText(in rect: CGRect) {
        super.drawText(in: rect.inset(by: padding))
    }
    
    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize
        contentSize.height += padding.top + padding.bottom
        contentSize.width += padding.left + padding.right
        
        return contentSize
    }
}
