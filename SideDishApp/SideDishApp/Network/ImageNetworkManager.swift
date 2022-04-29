//
//  ImageNetworkManager.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/29.
//

import Foundation
import UIKit.UIImage

// TODO: - NetworkManagerable 프로토콜 채택할 예정
final class ImageNetworkManager {
    private let cache = NSCache<NSString, UIImage>()
    
    var session: URLSession
    
    static let shared = ImageNetworkManager(session: .shared)
    
    private init(session: URLSession) {
        self.session = session
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
    
    func request(endpoint: Endpointable, completion: @escaping((Result<UIImage?, NetworkError>) -> Void)) {
        
        // TODO: - 데모를 위해 콘솔에 print함. 제거할 예정
        guard let cacheDirectoryPath = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return }
        print(cacheDirectoryPath)
        
        guard let url = endpoint.getURL() else {
            return completion(.failure(.invalidURL))
        }
        
        // CheckMemory
        if let image = findImageInMemoryCache(from: url) {
            print("Memory Cache HIT! image: \(image)")
            return completion(.success(image))
        }
        
        // CheckDisk
        if let image = findImageInDiskCache(from: url) {
            print("Disk Cache HIT! image: \(image)")
            self.cache.setObject(image, forKey: url.lastPathComponent as NSString)
            return completion(.success(image))
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
    
    func dataTask(urlRequest: URLRequest, completion: @escaping ((Result<UIImage?, NetworkError>) -> Void)) {
        
        let dataTask = session.downloadTask(with: urlRequest) { [weak self] location, response, error in
            guard let self = self else {
                return completion(.failure(.emptySession))
            }
            
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
                return completion(.success(image))
            }
            
        }
        dataTask.resume()
    }
    
    // TODO: - 프로토콜 extension으로 뺄 예정
    private func getStatusCode(response: URLResponse?) -> Int? {
        guard let httpResponse = response as? HTTPURLResponse else { return nil }
        return httpResponse.statusCode
    }
}
