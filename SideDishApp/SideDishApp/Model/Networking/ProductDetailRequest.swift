//
//  ProductDetailRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

struct ProductDetailRequest: APIRequest {
    typealias Response = ProductDetailResponse
    var url: URL
    var method: HTTPMethod = .get

    init?(from hash: String) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/detail/\(hash)"

        guard let url = components.url else { return nil }
        self.url = url
    }
}
