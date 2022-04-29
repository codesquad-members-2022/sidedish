//
//  BanchanListViewModel.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

struct BanchanInfo {
    let title: String
    let description: String
    let salePrice: String
    let normalPrice: String?
    let badges: [String]
}

class BanchanListViewModel {
    typealias ImageSubscriber = (Data?) -> Void

    private let service: ServiceProtocol

    let banchans: Observable<[[Banchan]]> = Observable(Array(repeating: [], count: BanchanType.allCases.count))
    var images: [[Observable<Data?>]] = Array(repeating: [], count: BanchanType.allCases.count)

    var sectionCount: Int {
        return BanchanType.allCases.count
    }

    init(service: Service) {
        self.service = service
    }

    func bindImage(at indexPath: IndexPath, subscriber: @escaping ImageSubscriber) {
        let image = self.getImage(at: indexPath)
        image.bind(subscriber: subscriber)
    }

    func getNumberOfItems(inSection index: Int) -> Int {
        guard index < self.banchans.value.count, index >= 0 else {
            return 0
        }

        return self.banchans.value[index].count
    }

    func getBanchan(at indexPath: IndexPath) -> Banchan {
        return self.banchans.value[indexPath.section][indexPath.item]
    }

    func getImage(at indexPath: IndexPath) -> Observable<Data?> {
        return self.images[indexPath.section][indexPath.item]
    }

    func getBanchanInfo(withIndexPath indexPath: IndexPath) -> BanchanInfo {
        let model = self.getBanchan(at: indexPath)

        return BanchanInfo(
            title: model.title,
            description: model.menuDescription,
            salePrice: model.salePrice.toString(),
            normalPrice: model.normalPrice?.toString(),
            badges: model.badges
        )
    }

    // MARK: - Fetch
    func getProducts() {
        for (sectionIndex, type) in BanchanType.allCases.enumerated() {
            self.service.fetchData(type: type) { models, error in
                guard let models = models, error == nil else {
                    // TODO: ERROR HANDLING
                    return
                }

                models.forEach { _ in
                    self.images[sectionIndex].append(Observable<Data?>(nil))
                }

                self.banchans.value[sectionIndex] = models.map({ banchan in
                    return banchan
                })
            }
        }
    }

    func getBanchanImage(at indexPath: IndexPath) {
        let model = self.getBanchan(at: indexPath)
        self.service.getImage(with: model.imageUrl) { data in
            DispatchQueue.main.async {
                let image = self.getImage(at: indexPath)
                image.value = data
            }
        }
    }
}
