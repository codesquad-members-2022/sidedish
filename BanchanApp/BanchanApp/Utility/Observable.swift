//
//  Observable.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

final class Observable<T> {
	typealias Listener = (T) -> Void

	private var listener: Listener?

	var value: T {
		didSet {
			self.listener?(value)
		}
	}

	init(_ value: T) {
		self.value = value
	}

	func bind(listener: Listener?) {
		self.listener = listener
		listener?(self.value)
	}
}
