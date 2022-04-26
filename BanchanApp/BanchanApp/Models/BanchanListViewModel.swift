//
//  BanchanListViewModel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

class BanchanListViewModel {
	private let service: ServiceProtocol

	let banchans: Observable<[Banchan]> = Observable([])

	init(service: Service) {
		self.service = service
	}

	func fetchProduct(type: BanchanType) {
		self.service.fetchData(type: type) { models in
			self.banchans.value = models
		}
	}
}
