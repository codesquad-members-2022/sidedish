//
//  CacheImageRequestMiddleWare.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheImageRequestMiddleWare: SideDishMiddleWare {
    
    let repository: RepositoryCommons = RepositoryCommons.shared
    
    func callCacheSystem(userInfo: [String: Any]?) -> Any? {
        if let name = userInfo?["name"] as? String {
            return getImageDataCached(as: name)
        } else {
            return getAllImageDataCached()
        }
    }
    
    private func getAllImageDataCached() -> [Data]? {
        do {
            return try repository.getAllFilesCached().get()
        } catch {
            return nil
        }
    }
    
    private func getImageDataCached(as name: String) -> Data? {
        do {
            return try repository.getFileCached(as: name).get()
        } catch {
            return nil
        }
    }
}
