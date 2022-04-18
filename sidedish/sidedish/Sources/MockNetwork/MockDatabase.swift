//
//  MockDatabase.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/07.
//

import Foundation

final class MockDataBase {
        
    init() {
    }
    
    func databaseProcess(urlRequest: URLRequest, isRequestSuccess: Bool) -> (Data?, HTTPURLResponse?) {
        guard let url = urlRequest.url else {
            return (nil, nil)
        }

        if isRequestSuccess == false {
            return (nil, HTTPURLResponse(url: url, statusCode: 402, httpVersion: "2", headerFields: nil))
        }
        return (nil, HTTPURLResponse(url: url, statusCode: 402, httpVersion: "2", headerFields: nil))
    }
    
    private func bodyParser<T: Decodable>(_ type: T.Type, urlRequest: URLRequest) -> T? {
        guard let data = urlRequest.httpBody,
              let decodeData = try? JSONDecoder().decode(type.self, from: data) else {
                  return nil
              }
        return decodeData
    }
}

extension MockDataBase {
}
