import Foundation

final class DishCellViewModel {
    private let factory =  CellFactory(repository: DishCellRepository())
    private(set) var model = ProductModel()
    var onUpdate: () -> Void = { }
    var onUpdateWithImageData: (String, Data) -> Void = { _, _ in }
    subscript(hash: String) -> Product? {
        var result: Product?
        for (key, value) in model {
            var index = 0
            value.forEach { product in
                if product.hash != hash {
                    index += 1
                } else if product.hash == hash {
                    guard let temp = self.model[key] else {
                        return
                    }
                    result = temp[index]
                }
            }
        }
        return result
    }

    func fetchData() {
        factory.onUpdate = {
            self.model = self.convertCell2Product()
            self.onUpdate()
        }
        self.factory.onUpdateWithImageData = { hash, data in
            self.onUpdateWithImageData(hash, data)
        }
        self.factory.fetchData()
    }

    private func convertCell2Product() -> ProductModel {
       var resultDictionary: ProductModel = [ : ]
        for (key, value) in factory.products {
           let productArray = value.map {
               Product(origin: $0)
           }
           resultDictionary[key] = productArray
       }
       return resultDictionary
   }
}
