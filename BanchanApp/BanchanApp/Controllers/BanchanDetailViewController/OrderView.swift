//
//  OrderView.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/20.
//

import UIKit

protocol OrderViewDelegate: AnyObject {
    func orderViewDidTapOrderButton()
}

class OrderView: UIView {
    private lazy var productDetailStack: UIStackView = {
        let stack = UIStackView()
        stack.axis = .vertical
        stack.spacing = 8
        return stack
    }()

    private lazy var deliveryInfoStack: UIStackView = {
        let stack = UIStackView()
        stack.axis = .horizontal
        return stack
    }()

    private lazy var totalPriceLabel: UILabel = {
        let label = UILabel()
        label.textAlignment = .right

        let padding = NSTextAttachment()
        padding.bounds.size = CGSize(width: 24, height: 0)

        let titleAttribute: [NSAttributedString.Key: Any] = [
            .foregroundColor: UIColor(named: "Grey2") ?? UIColor.black,
            .font: UIFont.systemFont(ofSize: 18, weight: .semibold),
            .baselineOffset: (32 - 18) / 3
        ]

        let priceAttribute: [NSAttributedString.Key: Any] = [
            .foregroundColor: UIColor.black,
            .font: UIFont.systemFont(ofSize: 32, weight: .semibold)
        ]

        let attributedText = NSMutableAttributedString(string: "총 주문금액", attributes: titleAttribute)
        let priceText = NSMutableAttributedString(string: "12,000원", attributes: priceAttribute)

        let offset = abs(attributedText.size().height - priceText.size().height)

        attributedText.insert(NSAttributedString(attachment: padding), at: attributedText.length)
        attributedText.append(priceText)
        label.attributedText = attributedText

        return label
    }()

    private lazy var quantityView = UIView()

    private lazy var orderButton: UIButton = {
        let button = UIButton(type: .system)
        return button
    }()

    var delegate: OrderViewDelegate?

    // MARK: - Initializers
    override init(frame: CGRect) {
        super.init(frame: frame)
        self.configureUI()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.configureUI()
    }

    // MARK: - UI Configuration
    private func configureProductDescription() {
        self.addSubview(self.productDetailStack)
        self.anchor(
            top: self.topAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor
        )

        let productTitleLabel = UILabel()
        productTitleLabel.frame.size = productTitleLabel.intrinsicContentSize
        productTitleLabel.text = "오리 주물럭 반조리"

        let productSubtitleLabel = UILabel()
        productSubtitleLabel.frame.size = productSubtitleLabel.intrinsicContentSize
        productSubtitleLabel.text = "감칠맛 나는 매콤한 양념"

        let productPriceLabel = UILabel()
        productPriceLabel.frame.size = productPriceLabel.intrinsicContentSize
        productPriceLabel.text = "12,640원 15,800원"

        self.productDetailStack.addSubview(productTitleLabel)
        self.productDetailStack.addSubview(productSubtitleLabel)
        self.productDetailStack.addSubview(productPriceLabel)
    }

    private func configureDeliveryInformationView() {
        self.addSubview(self.deliveryInfoStack)
        self.deliveryInfoStack.anchor(
            top: self.productDetailStack.bottomAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureQuantityView() {
        self.addSubview(self.quantityView)
        self.quantityView.anchor(
            top: self.deliveryInfoStack.bottomAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureTotalPriceLabel() {
        self.addSubview(self.totalPriceLabel)
        self.totalPriceLabel.anchor(
            top: self.quantityView.bottomAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureOrderButton() {
        self.addSubview(self.orderButton)
        self.orderButton.setHeight(50)
        self.orderButton.anchor(
            top: totalPriceLabel.bottomAnchor,
            bottom: self.bottomAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor,
            paddingTop: 24
        )

        self.orderButton.setTitle("주문하기", for: .normal)
    }

    private func configureUI() {
        self.configureProductDescription()
        self.configureDeliveryInformationView()
        self.configureQuantityView()
        self.configureTotalPriceLabel()
        self.configureOrderButton()
    }
}
