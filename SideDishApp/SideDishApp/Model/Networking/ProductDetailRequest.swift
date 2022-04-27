//
//  ProductDetailRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

struct ProductDetailRequest: APIRequestable {
    typealias Response = ProductDetailResponse
    var url: URL
    var method: HTTPMethod = .get

    init?(from hash: String) {
        var components = URLComponents.onbanBaseURLComponents
        components.path += "/detail/\(hash)"

        guard let url = components.url else { return nil }
        self.url = url
    }
}
