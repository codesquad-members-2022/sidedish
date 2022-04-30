import UIKit

class AmountSectionView: UIView {

    var amount: Int {
        get {
            Int(amountLabel.text ?? "") ?? 0
        } set {
            self.amountLabel.text = "\(newValue)"
        }
    }

    var totalPrice = 0 {
        didSet {
            self.totalPriceLabel.text = "\(totalPrice)".toPrice()
        }
    }

    private let amountLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfSemiBold, size: 18)
        label.textColor = .grey1
        label.translatesAutoresizingMaskIntoConstraints = false
        label.preferredMaxLayoutWidth = 57
        label.textAlignment = .center
        label.text = "0"
        return label
    }()

    let amountStepper: UIStepper = {
        var stepper = UIStepper()
        stepper.minimumValue = 0
        stepper.stepValue = 1.0
        return stepper
    }()

    private let totalPriceLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfSemiBold, size: 32)
        label.textColor = .black
        label.translatesAutoresizingMaskIntoConstraints = false
        label.textAlignment = .center
        label.text = "원"
        return label
    }()

    private let orderButton: UIButton = {
        var button = UIButton()
        button.backgroundColor = .primary2
        button.clipsToBounds = true
        button.layer.cornerRadius = 12

        let font = UIFont.init(name: Font.sfSemiBold, size: 18) ?? UIFont.systemFont(ofSize: 18)

        let title = "주문하기"
        let attributedTitle = NSMutableAttributedString(string: title)
        attributedTitle.addAttribute(.font, value: font, range: .init(0..<title.count))
        attributedTitle.addAttribute(.foregroundColor, value: UIColor.white, range: .init(0..<title.count))

        button.setAttributedTitle(attributedTitle, for: .normal)

        button.translatesAutoresizingMaskIntoConstraints = false
        return button
    }()

    func setLayout() {
        translatesAutoresizingMaskIntoConstraints = false
        setAmountViewLayout()
        setPriceViewLayout()
        setOrderButtonLayout()
    }

    private func setAmountViewLayout() {
        let amountStackView = UIStackView()
        amountStackView.axis = .horizontal
        amountStackView.alignment = .fill
        amountStackView.distribution = .equalCentering
        amountStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(amountStackView)

        NSLayoutConstraint.activate([
            amountStackView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            amountStackView.topAnchor.constraint(equalTo: topAnchor, constant: 51),
            amountStackView.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16)
        ])

        let amountTitleLabel = UILabel()
        amountTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        amountTitleLabel.textColor = .grey2
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
        dividingLine.backgroundColor = .grey3
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: amountStackView.bottomAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: trailingAnchor,
                                                   constant: -16)
        ])
    }

    private func setPriceViewLayout() {
        let totalPriceStackView = UIStackView()
        totalPriceStackView.axis = .horizontal
        totalPriceStackView.alignment = .fill
        totalPriceStackView.distribution = .equalCentering
        totalPriceStackView.spacing = 24
        totalPriceStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(totalPriceStackView)

        NSLayoutConstraint.activate([
            totalPriceStackView.topAnchor.constraint(equalTo: amountLabel.bottomAnchor, constant: 51),
            totalPriceStackView.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16)
        ])

        let totalPriceTitleLabel = UILabel()
        totalPriceTitleLabel.font = UIFont(name: Font.sfSemiBold, size: 18)
        totalPriceTitleLabel.textColor = .grey2
        totalPriceTitleLabel.text = "총 주문금액"

        totalPriceStackView.addArrangedSubview(totalPriceTitleLabel)
        totalPriceStackView.addArrangedSubview(totalPriceLabel)
    }

    private func setOrderButtonLayout() {
        addSubview(orderButton)

        NSLayoutConstraint.activate([
            orderButton.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            orderButton.topAnchor.constraint(equalTo: totalPriceLabel.bottomAnchor, constant: 27),
            orderButton.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16),
            orderButton.heightAnchor.constraint(equalToConstant: 44)
        ])

        bottomAnchor.constraint(equalTo: orderButton.bottomAnchor).isActive = true
    }
}
