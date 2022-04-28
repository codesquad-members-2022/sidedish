//
//  DetailRepository.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/25.
//

import Foundation

enum DetailRespositoryError: Error{
    case fetchError
}

protocol ProductDetailRepository {
    func fetchOne(id: UniqueID, completion: @escaping (Result<Product, DetailRespositoryError>) -> Void)
}

final class MockDetailRepository: ProductDetailRepository {
    // var detailFactory = DetailFactory()
    
    init() {
        //self.products = MockProductFactory(makeCount: 10).makeRandomProducts()
    }
    
    func fetchOne(id: UniqueID, completion: @escaping (Result<Product, DetailRespositoryError>) -> Void) {
//        guard let result = Result else {
//            return completion(.failure(.fetchError))
//        }
//        completion(.success(result))
    }
}
