import Foundation

protocol CellFactoryProtocol {
    func fetchData()
}

final class CellFactory: CellFactoryProtocol {
    private let repository: DishCellRepositoryProtocol
    var onUpdate: () -> Void = {}
    var onUpdateWithImageData: (String, Data) -> Void = { _, _ in}
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
                    self.downLoadImage(products: data)
                case .failure:
                    print("\(sort.rawValue) error happend!!!")
                }
            }
        }
    }

    private func downLoadImage(products: [DishCellInfo]) {
        products.forEach { cell in
            DispatchQueue.global(qos: .userInitiated).async { [weak self] in
                guard let url = URL(string: cell.image) else { return }
                if let data = try? Data(contentsOf: url) {
                    self?.onUpdateWithImageData(cell.detailHash, data)
                }
            }
        }
    }
}
