//
//  URLSessionMock.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

class URLSessionMock: URLSessionProtocol {
    typealias CompletionHandler = (Data?, URLResponse?, Error?) -> Void
    
    var data: Data?
    var error: Error?
    var response: HTTPURLResponse?

    init(data: Data? = nil, response: HTTPURLResponse? = nil, error: Error? = nil) {
        self.data = data
        self.response = response
        self.error = error
    }

    func dataTask(with request: URLRequest, completionHandler: @escaping CompletionHandler) -> URLSessionDataTask {
        let data = self.data
        let error = self.error
        let response = self.response

        return URLSessionDataTaskMock {
            completionHandler(data, response, error)
        }
    }
}
