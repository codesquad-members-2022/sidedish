//
//  URLSession+Extension.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

protocol URLSessionProtocol {
    func dataTask(with request: URLRequest, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionDataTask
}

extension URLSession: URLSessionProtocol {}
