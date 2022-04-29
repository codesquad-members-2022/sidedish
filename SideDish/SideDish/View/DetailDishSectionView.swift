import UIKit

class DetailDishSectionView: UIView {
    private let productImageContentView: UIStackView = {
        var stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 0
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()

    private let titleLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 32)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let descriptionLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 18)
        label.textColor = .grey2
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let finalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 18)
        label.textColor = .grey1
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = .systemFont(ofSize: 16)
        label.font = UIFont.init(name: Font.sfRegular, size: 16)
        label.textColor = .grey2
        label.translatesAutoresizingMaskIntoConstraints = false
        label.isHidden = true
        return label
    }()

    private let badgeStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.alignment = .leading
        stackView.distribution = .equalSpacing
        stackView.spacing = 4
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.isHidden = true
        return stackView
    }()

    private let eventBadgeLabel: PaddingLabel = {
        var label = PaddingLabel()
        label.setEdgeInset(top: 4, bottom: 4, left: 16, right: 16)
        label.font = UIFont.init(name: Font.sfBold, size: 12)
        label.textColor = .white
        label.translatesAutoresizingMaskIntoConstraints = false
        label.backgroundColor = .primary3
        label.text = "이벤트특가"
        label.clipsToBounds = true
        label.layer.cornerRadius = 10
        label.isHidden = true
        return label
    }()

    private let launchingBadgeLabel: PaddingLabel = {
        var label = PaddingLabel()
        label.setEdgeInset(top: 4, bottom: 4, left: 16, right: 16)
        label.font = UIFont.init(name: Font.sfBold, size: 12)
        label.textColor = .white
        label.translatesAutoresizingMaskIntoConstraints = false
        label.backgroundColor = .primary1
        label.text = "런칭특가"
        label.clipsToBounds = true
        label.layer.cornerRadius = 10
        label.isHidden = true
        return label
    }()

    func setLayout() {
        translatesAutoresizingMaskIntoConstraints = false
        setProductImageScrollViewLayout()
        setProductInfoComponentsLayout()
    }

    private func setProductImageScrollViewLayout() {
        let productImageScrollView = UIScrollView()
        productImageScrollView.isPagingEnabled = true
        productImageScrollView.showsHorizontalScrollIndicator = false
        productImageScrollView.translatesAutoresizingMaskIntoConstraints = false
        addSubview(productImageScrollView)

        NSLayoutConstraint.activate([
            productImageScrollView.leadingAnchor.constraint(equalTo: leadingAnchor),
            productImageScrollView.topAnchor.constraint(equalTo: topAnchor),
            productImageScrollView.widthAnchor.constraint(equalTo: widthAnchor),
            productImageScrollView.heightAnchor.constraint(equalTo: productImageScrollView.widthAnchor),
            productImageScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: productImageScrollView.topAnchor),
            productImageScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: productImageScrollView.leadingAnchor),
            productImageScrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: productImageScrollView.heightAnchor)
        ])

        productImageScrollView.addSubview(productImageContentView)

        NSLayoutConstraint.activate([
            productImageContentView.centerYAnchor.constraint(equalTo: productImageScrollView.centerYAnchor),
            productImageContentView.leadingAnchor.constraint(equalTo: productImageScrollView.leadingAnchor),
            productImageContentView.trailingAnchor.constraint(equalTo: productImageScrollView.trailingAnchor),
            productImageContentView.heightAnchor.constraint(equalTo: productImageScrollView.heightAnchor)
        ])
    }

    private func setProductInfoComponentsLayout() {
        let productInfoStackView = UIStackView()
        productInfoStackView.axis = .vertical
        productInfoStackView.alignment = .leading
        productInfoStackView.distribution = .fill
        productInfoStackView.spacing = 8
        productInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(productInfoStackView)

        NSLayoutConstraint.activate([
            productInfoStackView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            productInfoStackView.topAnchor.constraint(equalTo: productImageContentView.bottomAnchor, constant: 24),
            productInfoStackView.trailingAnchor.constraint(equalTo: trailingAnchor,
                                                           constant: -16)
        ])

        titleLabel.heightAnchor.constraint(equalToConstant: 48).isActive = true
        descriptionLabel.heightAnchor.constraint(equalToConstant: 24).isActive = true

        productInfoStackView.addArrangedSubview(titleLabel)
        productInfoStackView.addArrangedSubview(descriptionLabel)

        let priceInfoStackView = UIStackView()
        priceInfoStackView.axis = .horizontal
        priceInfoStackView.alignment = .fill
        priceInfoStackView.distribution = .equalSpacing
        priceInfoStackView.spacing = 8
        priceInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        productInfoStackView.addArrangedSubview(priceInfoStackView)
        priceInfoStackView.addArrangedSubview(finalPriceLabel)
        priceInfoStackView.addArrangedSubview(normalPriceLabel)

        addSubview(badgeStackView)

        NSLayoutConstraint.activate([
            badgeStackView.topAnchor.constraint(equalTo: priceInfoStackView.bottomAnchor, constant: 16),
            badgeStackView.leadingAnchor.constraint(equalTo: priceInfoStackView.leadingAnchor),
            badgeStackView.heightAnchor.constraint(equalToConstant: 24)
        ])

        badgeStackView.addArrangedSubview(eventBadgeLabel)
        badgeStackView.addArrangedSubview(launchingBadgeLabel)

        bottomAnchor.constraint(equalTo: badgeStackView.bottomAnchor).isActive = true
    }

    func setComponents(with detailStringData: DetailStringData, title: String, discountType: [DiscountType]?) {
        titleLabel.text = title
        descriptionLabel.text = detailStringData.description
        finalPriceLabel.text = detailStringData.finalPrice

        if let normalPrice = detailStringData.normalPrice {
            let attributedStyle = NSUnderlineStyle.single
            let attributedString = NSMutableAttributedString(string: normalPrice)
            attributedString.addAttribute(NSAttributedString.Key.strikethroughStyle,
                                          value: attributedStyle.rawValue,
                                          range: NSRange(0..<attributedString.length))
            normalPriceLabel.attributedText = attributedString
        }

        if let discountType = viewModel?.discountType {
            badgeStackView.isHidden = false
            discountType.forEach {
                switch $0 {
                case .event:
                    eventBadgeLabel.isHidden = false
                case .launching: launchingBadgeLabel.isHidden = false
                }
            }
        }
    }

    func addTopImage(with image: UIImage) {
        let imageView = UIImageView(image: image)
        imageView.contentMode = .scaleAspectFit
        imageView.widthAnchor.constraint(equalTo: imageView.heightAnchor).isActive = true

        productImageContentView.addArrangedSubview(imageView)
    }
}
