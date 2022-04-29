//
//  BanchanDetailViewModel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/29.
//

import Foundation

class BanchanDetailViewModel {
    private let service: BanchanUseCaseProtocol
    private let model: Banchan

    var descriptor = Observable<ProductDetail?>(nil)
    var thumbnailImages = Observable<[Data]>([])
    var sectionImages = Observable<[Data]>([])

    var thumbnailCount: Int {
        return self.thumbnailImages.value.count
    }

    var quantity: Int = 1
    var totalPrice: String {
        return Price(self.quantity * self.model.salePrice.toNumber()).toString()
    }

    init(model: Banchan, service: BanchanUseCaseProtocol) {
        self.model = model
        self.service = service
    }

    func getBanchanInfo() -> BanchanInfo {
        return BanchanInfo(
            title: self.model.title,
            description: self.model.menuDescription,
            salePrice: self.model.salePrice.toString(),
            normalPrice: self.model.normalPrice?.toString(),
            badges: self.model.badges
        )
    }

    func getBanchanDetail() {
        self.service.fetchData(with: self.model.id) { entity, error in
            DispatchQueue.main.async {
                guard let entity = entity, error == nil else {
                    // TODO: ERROR HANDLING
                    return
                }

                self.descriptor.value = entity
            }
        }
    }

    func getThumbnails() {
        guard let images = self.descriptor.value?.thumbImages else { return }
        self.service.getImages(with: images) { data in
            DispatchQueue.main.async {
                self.thumbnailImages.value.append(data)
            }
        }
    }

    func getSectionImages() {
        guard let images = self.descriptor.value?.detailSection else { return }
        self.service.getBulkImages(with: images) { data in
            self.sectionImages.value = data
        }
    }

    func updateQuantity(_ value: Double) {
        if self.quantity < Int(value) {
            self.quantity += 1
        } else {
            self.quantity -= 1
        }
    }
}
