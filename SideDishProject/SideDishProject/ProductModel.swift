//
//  ProductViewModel.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/21.
//

import Foundation

final class ProductModel{

    private let repository: ProductRepository
    weak var delegate: ProductModelDelegate?
    
    init(repository: ProductRepository){
        self.repository = repository
    }
    
    func getAll(){
        repository.fetchAll { [weak self] result in
            guard let self = self else { return }
            switch result{
            case .success(let products):
                self.makeAllDishes(products: products)
            case .failure(let error):
                self.delegate?.updateFail(error: error)
            }
        }
    }
    
    private func makeAllDishes(products: [Product]){
        var dishes: [DishCategory : [Product]] = [:]
        dishes[.main] = products.filter{$0.category == .main}
        dishes[.soup] = products.filter{$0.category == .soup}
        dishes[.side] = products.filter{$0.category == .side}
        delegate?.updateAllDishes(dishes: dishes)
        delegate?.updateDishComment(comments: [DishCategory.main.comment, DishCategory.soup.comment, DishCategory.side.comment])
    }
}

protocol ProductModelDelegate: AnyObject{
    func updateDishComment(comments: [String])
    func updateAllDishes(dishes: [DishCategory : [Product]])
    func updateFail(error: Error)
}
