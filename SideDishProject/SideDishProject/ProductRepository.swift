import Foundation

enum ProductRepositoryError: Error {
    case fetchError
}

protocol ProductRepository {
    func fetchAll(completion: @escaping (Result<[Product], Error>) -> Void)
    func fetchList(by category: DishCategory, completion: @escaping (Result<[Product], Error>) -> Void)
    func fetchOne(id: UniqueID, completion: @escaping (Result<Product, ProductRepositoryError>) -> Void)
}

class MockProductRepository: ProductRepository {
    
    private let products: [Product]
    
    init() {
        self.products = ProductFactory().makeRandomProducts(count: 10)
    }
    
    func fetchAll(completion: @escaping (Result<[Product], Error>) -> Void) {
        completion(.success(products))
    }
    
    func fetchList(by category: DishCategory, completion: @escaping (Result<[Product], Error>) -> Void) {
        let filteredResults = self.products.filter{ $0.category == category }
        completion(.success(filteredResults))
    }
    
    func fetchOne(id: UniqueID, completion: @escaping (Result<Product, ProductRepositoryError>) -> Void) {
        guard let result = self.products.filter({ $0.id == id }).first else {
            return completion(.failure(.fetchError))
        }
        completion(.success(result))
    }
}

