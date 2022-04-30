//
//  DataFetchService.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/27.
//

import Foundation

class DataFetchService: CommonURLManager {
    
    let repository = RepositoryCommons()
    
    func fetch(onCompleted: @escaping ([HomeModel]) -> Void) {
        repository.fetch { entity in
            var homeModelList = [HomeModel]()
            for data in entity.body {
                let discountedPrice = data.nPrice
                let specialMessage = data.badge ?? [String]()
                
                var message = ""
                for msg in specialMessage {
                    message.append(msg)
                    message.append(" ")
                }
                
                homeModelList.append(HomeModel(sideDishKey: data.detailHash,
                                               image: data.image,
                                               name: data.title,
                                               description: data.description,
                                               discountedPrice: discountedPrice,
                                               originalPrice: data.sPrice,
                                               specialMessage: message))
            }
            onCompleted(homeModelList)
        }
    }
    
    func fetchDetail(hash: String, onCompleted: @escaping (HomeDetailModel) -> Void) {
        repository.fetchDetail(hash: hash) { entity in
            onCompleted(entity.data)
        }
    }
}
