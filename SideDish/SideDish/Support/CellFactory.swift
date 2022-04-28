import Foundation
import UIKit

protocol CellFactoryProtocol {
    func fetchData()
}

final class CellFactory: CellFactoryProtocol {
    private let repository: DishCellRepositoryProtocol
    var onUpdate: () -> Void = { }
    private(set) var products: [ProductSort: [DishCellInfo]] = [:] {
        didSet {
            if products.count == 3 {
                self.onUpdate()
            }
        }
    }

    init(repository: DishCellRepositoryProtocol) {
        self.repository = repository
    }

    func fetchData() {
        let allCases: [ProductSort] = ProductSort.allCases
        for sort in allCases {
            self.repository.fetchInfo(sort: sort) { result in
                switch result {
                case .success(let data):
                    self.products[sort] = data
                case .failure:
                    print("\(sort.rawValue) error happend!!!")
                }
            }
        }
    }

     func convertCell2Product() -> ProductModel {
        var resultDictionary: ProductModel = [ : ]
         for (key, value) in self.products {
            let productArray = value.map { Product(origin: $0, image: UIImage(systemName: "pencil")!)}
            resultDictionary[key] = productArray
        }
        return resultDictionary
    }
}
