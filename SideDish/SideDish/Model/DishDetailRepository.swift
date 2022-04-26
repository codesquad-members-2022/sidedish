import Foundation

class DishDetailRepository {

    func fetchDishDetail(of hashDetail: String, _ completion: @escaping (Result<DetailData, NetworkError>) -> Void) {
        guard let url = URL(string: "https://api.codesquad.kr/onban/detail/" + "\(hashDetail)") else { return completion(.failure(.wrongEndPoint))}

        URLSession.shared.dataTask(with: url) { (data, response, error) in
            if error != nil {
                return completion(.failure(.transferError))
            }

            guard let data = data else {
                return completion(.failure(.noData))
            }

            guard let response = response as? HTTPURLResponse else { return }
            let statusCode = response.statusCode

            guard 200..<300 ~= statusCode else {
                return completion(.failure(.serverError(statusCode: statusCode)))
            }

            let decoder = JSONDecoder()

            if let decodedData = try? decoder.decode(DishDetail.self, from: data) {
                completion(.success(decodedData.data))
            } else {
                completion(.failure(.unDecoded))
            }
        }.resume()
    }
}
