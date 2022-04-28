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
    private let networkManager = NetworkManager()

	private var baseURL: URL? {
		return try? URL(string: "https://" + Configuration.value(for: "ServerURL"))
	}

	func getProductList(by type: BanchanType, completion: @escaping ([Product]) -> Void) {
		guard var url = self.baseURL else {
			return
		}

		url.appendPathComponent(type.toValue)

		let request = URLRequest(url: url)

        self.networkManager.fetchData(request: request, type: ProductResponse.self) { result in
            switch result {
            case .success(let products):
                completion(products.body)
            default:
                print(result)
            }
        }
	}
}
