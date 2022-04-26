//
//  PriceLabel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/21.
//

import UIKit

class PriceTag: UILabel {

    var tagName: String = "총 주문금액" {
        didSet {
            self.configureUI()
        }
    }

    var price: String = "0원" {
        didSet {
            self.configureUI()
        }
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.configureUI()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.configureUI()
    }

    private func configureUI() {
        self.textAlignment = .right

        let padding = NSTextAttachment()
        padding.bounds.size = CGSize(width: 24, height: 0)

		let titleFontSize: CGFloat = 18
		let priceFontSize: CGFloat = 32

		let titleFont = UIFont.systemFont(ofSize: titleFontSize, weight: .semibold)

        let titleAttribute: [NSAttributedString.Key: Any] = [
			.foregroundColor: .gray2 ?? UIColor.black,
            .font: titleFont,
			.baselineOffset: titleFont.xHeight / 2
        ]

        let priceAttribute: [NSAttributedString.Key: Any] = [
            .foregroundColor: UIColor.black,
            .font: UIFont.systemFont(ofSize: priceFontSize, weight: .semibold)
        ]

        let attributedText = NSMutableAttributedString(string: self.tagName, attributes: titleAttribute)
		let priceText = NSMutableAttributedString(string: "\(self.price)", attributes: priceAttribute)

        attributedText.insert(NSAttributedString(attachment: padding), at: attributedText.length)
        attributedText.append(priceText)

        self.attributedText = attributedText
    }

}
