//
//  DetailViewModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/29.
//

import Foundation
import UIKit

class DetailViewModel {
    private var onUpdated: (HomeDetailModel) -> Void
    private var hash: String
    
    private let service = DataFetchService()
    private let cacheVM = CacheViewModel()
    
    init(hash: String, onUpdated: @escaping (HomeDetailModel) -> Void) {
        self.hash = hash
        self.onUpdated = onUpdated
    }
    
    private(set) var homeDetailModel: HomeDetailModel? {
        didSet {
            if let homeDetailModel = homeDetailModel {
                onUpdated(homeDetailModel)
            }
        }
    }
    
    var topImages: Observable<[UIImage]> = Observable([])
    
    var detailSectionImages: Observable<[UIImage]> = Observable([])
    
    // 데이터 패치 -> Logic에게 요청. 그러려면 viewModel은 Service를 갖고있어야함.
    func reload() {
        service.fetchDetail(hash: hash) { [weak self] model in
            guard let self = self else { return }
            self.homeDetailModel = model
            
            self.topImages.value.removeAll()
            self.cacheVM.getImage(from: model.topImage) { image in
                if let image = image {
                    self.topImages.value.append(image)
                }
                
                for urlString in model.thumbImages {
                    self.cacheVM.getImage(from: urlString) { image in
                        if let image = image {
                            self.topImages.value.append(image)
                        }
                    }
                }
            }
            
            self.detailSectionImages.value.removeAll()
            for urlString in model.detailSection {
                self.cacheVM.getImage(from: urlString) { image in
                    if let image = image {
                        self.detailSectionImages.value.append(image)
                    }
                }
            }
        }
    }
    
    func setPrice(quantity: Int) -> String {
        guard var priceString = homeDetailModel?.prices.last else {
            return "0원"
        }
        
        priceString = priceString.filter({("0"..."9").contains($0)})
        
        guard var priceFiltered = Int(priceString) else {
            return "0원"
        }
        
        priceFiltered *= quantity
        
        let formatter = NumberFormatter()
        formatter.numberStyle = .currency
        
        var result = formatter.string(from: priceFiltered as NSNumber) ?? "0원"
        
        if let symbol = result.first, ("0"..."9").contains(symbol) == false {
            result.removeFirst()
        }
        
        return result
    }
}
