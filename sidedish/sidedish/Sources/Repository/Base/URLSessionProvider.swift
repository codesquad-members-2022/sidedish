//
//  URLSessionProvider.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/06.
//

import Foundation

class URLSessionProvider {
    private let session: URLSessionProtocol
    
    init(session: URLSessionProtocol = URLSession.shared) {
        self.session = session
    }
    
    func dataTask(request: URLRequest, completionHandler: @escaping (NetworkResult) -> Void) {
        let task = session.dataTask(with: request) { data, response, error in
            
            if let error = error {
                return completionHandler(NetworkResult(.unknownError))
            }
            
            guard let httpResponse = response as? HTTPURLResponse else {
                return completionHandler(NetworkResult(.unknownError))
            }
            
            if (200..<300).contains(httpResponse.statusCode),
               let data = data {
                return completionHandler(NetworkResult(data))
            }
            
            return completionHandler(NetworkResult(.statusCodeError))
        }
        
        task.resume()
    }
}
