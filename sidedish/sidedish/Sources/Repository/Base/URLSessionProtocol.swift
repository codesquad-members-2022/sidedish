//
//  URLSessionProtocol.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/06.
//

import Foundation

protocol URLSessionProtocol {
    func dataTask(with request: URLRequest, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionDataTask
}

extension URLSession: URLSessionProtocol {}
