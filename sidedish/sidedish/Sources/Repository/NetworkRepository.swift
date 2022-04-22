//
//  NetworkRepository.swift
//  Signup
//
//  Created by seongha shin on 2022/03/28.
//

import Combine
import Foundation

class NetworkRepository<Target: EndPoint> {
    private var provider: URLSessionProvider?
    
    func request(_ target: Target, session: URLSessionProtocol = URLSession.shared ) -> AnyPublisher<NetworkResult, Never> {
        provider = URLSessionProvider(session: session)
        
        guard let url = target.baseURL?.appendingPathComponent(target.path) else {
            return Future<NetworkResult, Never> { promise in promise(.success(NetworkResult(.pasingError))) }.eraseToAnyPublisher()
        }
        
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = target.method.value
        urlRequest.setValue("application/json; charset=utf-8", forHTTPHeaderField: "Content-Type")

        if let param = target.parameter,
           let body = try? JSONSerialization.data(withJSONObject: param, options: .init()) {
            urlRequest.httpBody = body
        }
        
        return Future<NetworkResult, Never> { promise in
            self.provider?.dataTask(request: urlRequest) { result in
                promise(.success(result))
            }
        }.eraseToAnyPublisher()
    }
}
