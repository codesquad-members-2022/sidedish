//
//  CacheImageRequestMiddleWare.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheImageRequestMiddleWare {
    func getAllImageDataCached(completionHandler: @escaping ([FileDTO]?) -> Void) {
        RepositoryCommons.shared.getAllFilesCached { result in
            guard let result = result else {
                completionHandler(nil)
                return
            }
            
            completionHandler(result)
        }
    }
    
    func getImageDataCached(as name: String, completionHandler: @escaping (FileDTO?) -> Void) {
        RepositoryCommons.shared.getFileCached(as: name) { result in
            guard let result = result else {
                completionHandler(nil)
                return
            }
            
            completionHandler(result)
        }
    }
}
