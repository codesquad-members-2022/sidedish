//
//  GetFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

final class GetFileURLService: CacheFileManagerAttribute {
    
    func fetchFile(as name: String) -> Result<Data, CacheError> {
        if let data = getContent(name: name) {
            return .success(data)
        }
        
        return .failure(.fileNotExistError("FilePath error. \(name)"))
    }
    
    func fetchCachedFiles() -> Result<[Data], CacheError> {
        
        if let result = getContentsCache() {
            return .success(result)
        }
        
        let cacheDir = getCacheDirPath()?.absoluteString
        
        return .failure(.fileNotExistError("FilePath error. \(cacheDir ?? "Cache Directory Error.")"))
    }
}
