//
//  NetworkManager.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

class NetworkManager {
    private let session: URLSessionProtocol

    init(session: URLSessionProtocol = URLSession.shared) {
        self.session = session
    }

    func fetchData<T: Codable>(request: URLRequest, type: T.Type, completion: @escaping ((NetworkResult<T>) -> Void)) {
        let task = self.session.dataTask(with: request) { data, response, _ in
            guard let response = response as? HTTPURLResponse else {
                completion(.failure(NetworkError.unknownError))
                return
            }

            guard (200...399).contains(response.statusCode) else {
                completion(.failure(NetworkError(rawValue: response.statusCode) ?? .unknownError))
                return
            }

            guard let data = data else {
                completion(.failure(NetworkError.unknownError))
                return
            }

            guard let result = try? JSONDecoder().decode(T.self, from: data) else {
                completion(.failure(NetworkError.parsingError))
                return
            }

            completion(.success(result))
        }

        task.resume()
    }
}
