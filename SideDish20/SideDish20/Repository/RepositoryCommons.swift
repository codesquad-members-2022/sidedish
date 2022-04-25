//
//  RepositoryCommons.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class RepositoryCommons {
    
    static let shared = RepositoryCommons()
    
    private let getFileService = GetFileURLService()
    private let saveFileService = SaveFileService()
    
    func cachingFile(as name: String, contentsOf data: Data) {
        self.saveFileService.saveFile(as: name, contentsOf: data)
    }
    
    func cachingFiles(parameters: [String: Data]) {
        for param in parameters {
            self.saveFileService.saveFile(as: param.key, contentsOf: param.value)
        }
    }
    
    func getAllFilesCached() -> Result<[Data], CacheError> {
        return self.getFileService.fetchCachedFiles()
    }
    
    func getFileCached(as name: String) -> Result<Data, CacheError> {
        return self.getFileService.fetchFile(as: name)
    }
}
