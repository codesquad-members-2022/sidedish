import Foundation

protocol DishCellRepositoryProtocol {
    func fetchInfo(sort: ProductSort, _ completion: @escaping (Result<[DishCellInfo], NetworkError>) -> Void)
}

class DishCellRepository: DishCellRepositoryProtocol {
    func fetchInfo(sort: ProductSort, _ completion: @escaping (Result<[DishCellInfo], NetworkError>) -> Void) {
        var urlComponent = URLComponents()
        urlComponent.scheme = "https"
        urlComponent.host = "api.codesquad.kr"
        urlComponent.path = "/onban\(sort.rawValue)"
        guard let url = urlComponent.url else { return }
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
