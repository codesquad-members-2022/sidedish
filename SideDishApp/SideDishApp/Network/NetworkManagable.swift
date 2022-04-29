//
//  NetworkManagable.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/28.
//

import Foundation

protocol NetworkManagable: AnyObject {
    func request<T: Decodable>(endpoint: Endpointable, completion: @escaping((Result<T?, NetworkError>) -> Void))
    func dataTask<T: Decodable>(urlRequest: URLRequest, completion: @escaping((Result<T?, NetworkError>) -> Void))
}

extension NetworkManagable {
     func getStatusCode(response: URLResponse?) -> Int? {
        guard let httpResponse = response as? HTTPURLResponse else { return nil }
        return httpResponse.statusCode
    }
}
