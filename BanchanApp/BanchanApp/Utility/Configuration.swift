//
//  Configuration.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

enum Configuration {
	enum Error: Swift.Error {
		case missingKey, invalidValue
	}

	static func value<T>(for key: String) throws -> T where T: LosslessStringConvertible {
		guard let object = Bundle.main.object(forInfoDictionaryKey: key) else {
			throw Error.missingKey
		}

		switch object {
		case let value as T:
			return value
		case let string as String:
			guard let value = T(string) else { fallthrough }
			return value
		default:
			throw Error.invalidValue
		}
	}
}
