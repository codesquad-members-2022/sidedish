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
    private let cacheVM = DishViewModel()
    
    init(hash: String, onUpdated: @escaping (HomeDetailModel) -> Void) {
        self.hash = hash
        self.onUpdated = onUpdated
    }
    
    private var homeDetailModel: HomeDetailModel? {
        didSet {
            if let homeDetailModel = homeDetailModel {
                onUpdated(homeDetailModel)
            }
        }
    }
    
    private var topImages = [UIImage]()
    private var detailSectionImages = [UIImage]()
    
    // 데이터 패치 -> Logic에게 요청. 그러려면 viewModel은 Service를 갖고있어야함.
    func reload() {
        service.fetchDetail(hash: hash) { [weak self] model in
            guard let self = self else { return }
            self.homeDetailModel = model
            
            self.topImages.removeAll()
            self.cacheVM.getImage(from: model.topImage) { image in
                if let image = image {
                    self.topImages.append(image)
                }
                
                for urlString in model.thumbImages {
                    self.cacheVM.getImage(from: urlString) { image in
                        if let image = image {
                            self.topImages.append(image)
                        }
                    }
                }
            }
            
            self.detailSectionImages.removeAll()
            for urlString in model.detailSection {
                self.cacheVM.getImage(from: urlString) { image in
                    if let image = image {
                        self.detailSectionImages.append(image)
                    }
                }
            }
        }
    }
}
