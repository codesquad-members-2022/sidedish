//
//  APIRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire
import UIKit

protocol APIRequestable {
    associatedtype Response

    var url: URL { get }
    var method: HTTPMethod { get }
    var headers: [String: String] { get }
    var queryItems: [String: String] { get }

    func decode(_ data: Data) -> Response?
}

extension APIRequestable {
    // Default Implementationg이 있기 때문에
    // Header, queryItem이 없을 경우 구현하지 않아도 됨
    var headers: [String: String] { [:] }
    var queryItems: [String: String] { [:] }

    // Request 생성 로직은 모든 구체 타입에서 동일하므로 default로 구현
    func buildRequest() -> DataRequest {
        return AF.request(self.url,
                          method: self.method,
                          parameters: self.queryItems,
                          headers: HTTPHeaders(self.headers)
        )
    }
}

extension APIRequestable {
    // execute 로직은 현재 모든 구체 타입에서 동일하므로 default로 구현
    func execute(completion: @escaping (Response?) -> Void) {
        self.buildRequest()
            .validate()
            .responseData { response in
                switch response.result {
                case .success(let data):
                    return completion(decode(data))
                case .failure(let error):
                    SystemLog.fault(error.localizedDescription)
                    return completion(nil)
                }
            }
    }
}

extension APIRequestable where Response: Decodable {
    // Decoding 로직은 Response type이 Decodable한지, 그냥 Binary Data인지에 따라 달라짐.
    // type constraint를 사용해서 default를 다르게 구현
    func decode(_ data: Data) -> Response? {
        do {
            return try JSONDecoder().decode(Response.self, from: data)
        } catch {
            SystemLog.fault(error.localizedDescription)
            return nil
        }
    }
}

extension APIRequestable where Response == Data {
    func decode(_ data: Data) -> Response? {
        return data
    }
}

extension URLComponents {
    static let onbanBaseURLComponents: Self = {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban"
        return components
    }()
}
