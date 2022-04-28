//
//  ProductViewModel.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/21.
//

import Foundation

final class HomeUsecase{

    private let repository: ProductRepository
    private var selectedProduct: IndexPath?
    weak var delegate: ProductModelDelegate?
    private var dishes: [DishCategory : [Product]] = [:]
    
    init(repository: ProductRepository){
        self.repository = repository
    }
    
    func setSelectedIndex(indexPath: IndexPath){
        self.selectedProduct = indexPath
        for (index,dish) in dishes.enumerated() {
            if indexPath.section == index {
                let product = dish.value[indexPath.row]
                delegate?.selected(id: product.id)
                return
            }
        }
    }
    
    func getAll(){
        repository.fetchAll { [weak self] result in
            guard let self = self else { return }
            switch result{
            case .success(let products):
                let comments: [String] = products.compactMap{ $0.key.name }
                self.delegate?.updateDishComment(comments: comments)
                self.delegate?.updateAllDishes(dishes: products)
                self.updateImageData()
                self.dishes = products
            case .failure(let error):
                self.delegate?.updateFail(error: error)
            }
        }
    }
    
    private func updateImageData(){
        repository.fetchImage { result in
            switch result{
            case .success(let data):
                self.delegate?.updateImageData(imageData: data)
            case .failure(let error):
                self.delegate?.updateFail(error: error)
            }
        }
    }
}

protocol ProductModelDelegate: AnyObject{
    func updateDishComment(comments: [String])
    func updateAllDishes(dishes: [DishCategory : [Product]])
    func updateFail(error: Error)
    func updateImageData(imageData: [DishCategory : [Data?]])
    func selected(id: UniqueID)
}
