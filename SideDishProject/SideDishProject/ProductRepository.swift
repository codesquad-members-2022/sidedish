import Foundation

struct Product {
    let id: Int
    let name: String
    let categoty: Category
}

enum Category {
    case maindish
    case soup
    case sidedish
}

enum ProductRepositoryError: Error {
    case fetchError
}

protocol ProductRepository {
    func fetchAll(completion: @escaping (Result<[Product], Error>) -> Void)
    func fetchList(by category: Category, completion: @escaping (Result<[Product], Error>) -> Void)
    func fetchOne(id: Int, completion: @escaping (Result<Product, ProductRepositoryError>) -> Void)
}

class MockProductRepository: ProductRepository {
    
    private let products: [Product]
    
    init() {
        // TODO: 팩토리에서 데이터를 생성해 set
        self.products = [
            Product(id: 1, name: "티본 스테이크", categoty: .maindish),
            Product(id: 2, name: "미역국", categoty: .soup)
        ]
    }
    
    func fetchAll(completion: @escaping (Result<[Product], Error>) -> Void) {
        completion(.success(products))
    }
    
    func fetchList(by category: Category, completion: @escaping (Result<[Product], Error>) -> Void) {
        let filteredResults = self.products.filter{ $0.categoty == category }
        completion(.success(filteredResults))
    }
    
    func fetchOne(id: Int, completion: @escaping (Result<Product, ProductRepositoryError>) -> Void) {
        guard let result = self.products.filter{ $0.id == id }.first else {
            return completion(.failure(.fetchError))
        }
        completion(.success(result))
    }
}
