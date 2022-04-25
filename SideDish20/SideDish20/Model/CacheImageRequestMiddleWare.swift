//
//  CacheImageRequestMiddleWare.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheImageRequestMiddleWare {
    func getAllImageDataCached(completionHandler: @escaping ([Data]?) -> Void) {
        let result = RepositoryCommons.shared.getAllFilesCached()
        
        do {
            let dtoArray = try result.get()
            completionHandler(dtoArray)
        } catch {
            completionHandler(nil)
        }
    }
    
    func getImageDataCached(as name: String, completionHandler: @escaping (Data?) -> Void) {
        let result = RepositoryCommons.shared.getFileCached(as: name)
        
        do {
            let dto = try result.get()
            completionHandler(dto)
        } catch {
            completionHandler(nil)
        }
    }
}
