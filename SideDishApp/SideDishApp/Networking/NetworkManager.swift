//
//  NetworkingManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation
import Alamofire

struct NetworkManager {
    
    func fetchProducts(of type: ProductType, completion: @escaping (Result<[Product], NetworkError>) -> Void) {
        
        do {
            let url = try makeCategoryURL(of: type)
            
            AF.request(url).validate().responseDecodable(of: Response.self) { AFResponse in
                guard let products = AFResponse.value?.body else {
                    return completion(.failure(.noData))
                }
                completion(.success(products))
            }
        } catch {
            SystemLog.fault(error.localizedDescription)
        }
    }
    
    private func makeCategoryURL(of type: ProductType) throws -> URL {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/\(type)"
        
        guard let url = components.url else {
            throw NetworkError.wrongEndPoint
        }
        
        return url
    }
    
    func fetchImageData(url: URL, completion: @escaping (Result<Data, NetworkError>) -> Void) {
        
        guard let url = changeSchemeToHTTPS(url) else { return }
        
        AF.request(url).validate().responseData { response in
            guard let data = response.data else {
                return completion(.failure(.noData))
            }
            completion(.success(data))
        }
    }
    
    private func changeSchemeToHTTPS(_ url: URL) -> URL? {
        guard var components = URLComponents(url: url, resolvingAgainstBaseURL: false) else { return nil }
        
        components.scheme = "https"
        
        return components.url
    }
}
