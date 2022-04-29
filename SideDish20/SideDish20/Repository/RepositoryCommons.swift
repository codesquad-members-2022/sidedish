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
    
    // Repository는 JSON을 받아서, Entity로 만들어서 전달.
    func fetch(onCompleted: @escaping (HomeResponseData) -> Void) {
        let urlString = CommonURLManager.Endpoint.main.endpoint
        guard let url = URL(string: urlString) else { return }
        
        URLSession.shared.dataTask(with: url) { data, _, _ in
            guard let data = data else { return }
            guard let model = try? JSONDecoder().decode(HomeResponseData.self, from: data) else { return }
            onCompleted(model)
        }.resume()
    }
}
