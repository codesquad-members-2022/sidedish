//
//  OrderingCollectionViewCell.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import UIKit

final class OrderingCollectionViewCell: UICollectionViewCell {
    
    private let identifier = Constant.Identifier.orderingViewCell
    private let launchingBadgeBackgrounColor = UIColor(red: 0.0, green: 102/255, blue: 214/255, alpha: 1.0)
    private let eventBadgeBackgroundColor = UIColor(red: 128/255, green: 188/255, blue: 255/255, alpha: 1.0)
    private let defaultBadgeBackgroundColor = UIColor(red: 0.0, green: 122/255, blue: 1.0, alpha: 1.0)
    
    private lazy var cellView = UIView()
    
    private lazy var dishImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleToFill
        imageView.frame.size = CGSize(width: 130, height: 130)
        imageView.layer.cornerRadius = 5
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private lazy var menuStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 8
        stackView.alignment = .leading
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private lazy var menuInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.alignment = .leading
        stackView.distribution = .fillEqually
        return stackView
    }()
    
    private lazy var titleLabel: UILabel = {
        let label = UILabel()
        label.textColor = .black
        return label
    }()
    
    private lazy var descriptionLabel: UILabel = {
        let label = UILabel()
        label.textColor = .systemGray
        return label
    }()
    
    private lazy var priceStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private lazy var badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 4
        stackView.distribution = .fillProportionally
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init with coder is unavailable")
    }
    
    override func prepareForReuse() {
        super.prepareForReuse()
        prepareForReuse(stackView: priceStackView)
        prepareForReuse(stackView: badgeStackView)
    }
    
    private func prepareForReuse(stackView: UIStackView) {
        stackView.subviews.forEach {
            $0.removeFromSuperview()
        }
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

extension OrderingCollectionViewCell {
    func setDishImage(by imageName: String) {
        let url = URL(string: imageName)
        DispatchQueue.global().async {
            guard let data = try? Data(contentsOf: url!) else { return }
            DispatchQueue.main.async {
                self.dishImageView.image = UIImage(data: data)
            }
        }
    }
    
    func setMenuTitle(by text: String) {
        titleLabel.text = text
    }
    
    func setMenuDescription(by text: String) {
        descriptionLabel.text = text
    }
    
    func setMenuPrice(nPrice: String?, sPrice: String?) {
        guard let sPrice = sPrice else { return }
        
        if let nPrice = nPrice {
            let discountedPriceLabel = UILabel.makeCurrentPriceLabel(price: sPrice)
            let originPriceLabel = UILabel.makePreviousPriceLabel(price: nPrice)
            priceStackView.addArrangedSubview(discountedPriceLabel)
            priceStackView.addArrangedSubview(originPriceLabel)
        } else {
            let originPriceLabel = UILabel.makeCurrentPriceLabel(price: sPrice)
            priceStackView.addArrangedSubview(originPriceLabel)
        }
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
    
    func setBadges(by types: [String]?) {
        guard let types = types else { return }
        
        types.forEach { type in
            switch type {
            case "런칭특가":
                let badge = UILabel.makeBadge(title: "런칭특가", backgroundColor: launchingBadgeBackgrounColor)
                badgeStackView.addArrangedSubview(badge)
            case "이벤트특가":
                let badge = UILabel.makeBadge(title: "이벤트특가", backgroundColor: eventBadgeBackgroundColor)
                badgeStackView.addArrangedSubview(badge)
            default:
                let badge = UILabel.makeBadge(title: type, backgroundColor: defaultBadgeBackgroundColor)
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
        label.adjustsFontSizeToFitWidth = true
        label.minimumScaleFactor = 0.5
        label.textAlignment = .center
        label.textColor = .white
        label.backgroundColor = backgroundColor
        label.layer.cornerRadius = 13
        label.layer.masksToBounds = true
        return label
    }
    
    static func makeCurrentPriceLabel(price text: String) -> UILabel {
        let label = UILabel()
        label.text = text
        label.textColor = .black
        return label
    }
    
    static func makePreviousPriceLabel(price text: String) -> UILabel {
        let label = UILabel()
        let attributeString: NSMutableAttributedString = NSMutableAttributedString(string: text)
        attributeString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                     value: NSUnderlineStyle.single.rawValue,
                                     range: NSRange(location: 0, length: attributeString.length))
        label.attributedText = attributeString
        label.textColor = .systemGray
        return label
    }
}

final class PaddingLabel: UILabel {
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
