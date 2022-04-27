//
//  HomeViewModel.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

class HomeViewModel {
    var fetchOnComplete: (HomeResponseData?) -> Void
    let homeDataFetchModel = HomeDataFetchModel()
    
    init(fetchOnComplete: @escaping (HomeResponseData?) -> Void) {
        self.fetchOnComplete = fetchOnComplete
    }
    
    func fetchMain() {
        homeDataFetchModel.getMainData { data in
            self.fetchOnComplete(data)
        }
    }
}
