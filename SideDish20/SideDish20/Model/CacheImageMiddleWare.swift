//
//  CacheImageModel.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheImageModel: SideDishModel {
    
    let repository: RepositoryCommons = RepositoryCommons.shared
    
    func callCacheSystem(userInfo: [String: Any]?) -> Any? {
        
        if let name = userInfo?["name"] as? String, let data = userInfo?["data"] as? Data {
            cacheImage(as: name, contentsOf: data)
            return data
        }
        
        return nil
    }
    
    private func cacheImage(as name: String, contentsOf image: Data) {
        repository.cachingFile(as: name, contentsOf: image)
    }
}
