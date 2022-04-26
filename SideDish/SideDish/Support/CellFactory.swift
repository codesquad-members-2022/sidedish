import Foundation
import UIKit

protocol CellFactoryProtocol {
    func fetchData()
    var onUpdate: () -> Void { get }
}

final class CellFactory: CellFactoryProtocol {
    private let repository: DishCellRepositoryProtocol
    private(set) var products: [ProductSort: [DishCellInfo]] = [:]
    var onUpdate: () -> Void = { }

    init(repository: DishCellRepositoryProtocol) {
        self.repository = repository
    }

    func fetchData() {
        let allCases: [ProductSort] = ProductSort.allCases
        for sort in allCases {
            self.repository.fetchInfo(sort: sort) { [weak self] result in
                switch result {
                case .success(let data):
                    self?.products[sort] = data
                    self?.onUpdate()
                case .failure:
                    // TODO: - error handling
                    print("\(sort.rawValue) error happend!!!")
                }
            }
        }
    }

    func fetchImageFromServer() {
    }
    
    func convertCell2Product() -> [ProductSort: [Product]] {
        var resultDictionary: [ProductSort: [Product]] = [ : ]
        for (key, value) in products {
            let productArray = value.map { Product(origin: $0, image: UIImage(systemName: "pencil")!)}
            resultDictionary[key] = productArray
        }
        return resultDictionary
    }
}
