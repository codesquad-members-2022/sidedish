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
    func fetchOne(id: Int, completion: @escaping (Result<Product, DetailRespositoryError>) -> Void)
}

final class MockDetailRepository: ProductDetailRepository {
    init() {
    }
    
    func fetchOne(id: Int, completion: @escaping (Result<Product, DetailRespositoryError>) -> Void) {
    }
}
