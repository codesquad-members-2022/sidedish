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
    
    func cachingFiles(parameters: [FileDTO]) {
        for param in parameters {
            self.saveFileService.saveFile(as: param.name, contentsOf: param.data)
        }
    }
    
    func getAllFilesCached(completionHandler: @escaping ([FileDTO]?) -> Void) {
        let allDTO = self.getFileService.fetchCachedFiles()
        
        guard allDTO.count > 0 else {
            completionHandler(nil)
            return
        }
        
        completionHandler(allDTO)
    }
    
    func getFileCached(as name: String, completionHandler: @escaping (FileDTO?) -> Void) {
        guard let dto = self.getFileService.fetchFile(as: name) else {
            completionHandler(nil)
            return
        }
        
        completionHandler(dto)
    }
}

struct FileDTO {
    let name: String
    let data: Data
}
