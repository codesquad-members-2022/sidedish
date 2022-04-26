//
//  Endpoint.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/26.
//

import Foundation

protocol Endpoint {
    var url: URL? { get }
}

protocol JSONEndpoint {
    associatedtype DecodingType: Decodable
}

struct ProductDetailEndPoint: Endpoint & JSONEndpoint {
    typealias DecodingType = ProductDetailResponse
    private var components: URLComponents?
    var url: URL? { components?.url }

    init(from hash: String) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/detail/\(hash)"
        self.components = components
    }
 }

struct CategoryEndpoint: Endpoint & JSONEndpoint {
    typealias DecodingType = ProductsSummaryResponse
    private var components: URLComponents?
    var url: URL? { components?.url }

    init(from type: CategoryType) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/\(type)"
        self.components = components
    }
}

struct ImageEndPoint: Endpoint {
    private var components: URLComponents?
    var url: URL? { components?.url }

    init(url: URL) {
        self.components = URLComponents(url: url, resolvingAgainstBaseURL: false)
        components?.scheme = "https"
    }

    init(fileName: String, fileExtension: String) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "public.codesquad.kr"
        components.path = "/jk/storeapp/data/main/\(fileName).\(fileExtension)"
        self.components = components
    }
}
