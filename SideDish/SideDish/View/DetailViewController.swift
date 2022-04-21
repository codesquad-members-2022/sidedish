import UIKit

class DetailViewController: UIViewController {

    var amountOfProduct: Int = 0 {
        didSet {
            amountLabel.text = "\(amountOfProduct)"
        }
    }

    private let fullScreenScrollView: UIScrollView = {
        var scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.showsVerticalScrollIndicator = false
        return scrollView
    }()

    private let contentView: UIView = {
        var view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()

    private let productImageScrollView: UIScrollView = {
        var scrollView = UIScrollView()
        scrollView.isPagingEnabled = true
        scrollView.backgroundColor = .blue
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        return scrollView
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
        label.textColor = .systemGray2
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let finalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 18)
        label.textColor = .init(red: 79/255, green: 79/255, blue: 79/255, alpha: 1.0)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let normalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = .systemFont(ofSize: 16)
        label.font = UIFont.init(name: Font.sfRegular, size: 16)
        label.textColor = .systemGray2
        label.translatesAutoresizingMaskIntoConstraints = false
        label.isHidden = true
        return label
    }()

    private let badgeLabel: PaddingLabel = {
        var label = PaddingLabel()
        label.topInset = 4; label.bottomInset = 4
        label.leftInset = 16; label.rightInset = 16
        label.font = UIFont.init(name: Font.sfBold, size: 12)
        label.textColor = UIColor.white
        label.translatesAutoresizingMaskIntoConstraints = false
        label.clipsToBounds = true
        label.layer.cornerRadius = 10
        label.isHidden = true
        return label
    }()

