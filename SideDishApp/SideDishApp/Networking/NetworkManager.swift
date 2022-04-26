//
//  NetworkingManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation
import Alamofire


struct NetworkManager {

    func fetch<T: EndPoint & JSONEndPoint>(_ endpoint: T, completion: @escaping (T.DecodingType?) -> Void) {
        guard let url = endpoint.url else {
            SystemLog.fault(NetworkError.wrongEndPoint.localizedDescription)
            return completion(nil)
        }

        AF.request(url)
            .validate()
            .responseDecodable(of: T.DecodingType.self) { response in
                switch response.result {
                case .success(let data):
                    return completion(data)
                case .failure(let error):
                    SystemLog.fault(error.localizedDescription)
                    return completion(nil)
                }
            }
    }

    func fetch<T: EndPoint>(_ endpoint: T, completion: @escaping (Data?) -> Void) {
        guard let url = endpoint.url else {
            SystemLog.fault(NetworkError.wrongEndPoint.localizedDescription)
            return completion(nil)
        }

        AF.request(url)
            .validate()
            .responseData { response in
                switch response.result {
                case .success(let data):
                    return completion(data)
                case .failure(let error):
                    SystemLog.fault(error.localizedDescription)
                    return completion(nil)
                }
            }
    }
}
