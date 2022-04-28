//
//  Network.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/28.
//

import Foundation

protocol ProductAPIUseable{
    func getCategories(completion: @escaping(Result<[DishCategory], ProductRepositoryError>) -> Void)
    func getProducts(categoryId: Int, completion: @escaping(Result<[Product], ProductRepositoryError>) -> Void)
}

struct ProductService{
    let session = URLSession.shared
    func requestAPI<T: Decodable>(api: ProductAPI, decodeType: T.Type,completion: @escaping(Result<T ,ProductRepositoryError>) -> Void){
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
            
            guard let decodedData = try? jsonDecode(data: data, decodeType: T.self) else { return }

            completion(.success(decodedData))
        }
        task.resume()
    }
    
    
    private func jsonDecode<T: Decodable>(data: Data, decodeType: T.Type) throws -> T {
        guard let decodeEntity = try? JSONDecoder().decode(decodeType.self, from: data) else {
            throw ProductRepositoryError.fetchError
        }
        return decodeEntity
    }
    
    private func dtoToEntity(){
        
    }
}
extension ProductService: ProductAPIUseable{
    func getCategories(completion: @escaping (Result<[DishCategory], ProductRepositoryError>) -> Void) {
        requestAPI(api: .categories, decodeType: [DishCategory].self) { result in
            switch result{
            case .success(let categories):
                print("categories: \(categories)")
                completion(.success(categories))
            case .failure(let error):
                completion(.failure(error))
            }
        }
    }
    
    func getProducts(categoryId: Int, completion: @escaping (Result<[Product], ProductRepositoryError>) -> Void) {
        requestAPI(api: .products, decodeType: [ProductDTO].self) { result in
            switch result{
            case .success(let products):
                print("pruducts: \(products)")
                print(products)
            case .failure(let error):
                print(error)
            }
        }
    }
}


