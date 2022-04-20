//
//  CategoryManager.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/20.
//

import Foundation

struct CategoryManager {
    let networkManager = NetworkManager()
    
    func fetchCategory(of type: ProductType, then completion: @escaping (Category) -> Void) {
        networkManager.fetchProducts(of: type) { result in
            switch result {
            case .success(let products):
                completion(Category(product: products, type: type))
            case .failure(let error):
                SystemLog.fault(error.localizedDescription)
            }
        }
    }
}
