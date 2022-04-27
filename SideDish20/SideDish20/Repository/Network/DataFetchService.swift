//
//  DataFetchService.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

final class DataFetchService: CommonURLManager {
    
    func fetchAll(onComplete: @escaping (Data?) -> Void) {
        guard let url = URL(string: Endpoint.main.endpoint) else { return onComplete(nil) }
        
        var request = URLRequest(url: url)
        request.httpMethod = "GET"
        request.addValue("application/json", forHTTPHeaderField: "content-type")
        
        URLSession.shared.dataTask(with: request) { data, response, error in
            if let error = error {
                onComplete(nil)
            }
            
            guard let response = response as? HTTPURLResponse, response.statusCode == 200 else {
                return onComplete(nil)
            }
                        
            guard let data = data else {
                return onComplete(nil)
            }
            
            onComplete(data)
        }.resume()
    }
}
