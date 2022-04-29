import Foundation

protocol DishCellRepositoryProtocol {
    func fetchInfo(sort: ProductSort, _ completion: @escaping (Result<[DishCellInfo], NetworkError>) -> Void)
}

class DishCellRepository: DishCellRepositoryProtocol {
    func fetchInfo(sort: ProductSort, _ completion: @escaping (Result<[DishCellInfo], NetworkError>) -> Void) {
        guard let url = NetworkTarget.loadDishes(productSort: sort).url else { return }
        URLSession.shared.dataTask(with: url) { data, _, error in
            guard let data = data, error == nil else {
                completion(.failure(.noData))
                return
            }
            guard let models = try? JSONDecoder().decode(Dishes.self, from: data) else { return }
            completion(.success(models.body))
        }.resume()
    }
}
