//
//  CategoryManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation

struct CategoryManager {
    let networkManager = NetworkManager()

    func fetchCategory(of type: CategoryType, then completion: @escaping (Category?) -> Void) {
        let endpoint = EndpointFactory.make(categoryType: type)
        networkManager.fetch(endpoint) { data in
            guard let data = data else {
                return completion(nil)
            }
            completion(Category(product: data.body, type: type))
        }
    }

    func fetchImageData(of url: URL, then completion: @escaping (Data?) -> Void) {
        let endpoint = EndpointFactory.make(imageURL: url)
        networkManager.fetch(endpoint) { data in
            completion(data)
        }
    }

    func fetchDetail(of hash: String, then completion: @escaping (ProductDetail?) -> Void) {
        let endpoint = EndpointFactory.make(detailHash: hash)
        networkManager.fetch(endpoint) { productReponse in
            completion(productReponse?.data)
        }
    }
}
