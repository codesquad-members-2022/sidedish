//
//  APIRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

protocol APIRequest {
    associatedtype Response

    var url: URL { get }
    var method: HTTPMethod { get }
    var headers: [String: String] { get }
    var queryItems: [String: String] { get }

    func decode(_ data: Data) -> Response?
}

extension APIRequest {
    // Default Implementationg이 있기 때문에
    // Header, queryItem이 없을 경우 구현하지 않아도 됨
    var headers: [String: String] { [:] }
    var queryItems: [String: String] { [:] }
}

extension APIRequest where Response: Decodable {
    func decode(_ data: Data) -> Response? {
        do {
            return try JSONDecoder().decode(Response.self, from: data)
        } catch {
            SystemLog.fault(error.localizedDescription)
            return nil
        }
    }
}
