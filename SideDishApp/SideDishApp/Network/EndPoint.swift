//
//  EndPoint.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

import Foundation

protocol Endpointable {
    func getHttpMethod() -> HTTPMethod
    func getBaseURL() -> BaseURL
    func getPath() -> Path
    func getHeaders() -> [String: Any]?
    func getBody() -> [String: Any]?
}

extension Endpointable {
    func getURL() -> String { return getBaseURL().urlString + getPath().pathString }
}

struct Endpoint: Endpointable {
    private let httpMethod: HTTPMethod
    private let baseURL: BaseURL
    private let path: Path
    private let headers: [String: Any]?
    private let body: [String: Any]?
    
    init(httpMethod: HTTPMethod, baseURL: BaseURL, path: Path, headers: [String: Any]?, body: [String: Any]? = nil) {
        self.httpMethod = httpMethod
        self.baseURL = baseURL
        self.path = path
        self.headers = headers
        self.body = body
    }
    
    func getHttpMethod() -> HTTPMethod {
        return self.httpMethod
    }
    
    func getBaseURL() -> BaseURL {
        return self.baseURL
    }
    
    func getPath() -> Path {
        return self.path
    }
    
    func getHeaders() -> [String: Any]? {
        return self.headers
    }
    
    func getBody() -> [String: Any]? {
        return self.body
    }
}

enum EndPointCase {
    case get(category: Category)
    case getDetail(hash: String)
    
    var endpoint: Endpointable {
        switch self {
        case .get(let category):
            return Endpoint(httpMethod: .get,
                            baseURL: .main,
                            path: .get(category: category),
                            headers: ["Content-Type": "application/json"],
                            body: nil)
            
        case .getDetail(let hash):
            return Endpoint(httpMethod: .get,
                            baseURL: .main,
                            path: .getDetail(hash: hash),
                            headers: ["Content-Type": "application/json"],
                            body: nil)
        }
    }
}

enum BaseURL {
    case main
    
    var urlString: String {
        switch self {
        case .main:
            return "https://api.codesquad.kr/onban/"
        }
    }
}

enum Path {
    case get(category: Category)
    case getDetail(hash: String)
    case post
    
    var pathString: String {
        switch self {
        case .get(let category):
            return "\(category)"
        case .getDetail(let hash):
            return "detail/\(hash)"
        case .post:
            return "main"
        }
    }
}

enum Category {
    case main
    case soup
    case side
}
