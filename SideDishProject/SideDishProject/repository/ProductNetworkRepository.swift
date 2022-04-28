//
//  ProductNetworkRepository.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/28.
//

import Foundation

struct ProductNetworkRepository: ProductRepository{
    private var service: ProductAPIUseable?
    init(service: ProductAPIUseable){
        self.service = service
    }
    
    func fetchAll(completion: @escaping (Result<[DishCategory : [Product]], ProductRepositoryError>) -> Void) {
        service?.getCategories(completion: { result in
            switch result{
            case .success(let categories):
                for category in categories{
                    service?.getProducts(categoryId: category.id, completion: { result in
                        
                    })
                }
            case .failure(let error): break
                
            }
            
        })
    }
    
    func fetchImage(completion: @escaping (Result<[DishCategory : [Data?]], ProductRepositoryError>) -> Void) {
        
    }
    
    
}
