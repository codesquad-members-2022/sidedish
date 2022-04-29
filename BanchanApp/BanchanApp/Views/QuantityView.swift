//
//  QuantityView.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/21.
//

import UIKit

protocol QuantityViewDelegate: AnyObject {
    func quantityViewDidChangeValue(value: Double)
}

class QuantityView: UIView {

    private lazy var stackView: UIStackView = {
        let stack = UIStackView()
        stack.axis = .horizontal
        stack.spacing = 24
        return stack
    }()

    private  lazy var titleLabel: UILabel = {
        let label = UILabel()
        label.text = "수량"
		label.font = .textSmallRegular
		label.textColor = .gray2
        return label
    }()

    private  lazy var quantityLabel: UILabel = {
        let label = UILabel()
        label.text = "1"
		label.font = .textMediumBold
		label.textColor = .gray1
        return label
    }()

    private lazy var quantityStepper: UIStepper = {
        let stepper = UIStepper()
        stepper.minimumValue = 1
        stepper.maximumValue = 100
        stepper.value = 1
        stepper.addAction(UIAction(handler: self.handleOnChangeQuantity), for: .valueChanged)

        return stepper
    }()

    // MARK: - Properties
    weak var delegate: QuantityViewDelegate?

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
    private func configureStepper() {
        self.stackView.addArrangedSubview(self.quantityStepper)
    }

    private func configureQuantityLabel() {
        self.stackView.addArrangedSubview(self.quantityLabel)
    }

    private func configureTitleLabel() {
        self.stackView.addArrangedSubview(self.titleLabel)
    }

    private func configureStackView() {
        self.addSubview(self.stackView)
        self.stackView.anchor(
            top: self.topAnchor,
            bottom: self.bottomAnchor,
            leading: self.leadingAnchor,
            trailing: self.trailingAnchor,
            paddingTop: 24,
            paddingBottom: 24
        )
    }

    private func configureUI() {
		let borderColor: UIColor = .gray3 ?? .systemGray3

        self.addTopBorder(with: borderColor, andWidth: 1)
        self.addBottomBorder(with: borderColor, andWidth: 1)
        self.configureStackView()
        self.configureTitleLabel()
        self.configureQuantityLabel()
        self.configureStepper()
    }

    private func convertQuantityValueToFormattedString(with value: Double) -> String? {
        let value = self.quantityStepper.value
        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .decimal

        return numberFormatter.string(from: NSNumber(value: value))
    }

    private func handleOnChangeQuantity(_ action: UIAction) {
        let value = self.quantityStepper.value
        self.quantityLabel.text = self.convertQuantityValueToFormattedString(with: value)
        self.delegate?.quantityViewDidChangeValue(value: value)
    }

    func setQuantity(_ value: Double) {
        self.quantityStepper.value = value
        self.quantityLabel.text = self.convertQuantityValueToFormattedString(with: value)
    }

}
