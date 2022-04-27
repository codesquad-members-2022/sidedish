//
//  ImageRequest.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/27.
//

import Foundation
import Alamofire

struct ImageRequest: APIRequestable {
    typealias Response = Data
    var url: URL
    var method: HTTPMethod = .get

    init?(url: URL) {
        var components = URLComponents(url: url, resolvingAgainstBaseURL: false)
        components?.scheme = "https"

        guard let url = components?.url else { return nil }
        self.url = url
    }

    init?(fileName: String, fileExtension: String) {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "public.codesquad.kr"
        components.path = "/jk/storeapp/data/main/\(fileName).\(fileExtension)"

        guard let url = components.url else { return nil }
        self.url = url
    }

    func decode(_ data: Data) -> Response? {
        return data
    }
}
