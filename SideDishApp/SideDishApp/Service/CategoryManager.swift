//
//  CategoryManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation

struct CategoryManager {
    let networkManager = NetworkManager()

    func fetchCategory(of type: ProductType, then completion: @escaping (Category?) -> Void) {
        networkManager.fetchProducts(of: type) { products in
            guard let products = products else { return completion(nil) }
            completion(Category(product: products, type: type))
        }
    }

    func fetchImageData(of url: URL, then completion: @escaping (Data?) -> Void) {
        networkManager.fetchImageData(url: url) { data in
            completion(data)
        }
    }

    func fetchDetail(of hash: String, then completion: @escaping (ProductDetail?) -> Void) {
        networkManager.fetchDetail(of: hash) { productDetail in
            completion(productDetail)
        }
    }
}
