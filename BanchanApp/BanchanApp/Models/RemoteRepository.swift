//
//  Repository.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

protocol RepositoryProtocol {
	func getProductList(by type: BanchanType, completion: @escaping ([Product]) -> Void)
}

class RemoteRepository: RepositoryProtocol {
	private var baseURL: URL? {
		return try? URL(string: "https://" + Configuration.value(for: "ServerURL"))!
	}

	func getProductList(by type: BanchanType, completion: @escaping ([Product]) -> Void) {
		guard var url = self.baseURL else {
			return
		}

		url.appendPathComponent(type.toValue)

		let request = URLRequest(url: url)

		URLSession.shared.dataTask(with: request) { data, _, error in
			// TODO: Error handling
			guard let data = data, error == nil else { return }

			let jsonDecoder = JSONDecoder()

			do {
				let result = try jsonDecoder.decode(ProductResponse.self, from: data)
				completion(result.body)
			} catch {
				completion([])
			}
		}.resume()
	}
}
