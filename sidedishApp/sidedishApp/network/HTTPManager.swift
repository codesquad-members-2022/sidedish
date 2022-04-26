//
//  HTTPManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation
import UIKit

final class HTTPManager {
    enum HttpMethod: String {
        case get = "GET"
        case post = "POST"
        
        func getRawValue() -> String {
            return self.rawValue
        }
    }
    
    static func requestGet(url: String, complete: @escaping (Data) -> ()) {
        guard let validURL = URL(string: url) else { return }
       
        var urlRequest = URLRequest(url: validURL)
        urlRequest.httpMethod = HttpMethod.get.getRawValue()
        
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
    
    static func requestGetImageData(url: String) -> Data? {
        var result = Data()
        
        guard let validURL = URL(string: url) else { return nil }
       
        var urlRequest = URLRequest(url: validURL)
        urlRequest.httpMethod = HttpMethod.get.getRawValue()
        
        URLSession.shared.dataTask(with: urlRequest) { data, response, error in
            guard let httpURLResponse = response as? HTTPURLResponse, (200..<300) ~= httpURLResponse.statusCode,
                  let mimeType = response?.mimeType, mimeType.hasPrefix("image"),
                  let data = data, error == nil else {
                print("image download fail : \(url)")
                return
            }
            
            print(httpURLResponse)
            print(mimeType)
            print(data)
            result = data
        }.resume()
        return result
    }
}
