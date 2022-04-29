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
        // fetchNow는 Repository를 통해서 함. 그래서 얘는 Repository를 알아야함.
        // repository로부터 fetchNow를 하면, entity를 받는다.
        // 여기서 entity를 모델로 변경해주는 역할..
        repository.fetch { entity in // entity: HomeResponseData
            var homeModelList = [HomeModel]()
            for data in entity.body {
                let discountedPrice = data.nPrice
                let specialMessage = data.badge ?? [String]()
                
                var message = ""
                for msg in specialMessage {
                    message.append(msg)
                }
                
                homeModelList.append(HomeModel(image: data.image,
                                               name: data.title,
                                               description: data.description,
                                               discountedPrice: discountedPrice,
                                               originalPrice: data.sPrice,
                                               specialMessage: message))
            }
            print("ModelList", homeModelList)
            onCompleted(homeModelList) // model로 전달.
        }
    }
}
