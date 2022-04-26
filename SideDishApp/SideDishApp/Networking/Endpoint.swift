//
//  Endpoint.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/26.
//

import Foundation

protocol EndPoint {
    var url: URL? { get }
}

protocol JSONEndPoint {
    associatedtype DecodingType: Decodable
}

struct ProductEndPoint: EndPoint & JSONEndPoint {
    typealias DecodingType = ProductsResponse
    private var components: URLComponents?

    var url: URL? {
        components?.url
    }

    init(from type: ProductType) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "api.codesquad.kr"
        components.path = "/onban/\(type)"
        self.components = components
    }

}

struct ImageEndPoint: EndPoint {
    private var components: URLComponents?

    var url: URL? {
        components?.url
    }

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
