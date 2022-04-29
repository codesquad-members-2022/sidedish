//
//  ImageNetworkManager.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/29.
//

import Foundation
import UIKit.UIImage

//TODO: - NetworkManagerable 프로토콜 채택할 예정
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
        print("key", cacheKey)
        print("image", cachedImage)
        
        return cachedImage
    }
    
    private func findImageInDiskCache(from url: URL) -> UIImage? {
            //2. Memory Cache에 없다 -> diskCache를 찾아봄
            let fileManager = FileManager()
            
            
            //Cache가 저장되는 path(Disk Caching)
            guard let path = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return nil }
//            print("캐쉬가 저장되는 폴더 path(String): \(path)")
            
            var filePath = URL(fileURLWithPath: path)
//            print("폴더 Path에서 file을 찾을 수 있는 Path(URL): \(filePath)")
        
            filePath.appendPathComponent(url.lastPathComponent)
//            print("폴더 Path에서 특정 file을 찾기 위한 PathComponent을 붙임.\(filePath)")
//            print("다시 파일을 찾을때 fileManger에서 쓸 Path: \(filePath.path)")
        
            //disk에서 cache된 파일이 있다.
            //3. Cache된 데이터를 이용해서 이미지를 띄운다.
            //4. 다음을 위해서 memoryCache에 넣는다.
        
            if fileManager.fileExists(atPath: filePath.path) {
                guard let imageData = try? Data(contentsOf: filePath) else { return nil } //원격 서버 X , 내부파일
//                print("1", filePath)
                return UIImage(data: imageData)
        }
        return nil
    }
    
    func request(endpoint: Endpointable, completion: @escaping((Result<UIImage?, NetworkError>) -> Void)) {
        
        guard let url = endpoint.getURL() else {
            return completion(.failure(.invalidURL))
        }
        // CheckMemory
        if let image = findImageInMemoryCache(from: url) {
            return completion(.success(image))
        }
        
        // CheckDisk
        if let image = findImageInDiskCache(from: url) {
//            print("cachKey", url.lastPathComponent as NSString)
//            print()
//            print("cachedVale", image)
            
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
            //DownLoadImage and move to FinalDestination
            let fileManager = FileManager.default
            let tempPath = location?.path ?? ""
            
            guard let cacheDirectoryPath = NSSearchPathForDirectoriesInDomains(.cachesDirectory, .userDomainMask, true).first else { return }
//            print("2", cacheDirectoryPath)
            
            let imageName = urlRequest.url?.lastPathComponent ?? ""
            
            let finalPath = cacheDirectoryPath + "/" + imageName // 단순경로 path             ==  filepath.path
            
            try? fileManager.moveItem(atPath: tempPath, toPath: finalPath)
            
            var filePath = URL(fileURLWithPath: cacheDirectoryPath) //file + dePath
            
            filePath.appendPathComponent(imageName) //file + dePath + imageName
            
//            print("3" , filePath)
            if fileManager.fileExists(atPath: finalPath) {
                guard let imageData = try? Data(contentsOf: filePath),
                      let image = UIImage(data: imageData) else { return } //원격 서버 X , 내부파일
                self.cache.setObject(image, forKey: imageName as NSString)
                return completion(.success(image))
            }
            
        }
        dataTask.resume()
    }

    //TODO: - 프로토콜 extension으로 뺄 예정
    private func getStatusCode(response: URLResponse?) -> Int? {
        guard let httpResponse = response as? HTTPURLResponse else { return nil }
        return httpResponse.statusCode
    }
    
}

