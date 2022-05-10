//
//  ImageNetworkManager.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/29.
//

import Foundation
import UIKit.UIImage

struct ImageNetworkManager: NetworkManagable {
    
    private let cache = NSCache<NSString, UIImage>()
    
    var session: URLSession
    
    static let shared = ImageNetworkManager(session: .shared)
    
    private init(session: URLSession) {
        self.session = session
    }
    
    func request<T>(endpoint: Endpointable, completion: @escaping ((Result<T?, NetworkError>) -> Void)) {
        
        guard let cacheDirectoryPath = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return }
        print(cacheDirectoryPath)
        
        guard let url = endpoint.getURL() else {
            return completion(.failure(.invalidURL))
        }
        
        // CheckMemory
        if let image = findImageInMemoryCache(from: url) {
            return completion(.success(image as? T))
        }
        
        // CheckDisk
        if let image = findImageInDiskCache(from: url) {
            self.cache.setObject(image, forKey: url.lastPathComponent as NSString)
            print(image)
            return completion(.success(image as? T))
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
                guard let imageData = try? Data(contentsOf: filePath),
                      let image = UIImage(data: imageData) else { return }
                self.cache.setObject(image, forKey: imageName as NSString)
                return completion(.success(image as? T))
            }
            
        }
        dataTask.resume()
    }
    
    private func findImageInMemoryCache(from url: URL) -> UIImage? {
        let cacheKey = NSString(string: url.lastPathComponent)
        let cachedImage = self.cache.object(forKey: cacheKey)
        return cachedImage
    }
    
    private func findImageInDiskCache(from url: URL) -> UIImage? {
        let fileManager = FileManager()
        guard let path = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return nil }
        var filePath = URL(fileURLWithPath: path)
        filePath.appendPathComponent(url.lastPathComponent)
        
        if fileManager.fileExists(atPath: filePath.path) {
            guard let imageData = try? Data(contentsOf: filePath) else { return nil }
            return UIImage(data: imageData)
        }
        return nil
    }
}
