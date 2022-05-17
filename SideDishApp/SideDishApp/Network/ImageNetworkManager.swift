//
//  ImageNetworkManager.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/29.
//

import Foundation

struct ImageNetworkManager: NetworkManagable {
    
    private let cache = NSCache<NSString, NSData>()
    
    var session: URLSession
    
    static let shared = ImageNetworkManager(session: .shared)
    
    init(session: URLSession) {
        self.session = session
    }
    
    func request<T>(endpoint: Endpointable, completion: @escaping ((Result<T?, NetworkError>) -> Void)) {
        
        guard let cachepath = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return }
        
        print(cachepath)
        
        guard let url = endpoint.getURL() else {
            return completion(.failure(.invalidURL))
        }
        
        // CheckMemory
        if let imageNSData = findImageDataInMemoryCache(from: url) {
            let imageData = Data(referencing: imageNSData)
            return completion(.success(imageData as? T))
        }
        
        // CheckDisk
        if let imageNSData = findImageInDiskCache(from: url) {
            self.cache.setObject(imageNSData, forKey: url.lastPathComponent as NSString)
            let imageData = Data(referencing: imageNSData)
            return completion(.success(imageData as? T))
        }
        
        // Request to Server
        var urlRequest = URLRequest(url: url)
        
        // HTTP Method
        let httpMethod = endpoint.getHttpMethod().description
        urlRequest.httpMethod = httpMethod
        
        // HTTP header
        let headers = endpoint.getHeaders()
        headers?.forEach { urlRequest.setValue($1 as? String, forHTTPHeaderField: $0) }
        
        dataTask(urlRequest: urlRequest, completion: completion)
    }
    
    func dataTask<T>(urlRequest: URLRequest, completion: @escaping ((Result<T?, NetworkError>) -> Void)) {
        
        let dataTask = session.downloadTask(with: urlRequest) { location, response, error in
            
            // handling transportError
            if let error = error {
                return completion(.failure(.transportError(error)))
            }
            
            // handling NoDataError
            if location == nil {
                return completion(.failure(.emptyLocation))
            }
            
            // handling ServerError
            guard let statusCode = self.getStatusCode(response: response) else { return }
            guard 200..<300 ~= statusCode else {
                return completion(.failure(.invalidResponse(statusCode: statusCode)))
            }
            
            // DownLoad Image and move to FinalDestination
            let fileManager = FileManager.default
            let tempPath = location?.path ?? ""
            
            guard let cacheDirectoryPath = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return }
            
            let imageName = urlRequest.url?.lastPathComponent ?? ""
            
            let finalPath = cacheDirectoryPath + "/" + imageName
            
            try? fileManager.moveItem(atPath: tempPath, toPath: finalPath)
            
            var filePath = URL(fileURLWithPath: cacheDirectoryPath)
            
            filePath.appendPathComponent(imageName)
            
            if fileManager.fileExists(atPath: finalPath) {
                guard let imageNSData = NSData(contentsOf: filePath) else { return }
                self.cache.setObject(imageNSData, forKey: imageName as NSString)
                
                let imageData = Data(referencing: imageNSData)
                return completion(.success(imageData as? T))
            }
            
        }
        dataTask.resume()
    }
    
    private func findImageDataInMemoryCache(from url: URL) -> NSData? {
        let cacheKey = NSString(string: url.lastPathComponent)
        let cachedImageData = self.cache.object(forKey: cacheKey)
        return cachedImageData
    }
    
    private func findImageInDiskCache(from url: URL) -> NSData? {
        let fileManager = FileManager()
        guard let path = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return nil }
        var filePath = URL(fileURLWithPath: path)
        filePath.appendPathComponent(url.lastPathComponent)
        
        if fileManager.fileExists(atPath: filePath.path) {
            let imageData = NSData(contentsOf: filePath)
            return imageData
        }
        return nil
    }
}
