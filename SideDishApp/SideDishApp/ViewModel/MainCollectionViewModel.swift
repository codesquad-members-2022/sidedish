//
//  ProductCollectionViewModel.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation

// This is going to represent single viewModel that drives productCollectionView

struct CategorySectionViewModel {
    var type: CategoryType
    var productVMs: [ProductCellViewModel]
}

struct ProductCollectionViewModel {

    private let categoryManager = CategoryManager()
    private var imageCache = NSCache<NSURL, NSData>()
    var categoryVMs: [CategoryType: Observable<CategorySectionViewModel>]
    var headerHiddenStatus: [CategoryType: Bool]

    init () {
        let placeHolders = (0..<5).map({ _ in
            ProductCellViewModel.makePlaceHolder()
        })
        let placeHolderCategory =  CategorySectionViewModel(type: .main, productVMs: placeHolders)

        categoryVMs = [.main: Observable<CategorySectionViewModel>(placeHolderCategory),
                         .side: Observable<CategorySectionViewModel>(),
                        .soup: Observable<CategorySectionViewModel>()]

        headerHiddenStatus = [.main: true ,
                             .soup: true,
                            .side: true]

    }

    func countProduct(section: Int) -> Int {
        let targetType = CategoryType.allCases[section]
        guard let productVMs = categoryVMs[targetType]?.value?.productVMs else {return 0}
        return productVMs.count
    }

    func countSection() -> Int {
        self.categoryVMs.count
    }

    subscript(_ indexPath: IndexPath) -> ProductCellViewModel? {
        let targetType = CategoryType.allCases[indexPath.section]
        guard let productVMs = categoryVMs[targetType]?.value?.productVMs else {return nil}
        return productVMs[indexPath.item]
    }

    func fetchAllCategories() {
        CategoryType.allCases.forEach({
            fetchCategories(of: $0)
        })
    }

    private func fetchCategories(of type: CategoryType) {
        categoryManager.fetchCategory(of: type) { category in
            guard let category = category else {
                return
            }

            let productCellVMs = category.product.compactMap { product in
                ProductCellViewModel(product: product)
            }
            let categoryVM = CategorySectionViewModel(type: type, productVMs: productCellVMs)
            categoryVMs[type]?.value = categoryVM
        }
    }

    func fetchImage(from url: URL, then completion: @escaping (NSData?) -> Void) {
        if let image = imageCache.object(forKey: url as NSURL) {
            return completion(image)
        }

        categoryManager.fetchImageData(of: url) { data in
            guard let data = data as? NSData else {
                return completion(nil)
            }
            imageCache.setObject(data, forKey: url as NSURL)
            completion(data)
        }
    }
}
