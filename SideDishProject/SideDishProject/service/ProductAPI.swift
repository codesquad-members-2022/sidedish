//
//  CategoryAPI.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/28.
//

import Foundation

enum ProductAPI{
    static let baseURL = "http://3.38.240.18:8080/"
    
    case categories
    case products(categoryId: Int)
    
    var url: URL? {
        switch self{
        case .categories:
            return URL(string: Self.baseURL + "categories")
        case .products(let categoryId):
            return URL(string: Self.baseURL + "products?categoryId=\(categoryId)")
        }
    }
    
    var method: String {
        switch self{
        case .categories, .products:
            return "GET"
        }
    }
}
