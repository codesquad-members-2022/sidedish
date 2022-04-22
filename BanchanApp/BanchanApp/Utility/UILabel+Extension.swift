//
//  UILabel+Extension.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/22.
//

import UIKit

extension UILabel {

	func applyStrikethoroughStyle() {
		if let text = self.text {
			let attributeString = NSMutableAttributedString(string: text)
			attributeString.addAttribute(.strikethroughStyle, value: NSUnderlineStyle.single.rawValue, range: NSRange(location: 0, length: attributeString.length))
			self.attributedText = attributeString
		}
	}

	func applySemiBold() {
		self.font = .systemFont(ofSize: 14, weight: .semibold)
	}

	func applyColorGray() {
		self.font = .systemFont(ofSize: 14)
		self.textColor = .systemGray2
	}

}
