//
//  Network.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/28.
//

import Foundation

struct ProductService{
    
    let session = URLSession.shared
    
    func requestAPI(api: ProductAPI, completion: @escaping(Result<[DishCategory] ,ProductRepositoryError>) -> Void){
        guard let url = api.url else { return }
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = api.method
        urlRequest.addValue("application/json", forHTTPHeaderField: "Content-Type")
        let task = session.dataTask(with: urlRequest) { data, response, error in
            if error != nil {
                return completion(.failure(.fetchError))
            }
            
            guard let httpURLResponse = response as? HTTPURLResponse else {
                return completion(.failure(.fetchError))
            }
            
            guard (200...299) ~= httpURLResponse.statusCode else {
                return //completion(.failure(.fetchError(code: httpURLResponse.statusCode)))
            }
            
            guard let data = data else {
                return completion(.failure(.fetchError))
            }
            guard let categories = try? categoryDecode(categoryData: data) else {
                return completion(.failure(.fetchError))
            }
            
            completion(.success(categories))
        }
        task.resume()
    }
    
    private func categoryDecode(categoryData: Data) throws -> [DishCategory] {
        guard let categories = try? JSONDecoder().decode([DishCategory].self, from: categoryData) else {
            throw ProductRepositoryError.fetchError
        }
        return categories
    }
}
