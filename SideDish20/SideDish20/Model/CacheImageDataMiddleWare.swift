//
//  CacheImageDataMiddleWare.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheImageDataMiddleWare {
    func cacheImage(as name: String, contentsOf image: Data) {
        RepositoryCommons.shared.cachingFile(as: name, contentsOf: image)
    }
}
