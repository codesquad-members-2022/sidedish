//
//  NetworkingManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation
import Alamofire

struct NetworkManager {

    func request<Request: APIRequest>(_ request: Request, completion: @escaping (Request.Response?) -> Void) {

        AF.request(request.url,
                   method: request.method,
                   parameters: request.queryItems,
                   headers: HTTPHeaders(request.headers)
        ).validate().responseData { response in
            switch response.result {
            case .success(let data):
                return completion(request.decode(data))
            case .failure(let error):
                SystemLog.fault(error.localizedDescription)
                return completion(nil)
            }
        }
    }
}
