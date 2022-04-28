//
//  HTTPManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class HTTPManager {
    
    static func requestGet(url: String, complete: @escaping (Data) -> ()) {
        guard let validURL = URL(string: url) else { return }
       
        var urlRequest = URLRequest(url: validURL)
        urlRequest.httpMethod = HTTPMethod.get.getRawValue()
        
        URLSession.shared.dataTask(with: urlRequest) { data, response, error in
            guard let data = data else { return }
            guard let response = response as? HTTPURLResponse,
                  (200..<300).contains(response.statusCode) else {
                if let response = response as? HTTPURLResponse {
                    print(response.statusCode)
                }
                return
            }

            complete(data)
        }.resume()
    }
}
