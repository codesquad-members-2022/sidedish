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

    var price: Int = 0 {
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

        let numberFormatter = NumberFormatter()
        numberFormatter.numberStyle = .decimal
        let formattedNumber = numberFormatter.string(from: NSNumber(value: self.price)) ?? "0"

        let titleAttribute: [NSAttributedString.Key: Any] = [
            .foregroundColor: UIColor(named: "Gray2") ?? UIColor.black,
            .font: UIFont.systemFont(ofSize: 18, weight: .semibold),
            .baselineOffset: (32 - 18) / 3
        ]

        let priceAttribute: [NSAttributedString.Key: Any] = [
            .foregroundColor: UIColor.black,
            .font: UIFont.systemFont(ofSize: 32, weight: .semibold)
        ]

        let attributedText = NSMutableAttributedString(string: self.tagName, attributes: titleAttribute)
        let priceText = NSMutableAttributedString(string: "\(String(describing: formattedNumber))원", attributes: priceAttribute)

        attributedText.insert(NSAttributedString(attachment: padding), at: attributedText.length)
        attributedText.append(priceText)
        self.attributedText = attributedText
    }
}
