//
//  RepositoryCommons.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class RepositoryCommons {
    
    static let repository = RepositoryCommons()
    
    private let getFileService = GetFileURLService()
    private let saveFileService = SaveFileService()
    
    func cachingFile(as name: String, contentsOf data: Data) {
        DispatchQueue.global(qos: .utility).async { [weak self] in
            guard let self = self else { return }
            self.saveFileService.saveFile(as: name, contentsOf: data)
        }
    }
    
    func cachingFiles(parameters: [FileDTO]) {
        DispatchQueue.global(qos: .userInteractive).async { [weak self] in
            guard let self = self else { return }
            for param in parameters {
                self.saveFileService.saveFile(as: param.name, contentsOf: param.data)
            }
        }
    }
    
    func getAllFilesCached(completionHandler: @escaping ([FileDTO]) -> Void) {
        DispatchQueue.global(qos: .userInteractive).async { [weak self] in
            guard let self = self else { return }
            let allDTO = self.getFileService.fetchCachedFiles()
            completionHandler(allDTO)
        }
    }
}

struct FileDTO {
    let name: String
    let data: Data
}
