//
//  Service.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

protocol ServiceProtocol {
	func fetchData(type: BanchanType, completion: @escaping ([Banchan]) -> Void)
}

class Service: ServiceProtocol {
	private var repository: RepositoryProtocol
	private var banchans: [Banchan] = []

	init(repository: RepositoryProtocol) {
		self.repository = repository
	}

	func fetchData(type: BanchanType, completion: @escaping ([Banchan]) -> Void) {
		self.repository.getProductList(by: type) { result in
			self.banchans = result.map({ entity in
				return entity.toDomain(type: type)
			})

			completion(self.banchans)
		}
	}
}
