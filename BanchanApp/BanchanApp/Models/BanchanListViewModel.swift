//
//  BanchanListViewModel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

class BanchanListViewModel {
	private let service: ServiceProtocol

	let banchans: Observable<[[Banchan]]> = Observable(Array(repeating: [], count: BanchanType.allCases.count))

	var sectionCount: Int {
		return BanchanType.allCases.count
	}

	init(service: Service) {
		self.service = service
	}

	func fetchProducts() {
		for (index, type) in BanchanType.allCases.enumerated() {
			self.service.fetchData(type: type) { models in
				self.banchans.value[index] = models
			}
		}
	}

	func getNumberOfItems(inSection index: Int) -> Int {
		guard index < self.banchans.value.count, index >= 0 else {
			return 0
		}

		return self.banchans.value[index].count
	}

	func getBanchanInfo(withIndexPath indexPath: IndexPath) -> (title: String, description: String, salePrice: String, normalPrice: String?, badges: [String]) {
		let model = self.banchans.value[indexPath.section][indexPath.item]

		return (
			title: model.title,
			description: model.menuDescription,
			salePrice: model.salePrice.toString(),
			normalPrice: model.normalPrice?.toString(),
			badges: model.badges
		)
	}
}
