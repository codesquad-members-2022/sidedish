//
//  CategoryRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

struct CategoryRequest: APIRequest {
    typealias Response = CategoryResponse
    var url: URL
    var method: HTTPMethod = .get

    init?(from type: CategoryType) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/\(type)"

        guard let url = components.url else { return nil }
        self.url = url
    }
}
