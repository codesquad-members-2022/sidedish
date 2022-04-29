//
//  Price.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

class Price {
	private let unit = "원"
	private var value: Int

	init(_ value: String) {
		let numberString = value.components(separatedBy: .decimalDigits.inverted).joined()
		self.value = Int(numberString) ?? 0
	}

	func toString() -> String {
		let numberFormatter = NumberFormatter()
		numberFormatter.numberStyle = .decimal
		let numberString = numberFormatter.string(from: NSNumber(value: self.value)) ?? "0"

		return "\(String(describing: numberString))\(self.unit)"
	}
}
