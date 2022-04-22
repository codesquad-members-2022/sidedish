//
//  ProductCollectionViewModel.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation
import UIKit.UIImage
import UIKit
// This is going to represent single viewModel that drives productCollectionView

struct CategorySectionViewModel {
    var type: ProductType
    var productVM: [ProductCellViewModel]
}

struct ProductCollectionViewModel {

    private let categoryManager = CategoryManager()
    private var imageCache = NSCache<NSURL, UIImage>()

    public var cellViewModels: Observable<[CategorySectionViewModel]> = Observable<[CategorySectionViewModel]>([])

    func countProduct(section: Int) -> Int {
        self.cellViewModels.value[section].productVM.count
    }

    func countSection() -> Int {
        self.cellViewModels.value.count
    }

    subscript(_ indexPath: IndexPath) -> ProductCellViewModel? {
        let categoryVM = cellViewModels.value[indexPath.section]
        return categoryVM.productVM[indexPath.item]
    }

    func fetchCategories() {
        var temp = [CategorySectionViewModel]()

        let dispatchGroup = DispatchGroup()

        for type in ProductType.allCases {
            dispatchGroup.enter()

            categoryManager.fetchCategory(of: type) { category in
                let productCellVMs = category.product.compactMap { product in
                    ProductCellViewModel(product: product)
                }
                
                let categorySectionVM = CategorySectionViewModel(type: type, productVM: productCellVMs)
                
                temp.append(categorySectionVM)

                dispatchGroup.leave()
            }
        }

        dispatchGroup.notify(queue: .global(), work: DispatchWorkItem {
            cellViewModels.value = temp
        })
    }

    func fetchImage(from url: URL, then completion: @escaping (UIImage?) -> Void) {
        if let image = imageCache.object(forKey: url as NSURL) {
            return completion(image)
        }

        categoryManager.fetchImageData(of: url) { data in
            guard let data = data, let image = UIImage(data: data) else {
                return completion(nil)
            }
            imageCache.setObject(image, forKey: url as NSURL)
            completion(image)
        }
    }
}
