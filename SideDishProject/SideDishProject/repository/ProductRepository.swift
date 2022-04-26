import Foundation

enum ProductRepositoryError: Error {
    case fetchError
}

protocol ProductRepository {
    func fetchAll(completion: @escaping (Result<[Product], ProductRepositoryError>) -> Void)
    func fetchList(by category: DishCategory, completion: @escaping (Result<[Product], ProductRepositoryError>) -> Void)
}

final class MockProductRepository {
    private let products: [Product]
    
    init() {
        self.products = MockProductFactory(makeCount: 10).makeRandomProducts()
    }
}
extension MockProductRepository: ProductRepository{

    func fetchAll(completion: @escaping (Result<[Product], ProductRepositoryError>) -> Void) {
        completion(.success(products))
    }
    
    func fetchList(by category: DishCategory, completion: @escaping (Result<[Product], ProductRepositoryError>) -> Void){
        let filteredResults = self.products.filter{ $0.category == category }
        completion(.success(filteredResults))
    }
}
