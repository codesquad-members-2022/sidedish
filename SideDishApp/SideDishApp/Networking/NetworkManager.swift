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
    case wrongBaseEndPoint
    case wrongEndPoint
}

extension NetworkError: LocalizedError {
    var errorDescription: String? {
        switch self {
        case .noData: return NSLocalizedString("\(self)", comment: "No Data")
        case .wrongBaseEndPoint: return NSLocalizedString("\(self)", comment: "Wrong Base Endpoint")
        case .wrongEndPoint: return NSLocalizedString("\(self)", comment: "Wrong EndPoint")
        }
    }
}

struct NetworkManager {
    let baseEndPoint = "https://api.codesquad.kr/onban"
    
    func fetchProducts(of type: ProductType, completion: @escaping (Result<[Product], NetworkError>) -> Void) {
        
        guard var component = URLComponents(string: baseEndPoint) else {
            return completion(.failure(.wrongBaseEndPoint))
        }
        
        component.path += "/\(type)"
        
        guard let url = component.url else {
            return completion(.failure(.wrongEndPoint))
        }
        
        AF.request(url)
            .validate()
            .responseDecodable(of: Response.self) { AFResponse in
                
                guard let products = AFResponse.value?.body else {
                    return completion(.failure(.noData))
                }
                
                completion(.success(products))
            }
    }
    
    func fetchImageData(url: URL, completion: @escaping (Result<Data, NetworkError>) -> Void) {
        
        AF.request(url).validate().responseData { response in
            guard let data = response.data else {
                return completion(.failure(.noData))
            }
            completion(.success(data))
        }
        
    }
}
