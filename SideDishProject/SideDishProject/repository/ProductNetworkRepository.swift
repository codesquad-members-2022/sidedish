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
            var dishes: [DishCategory : [Product]] = [:]
            switch result{
            case .success(let categories):
                var group = DispatchGroup()
                for categoryDTO in categories{
                    group.enter()
                    let category = categoryDTO.convertDTOtoEntity()
                    service?.getProducts(categoryId: categoryDTO.id, completion: { result in
                        switch result{
                        case .success(let products):
                            dishes[category] = products.map{$0.convertDTOtoEntity(category: category)}
                            group.leave()
                        case .failure(let error):
                            print(error)
                        }
                    })
                }
                let queueForGroup = DispatchQueue(label: "endQueue", attributes: .concurrent)
                group.notify(queue: queueForGroup) {
                    completion(.success(dishes))
                }
            case .failure(let error):
                print(error.localizedDescription)
            }
        })
    }
    
    func fetchImage(completion: @escaping (Result<[DishCategory : [Data?]] , ProductRepositoryError>) -> Void) {
    }
}