    private let pointLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = UIColor.init(red: 79/255, green: 79/255, blue: 79/255, alpha: 1.0)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let shippingInfoLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = UIColor.init(red: 79/255, green: 79/255, blue: 79/255, alpha: 1.0)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let shippingFeeLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = UIColor.init(red: 79/255, green: 79/255, blue: 79/255, alpha: 1.0)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let amountLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfSemiBold, size: 18)
        label.textColor = UIColor.init(red: 79/255, green: 79/255, blue: 79/255, alpha: 1.0)
        label.translatesAutoresizingMaskIntoConstraints = false
        label.preferredMaxLayoutWidth = 57
        label.textAlignment = .center
        return label
    }()

    private let amountStepper: UIStepper = {
        var stepper = UIStepper()
        stepper.minimumValue = 0
        stepper.stepValue = 1.0
        return stepper
    }()

    private let totalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfSemiBold, size: 32)
        label.textColor = UIColor.black
        label.translatesAutoresizingMaskIntoConstraints = false
        label.textAlignment = .center
        return label
    }()

    private let orderButton: UIButton = {
        var button = UIButton()
        button.backgroundColor = UIColor.init(red: 0, green: 122/255, blue: 1, alpha: 1.0)
        button.clipsToBounds = true
        button.layer.cornerRadius = 12

        let font = UIFont.init(name: Font.sfSemiBold, size: 18) ?? UIFont.systemFont(ofSize: 18)
        let attributedTitle = NSMutableAttributedString(string: "주문하기")
        attributedTitle.addAttribute(.font, value: font, range: .init(0..<"주문하기".count))
        attributedTitle.addAttribute(.foregroundColor, value: UIColor.white, range: .init(0..<"주문하기".count))

        button.setAttributedTitle(attributedTitle, for: .normal)

        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()

    private let detailImageStackView: UIStackView = {
        var stackView = UIStackView()
        stackView.axis = .vertical
        stackView.distribution = .fill
        stackView.alignment = .fill
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()

    override func viewDidLoad() {
        super.viewDidLoad()

        navigationController?.navigationBar.topItem?.title = "뒤로"
        navigationController?.navigationBar.titleTextAttributes =
        [NSAttributedString.Key.font: UIFont(name: Font.sfSemiBold, size: 17) ?? UIFont.systemFont(ofSize: 17)]

        setLayout()
    }

    private func setLayout() {
        view.backgroundColor = .white

        setFullScreenScrollViewLayout()
        setContentViewLayout()
        setProducImageScrollViewLayout()
        setProductInfoComponentsLayout()
        setPointInfoStackViewLayout()
        setShippingInfoStackViewLayout()
        setShippingFeeInfoStackViewLayout()
        setAmountStackView()
        setTotalPriceStackViewLayout()
        setOrderButtonLayout()
        setDetailImageStackViewLayout()
    }

    private func setFullScreenScrollViewLayout() {
        view.addSubview(fullScreenScrollView)

        let safeArea = view.safeAreaLayoutGuide

        NSLayoutConstraint.activate([
            fullScreenScrollView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            fullScreenScrollView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            fullScreenScrollView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            fullScreenScrollView.bottomAnchor.constraint(equalTo: view.bottomAnchor)
        ])
    }

    private func setContentViewLayout() {
        fullScreenScrollView.addSubview(contentView)

        let contentViewCenterY = contentView.centerYAnchor.constraint(equalTo: fullScreenScrollView.centerYAnchor)
        contentViewCenterY.priority = .defaultLow

        let contentViewHeight = contentView.heightAnchor.constraint(greaterThanOrEqualTo: self.view.heightAnchor)
        contentViewHeight.priority = .defaultLow

        NSLayoutConstraint.activate([
            contentView.centerXAnchor.constraint(equalTo: fullScreenScrollView.centerXAnchor),
            contentView.topAnchor.constraint(equalTo: fullScreenScrollView.contentLayoutGuide.topAnchor),
            contentView.bottomAnchor.constraint(equalTo: fullScreenScrollView.contentLayoutGuide.bottomAnchor),
            contentView.widthAnchor.constraint(equalTo: fullScreenScrollView.widthAnchor),
            contentViewCenterY,
            contentViewHeight
        ])
    }

    private func setProducImageScrollViewLayout() {
        contentView.addSubview(productImageScrollView)

        NSLayoutConstraint.activate([
            productImageScrollView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor),
            productImageScrollView.topAnchor.constraint(equalTo: contentView.topAnchor),
            productImageScrollView.widthAnchor.constraint(equalTo: contentView.widthAnchor),
            productImageScrollView.bottomAnchor.constraint(equalTo: contentView.topAnchor, constant: 376)
        ])
    }

    private func setProductInfoComponentsLayout() {
        let productInfoStackView = UIStackView()
        productInfoStackView.axis = .vertical
        productInfoStackView.alignment = .leading
        productInfoStackView.distribution = .fill
        productInfoStackView.spacing = 8
        productInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(productInfoStackView)

        NSLayoutConstraint.activate([
            productInfoStackView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            productInfoStackView.topAnchor.constraint(equalTo: productImageScrollView.bottomAnchor, constant: 24),
            productInfoStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor,
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

        fullScreenScrollView.addSubview(badgeLabel)

        NSLayoutConstraint.activate([
            badgeLabel.leadingAnchor.constraint(equalTo: productInfoStackView.leadingAnchor),
            badgeLabel.topAnchor.constraint(equalTo: productInfoStackView.bottomAnchor, constant: 16),
            badgeLabel.heightAnchor.constraint(equalToConstant: 24)
        ])
    }

    private func setPointInfoStackViewLayout() {
        let dividingLine = UIView()
        dividingLine.backgroundColor = UIColor(red: 224/255, green: 224/255, blue: 224/255, alpha: 1.0)
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: badgeLabel.bottomAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: contentView.trailingAnchor,
                                                           constant: -16)
        ])

        let pointInfoStackView = UIStackView()
        pointInfoStackView.axis = .horizontal
        pointInfoStackView.alignment = .leading
        pointInfoStackView.distribution = .equalSpacing
        pointInfoStackView.spacing = 16
        pointInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(pointInfoStackView)

        NSLayoutConstraint.activate([
            pointInfoStackView.leadingAnchor.constraint(equalTo: dividingLine.leadingAnchor),
            pointInfoStackView.topAnchor.constraint(equalTo: dividingLine.bottomAnchor, constant: 24)
        ])

        let pointInfoTitleLabel = UILabel()
        pointInfoTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        pointInfoTitleLabel.textColor = UIColor.init(red: 130/255, green: 130/255, blue: 130/255, alpha: 1.0)
        pointInfoTitleLabel.text = "적립금"
        pointInfoTitleLabel.preferredMaxLayoutWidth = 60

        pointInfoStackView.addArrangedSubview(pointInfoTitleLabel)
        pointInfoStackView.addArrangedSubview(pointLabel)
    }

    private func setShippingInfoStackViewLayout() {

        let shippingInfoStackView = UIStackView()
        shippingInfoStackView.axis = .horizontal
        shippingInfoStackView.alignment = .leading
        shippingInfoStackView.distribution = .equalSpacing
        shippingInfoStackView.spacing = 16
        shippingInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(shippingInfoStackView)

        NSLayoutConstraint.activate([
            shippingInfoStackView.leadingAnchor.constraint(equalTo: badgeLabel.leadingAnchor),
            shippingInfoStackView.topAnchor.constraint(equalTo: pointLabel.bottomAnchor, constant: 16)
        ])

        let shippingInfoTitleLabel = UILabel()
        shippingInfoTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        shippingInfoTitleLabel.textColor = UIColor.init(red: 130/255, green: 130/255, blue: 130/255, alpha: 1.0)
        shippingInfoTitleLabel.text = "배송정보"
        shippingInfoTitleLabel.preferredMaxLayoutWidth = 60

        shippingInfoStackView.addArrangedSubview(shippingInfoTitleLabel)
        shippingInfoStackView.addArrangedSubview(shippingInfoLabel)
    }

    private func setShippingFeeInfoStackViewLayout() {
        let shippingFeeInfoStackView = UIStackView()
        shippingFeeInfoStackView.axis = .horizontal
        shippingFeeInfoStackView.alignment = .leading
        shippingFeeInfoStackView.distribution = .equalSpacing
        shippingFeeInfoStackView.spacing = 16
        shippingFeeInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(shippingFeeInfoStackView)

        NSLayoutConstraint.activate([
            shippingFeeInfoStackView.leadingAnchor.constraint(equalTo: badgeLabel.leadingAnchor),
            shippingFeeInfoStackView.topAnchor.constraint(equalTo: shippingInfoLabel.bottomAnchor, constant: 16)
        ])

        let shippingFeeTitleLabel = UILabel()
        shippingFeeTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        shippingFeeTitleLabel.textColor = UIColor.init(red: 130/255, green: 130/255, blue: 130/255, alpha: 1.0)
        shippingFeeTitleLabel.text = "배송비"
        shippingFeeTitleLabel.preferredMaxLayoutWidth = 60

        shippingFeeInfoStackView.addArrangedSubview(shippingFeeTitleLabel)
        shippingFeeInfoStackView.addArrangedSubview(shippingFeeLabel)

        let dividingLine = UIView()
        dividingLine.backgroundColor = UIColor(red: 224/255, green: 224/255, blue: 224/255, alpha: 1.0)
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: shippingFeeLabel.bottomAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: contentView.trailingAnchor,
                                                           constant: -16)
        ])
    }

    private func setAmountStackView() {
        let amountStackView = UIStackView()
        amountStackView.axis = .horizontal
        amountStackView.alignment = .fill
        amountStackView.distribution = .equalCentering
        amountStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(amountStackView)

        NSLayoutConstraint.activate([
            amountStackView.leadingAnchor.constraint(equalTo: badgeLabel.leadingAnchor),
            amountStackView.topAnchor.constraint(equalTo: shippingFeeLabel.bottomAnchor, constant: 51),
            amountStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16)
        ])

        let amountTitleLabel = UILabel()
        amountTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        amountTitleLabel.textColor = UIColor.init(red: 130/255, green: 130/255, blue: 130/255, alpha: 1.0)
        amountTitleLabel.text = "수량"
        amountTitleLabel.preferredMaxLayoutWidth = 60

        let amountComponetnsStackView = UIStackView()
        amountComponetnsStackView.axis = .horizontal
        amountComponetnsStackView.alignment = .fill
        amountComponetnsStackView.spacing = 0
        amountComponetnsStackView.translatesAutoresizingMaskIntoConstraints = false

        amountComponetnsStackView.addArrangedSubview(amountLabel)
        amountComponetnsStackView.addArrangedSubview(amountStepper)

        amountStackView.addArrangedSubview(amountTitleLabel)
        amountStackView.addArrangedSubview(amountComponetnsStackView)

        NSLayoutConstraint.activate([
            amountLabel.widthAnchor.constraint(greaterThanOrEqualToConstant: 57),
            amountLabel.trailingAnchor.constraint(equalTo: amountStepper.leadingAnchor)
        ])

        let dividingLine = UIView()
        dividingLine.backgroundColor = UIColor(red: 224/255, green: 224/255, blue: 224/255, alpha: 1.0)
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: amountStackView.bottomAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: contentView.trailingAnchor,
                                                           constant: -16)
        ])
    }

    private func setTotalPriceStackViewLayout() {
        let totalPriceStackView = UIStackView()
        totalPriceStackView.axis = .horizontal
        totalPriceStackView.alignment = .fill
        totalPriceStackView.distribution = .equalCentering
        totalPriceStackView.spacing = 24
        totalPriceStackView.translatesAutoresizingMaskIntoConstraints = false

        contentView.addSubview(totalPriceStackView)

        NSLayoutConstraint.activate([
            totalPriceStackView.topAnchor.constraint(equalTo: amountLabel.bottomAnchor, constant: 51),
            totalPriceStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16)
        ])

        let totalPriceTitleLabel = UILabel()
        totalPriceTitleLabel.font = UIFont(name: Font.sfSemiBold, size: 18)
        totalPriceTitleLabel.textColor = UIColor.init(red: 130/255, green: 130/255, blue: 130/255, alpha: 1.0)
        totalPriceTitleLabel.text = "총 주문금액"

        totalPriceStackView.addArrangedSubview(totalPriceTitleLabel)
        totalPriceStackView.addArrangedSubview(totalPriceLabel)
    }

    private func setOrderButtonLayout() {
        contentView.addSubview(orderButton)

        NSLayoutConstraint.activate([
            orderButton.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            orderButton.topAnchor.constraint(equalTo: totalPriceLabel.bottomAnchor, constant: 27),
            orderButton.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            orderButton.heightAnchor.constraint(equalToConstant: 44)
        ])
    }

    private func setDetailImageStackViewLayout() {
        contentView.addSubview(detailImageStackView)

        NSLayoutConstraint.activate([
            detailImageStackView.topAnchor.constraint(equalTo: orderButton.bottomAnchor, constant: 48),
            detailImageStackView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16),
            detailImageStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16),
            detailImageStackView.bottomAnchor.constraint(equalTo: fullScreenScrollView.contentLayoutGuide.bottomAnchor)
        ])
    }
}
