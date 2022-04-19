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
        DispatchQueue.global(qos: .utility).async {
            self.saveFileService.saveFile(as: name, contentsOf: data)
        }
    }
    
    func cachingFiles(parameters: [FileDTO]) {
        DispatchQueue.global(qos: .userInteractive).async {
            for param in parameters {
                self.saveFileService.saveFile(as: param.name, contentsOf: param.data)
            }
        }
    }
    
    func getAllFilesCached(completionHandler: @escaping ([FileDTO]?) -> Void) {
        DispatchQueue.global(qos: .userInteractive).async {
            let allDTO = self.getFileService.fetchCachedFiles()
            
            guard allDTO.count > 0 else {
                completionHandler(nil)
                return
            }
            
            completionHandler(allDTO)
        }
    }
    
    func getFileCached(as name: String, completionHandler: @escaping (FileDTO?) -> Void) {
        DispatchQueue.global(qos: .userInteractive).async {
            guard let url = self.getFileService.fetchFile(as: name), let data = try? Data(contentsOf: url) else {
                completionHandler(nil)
                return
            }
            
            completionHandler(FileDTO(name: name, data: data))
        }
    }
}

struct FileDTO {
    let name: String
    let data: Data
}
