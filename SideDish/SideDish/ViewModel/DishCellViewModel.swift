import Foundation

protocol DishCellViewModelProtocol {
    func fetchData()
    var onUpdate: () -> Void { get }
}

final class DishCellViewModel: DishCellViewModelProtocol {
    private let repository: DishCellRepositoryProtocol
    var onUpdate: () -> Void = { }

    init(repository: DishCellRepositoryProtocol) {
        self.repository = repository
    }

    func fetchData() {
    }
}
