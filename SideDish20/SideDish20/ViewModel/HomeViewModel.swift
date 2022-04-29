//
//  HomeViewModel.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

class HomeViewModel {
    var onUpdated: () -> Void = {}
    
    let service = DataFetchService()
    
    var homeSubViewModel: [HomeModel]? = [HomeModel(image: "img01",
                                                 name: "뜨끈한 국밥",
                                                 description: "아주 따뜻해유",
                                                 discountedPrice: "12,370원",
                                                 originalPrice: "18,380원",
                                                 specialMessage: "이벤트특가")] {
        didSet {
            onUpdated()
        }
    }
    
    // 데이터 패치 -> Logic에게 요청. 그러려면 viewModel은 Service를 갖고있어야함.
    func reload() {
        service.fetch { [weak self] model in
            guard let self = self else { return }
            self.homeSubViewModel = model
        }
    }
}
