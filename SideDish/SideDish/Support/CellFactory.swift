import Foundation
import UIKit

protocol CellFactoryProtocol {
    func fetchData()
    var onUpdate: () -> Void { get }
}

final class CellFactory: CellFactoryProtocol {
    private let repository: DishCellRepositoryProtocol
    private(set) var products: [[DishCellInfo]] = []
    var onUpdate: () -> Void = { }

    init(repository: DishCellRepositoryProtocol) {
        self.repository = repository
    }

    func fetchData() {
        let allCases = ProductSort.allCases
        allCases.forEach { sort in
            self.repository.fetchInfo(sort: sort) { [weak self] result in
                switch result {
                case .success(let data):
                    DispatchQueue.main.async {
                        self?.products.append(data)
                    }
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

    func convertCell2Product() -> [[Product]] {
        let productArray: [[Product]] = self.products.map { sectionArray in
            let array = sectionArray.map { cell in
                return Product(origin: cell, image: UIImage(systemName: "pencil")!)
            }
            return array
        }
        return productArray
    }
}
