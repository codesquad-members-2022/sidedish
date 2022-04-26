//
//  ProductViewModel.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/21.
//

import Foundation

final class HomeUsecase{

    private let repository: ProductRepository
    private var selectedIndex: IndexPath?
    weak var delegate: ProductModelDelegate?
    private var dishes: [DishCategory : [Product]] = [:]
    
    init(repository: ProductRepository){
        self.repository = repository
    }
    
    func setSelectedIndex(indexPath: IndexPath){
        self.selectedIndex = indexPath
        guard let selectedProduct = dishes[DishCategory.dishKind(section: indexPath.section)]?[indexPath.row] else { return }
        delegate?.selected(id: selectedProduct.id)
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
    func selected(id: UniqueID)
}
