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
        let task = session.dataTask(with: request) { data, response, _ in
            
            guard let httpResponse = response as? HTTPURLResponse,
                  (200..<300).contains(httpResponse.statusCode) else {
                      return completionHandler(NetworkResult(.statusCodeError))
                  }
            
            if let data = data {
                return completionHandler(NetworkResult(data))
            }
            return completionHandler(NetworkResult(.unknownError))
        }
        
        task.resume()
    }
}
