//
//  HomeDataFetchModel.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

class HomeDataFetchModel {
    var repository = RepositoryCommons.shared
    
    func getMainData(onComplete: @escaping (HomeResponseData?) -> Void) {
        repository.fetchAll { data in
            guard let data = data else { return }
            
            do {
                let decoder = JSONDecoder()
                let responseData = try decoder.decode(HomeResponseData.self, from: data)

                if responseData.statusCode == 200 {
                    onComplete(responseData)
                } else {
                    onComplete(nil)
                }
            } catch {
                onComplete(nil)
            }
        }
    }
}
