//
//  UIStackView+Extension.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import UIKit

extension UIStackView {
	func clearSubviews() {
		self.arrangedSubviews.forEach { view in
			self.removeArrangedSubview(view)
			view.removeFromSuperview()
		}
	}
}
