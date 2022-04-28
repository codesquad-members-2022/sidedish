import UIKit

class DeliverySectionView: UIView {
    private let pointLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = .grey1
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let deliveryInfoLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = .grey1
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    private let deliveryFeeLabel: UILabel = {
        var label = UILabel()
        label.font = UIFont.init(name: Font.sfRegular, size: 14)
        label.textColor = .grey1
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()

    func setLayout() {
        translatesAutoresizingMaskIntoConstraints = false
        setPointViewLayout()
        setDeliveryInfoViewLayout()
        setDeliveryFeeInfoViewLayout()
    }

    private func setPointViewLayout() {
        let dividingLine = UIView()
        dividingLine.backgroundColor = .grey3
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: topAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: trailingAnchor, constant: -16)
        ])

        let pointInfoStackView = UIStackView()
        pointInfoStackView.axis = .horizontal
        pointInfoStackView.alignment = .leading
        pointInfoStackView.distribution = .equalSpacing
        pointInfoStackView.spacing = 16
        pointInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(pointInfoStackView)

        NSLayoutConstraint.activate([
            pointInfoStackView.leadingAnchor.constraint(equalTo: dividingLine.leadingAnchor),
            pointInfoStackView.topAnchor.constraint(equalTo: dividingLine.bottomAnchor, constant: 24)
        ])

        let pointInfoTitleLabel = UILabel()
        pointInfoTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        pointInfoTitleLabel.textColor = .grey2
        pointInfoTitleLabel.text = "적립금"
        pointInfoTitleLabel.preferredMaxLayoutWidth = 60

        pointInfoStackView.addArrangedSubview(pointInfoTitleLabel)
        pointInfoStackView.addArrangedSubview(pointLabel)
    }

    private func setDeliveryInfoViewLayout() {
        let deliveryInfoStackView = UIStackView()
        deliveryInfoStackView.axis = .horizontal
        deliveryInfoStackView.alignment = .leading
        deliveryInfoStackView.distribution = .equalSpacing
        deliveryInfoStackView.spacing = 16
        deliveryInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(deliveryInfoStackView)

        NSLayoutConstraint.activate([
            deliveryInfoStackView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            deliveryInfoStackView.topAnchor.constraint(equalTo: pointLabel.bottomAnchor, constant: 16)
        ])

        let deliveryInfoTitleLabel = UILabel()
        deliveryInfoTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        deliveryInfoTitleLabel.textColor = .grey2
        deliveryInfoTitleLabel.text = "배송정보"
        deliveryInfoTitleLabel.preferredMaxLayoutWidth = 60

        deliveryInfoStackView.addArrangedSubview(deliveryInfoTitleLabel)
        deliveryInfoStackView.addArrangedSubview(deliveryInfoLabel)
    }

    private func setDeliveryFeeInfoViewLayout() {
        let deliveryFeeInfoStackView = UIStackView()
        deliveryFeeInfoStackView.axis = .horizontal
        deliveryFeeInfoStackView.alignment = .leading
        deliveryFeeInfoStackView.distribution = .equalSpacing
        deliveryFeeInfoStackView.spacing = 16
        deliveryFeeInfoStackView.translatesAutoresizingMaskIntoConstraints = false

        addSubview(deliveryFeeInfoStackView)

        NSLayoutConstraint.activate([
            deliveryFeeInfoStackView.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            deliveryFeeInfoStackView.topAnchor.constraint(equalTo: deliveryInfoLabel.bottomAnchor, constant: 16)
        ])

        let shippingFeeTitleLabel = UILabel()
        shippingFeeTitleLabel.font = UIFont.init(name: Font.sfRegular, size: 14)
        shippingFeeTitleLabel.textColor = .grey2
        shippingFeeTitleLabel.text = "배송비"
        shippingFeeTitleLabel.preferredMaxLayoutWidth = 60

        deliveryFeeInfoStackView.addArrangedSubview(shippingFeeTitleLabel)
        deliveryFeeInfoStackView.addArrangedSubview(deliveryFeeLabel)

        let dividingLine = UIView()
        dividingLine.backgroundColor = .grey3
        dividingLine.translatesAutoresizingMaskIntoConstraints = false
        addSubview(dividingLine)

        NSLayoutConstraint.activate([
            dividingLine.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 16),
            dividingLine.topAnchor.constraint(equalTo: deliveryFeeLabel.bottomAnchor, constant: 24),
            dividingLine.heightAnchor.constraint(equalToConstant: 1.0),
            dividingLine.trailingAnchor.constraint(equalTo: trailingAnchor,
                                                           constant: -16)
        ])

        bottomAnchor.constraint(equalTo: dividingLine.bottomAnchor).isActive = true
    }

    func setComponents(with viewModel: DishDetailViewModel?) {
        pointLabel.text = viewModel?.point
        deliveryInfoLabel.text = viewModel?.deliveryInfo
        deliveryFeeLabel.text = viewModel?.deliveryFee
    }
}
