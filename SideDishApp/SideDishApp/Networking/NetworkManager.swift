//
//  NetworkingManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation
import Alamofire

enum NetworkError: Error {
    case noData
}

struct NetworkManager {
    func fetchProducts(completion: @escaping (Result<[Product], NetworkError>) -> Void) {
        
        AF.request("https://api.codesquad.kr/onban/main")
            .validate()
            .responseDecodable(of: Response.self) { AFResponse in
                
                guard let products = AFResponse.value?.body else {
                    return completion(.failure(.noData))
                }
                
                completion(.success(products))
            }
    }
    
    func fetchImageData(urls: [URL], completion: @escaping ([URL: Data]) -> Void) {
        
    }
}
