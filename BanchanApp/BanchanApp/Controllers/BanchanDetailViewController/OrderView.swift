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

    private lazy var totalPriceLabel: PriceLabel = {
        let label = PriceLabel()
        label.price = 15000
        return label
    }()

    private lazy var quantityView = UIView()

    private lazy var orderButton: UIButton = {
        let configuration = UIButton.Configuration.filled()
        let button = UIButton(
            configuration: configuration,
            primaryAction: UIAction(handler: self.handleOnTapOrderButton)
        )

        button.setTitle("주문하기", for: .normal)

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
    }

    private func configureUI() {
        self.configureProductDescription()
        self.configureDeliveryInformationView()
        self.configureQuantityView()
        self.configureTotalPriceLabel()
        self.configureOrderButton()
    }

    private func handleOnTapOrderButton(_ action: UIAction) {
        self.delegate?.orderViewDidTapOrderButton()
    }
}
