import Foundation

final class DishCellViewModel {
    private let factory =  CellFactory(repository: DishCellRepository())
    private(set) var model: ProductModel?
    var onUpdate: () -> Void = { }

    func fetchData() {
        factory.onUpdate = {
            self.model = self.factory.convertCell2Product()
            self.onUpdate()
        }
        self.factory.fetchData()
    }
}
