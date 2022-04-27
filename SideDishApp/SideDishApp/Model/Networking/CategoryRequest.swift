//
//  CategoryRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

struct CategoryRequest: APIRequestable {
    typealias Response = CategoryResponse
    var url: URL
    var method: HTTPMethod = .get

    init?(from type: CategoryType) {
        var components = URLComponents.onbanBaseURLComponents
        components.path += "/\(type)"

        guard let url = components.url else { return nil }
        self.url = url
    }
}
