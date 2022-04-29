//
//  Network.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/28.
//

import Foundation

protocol ProductAPIUseable{
    func getCategories(completion: @escaping(Result<[CategoryDTO], ProductRepositoryError>) -> Void)
    func getProducts(categoryId: Int, completion: @escaping(Result<[ProductDTO], ProductRepositoryError>) -> Void)
}

struct ProductService{
    let session = URLSession.shared
    func requestAPI<T: Decodable>(api: ProductAPI, decodeType: T.Type,completion: @escaping(Result<T ,ProductRepositoryError>) -> Void){
        guard let url = api.url else {
            return completion(.failure(.invalidURL))
        }
        var urlRequest = URLRequest(url: url)
        
        urlRequest.httpMethod = api.method
        urlRequest.addValue("application/json", forHTTPHeaderField: "Content-Type")
        let task = session.dataTask(with: urlRequest) { data, response, error in
            if error != nil {
                return completion(.failure(.notConnect))
            }
            
            guard let httpURLResponse = response as? HTTPURLResponse else {
                return completion(.failure(.httpResponse))
            }
            
            guard (200...299) ~= httpURLResponse.statusCode else {
                return completion(.failure(.httpURLResponse))
            }
            
            guard let data = data else {
                return completion(.failure(.nilDataInSession))
            }
            
            guard let decodedData = try? jsonDecode(data: data, decodeType: T.self) else {
                return completion(.failure(.notConvertdecode))
            }
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
}

extension ProductService: ProductAPIUseable {
    func getCategories(completion: @escaping (Result<[CategoryDTO], ProductRepositoryError>) -> Void) {
        requestAPI(api: .categories, decodeType: [CategoryDTO].self) { result in
            switch result{
            case .success(let categories):
                completion(.success(categories))
            case .failure(let error):
                completion(.failure(error))
            }
        }
    }
    
    func getProducts(categoryId: Int, completion: @escaping (Result<[ProductDTO], ProductRepositoryError>) -> Void) {
        requestAPI(api: .products(categoryId: categoryId), decodeType: [ProductDTO].self) { result in
            switch result{
            case .success(let products):
                completion(.success(products))
            case .failure(let error):
                completion(.failure(error))
            }
        }
    }
}


