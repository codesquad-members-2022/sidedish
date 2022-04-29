//
//  ImageManager.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/28.
//

import Foundation

final class ImageManager {
    
    static func downloadImage(url: URL, toFile file: URL, completion: @escaping (Error?) -> Void) {
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = HTTPMethod.get.getRawValue()
        
        let downloadTask = URLSession.shared.downloadTask(with: urlRequest) { tempURL, response, error in
            
            guard let tempURL = tempURL else {
                completion(error)
                return
            }

            do {
                if FileManager.default.fileExists(atPath: file.path) {
                    try FileManager.default.removeItem(at: file)
                }
                
                try FileManager.default.copyItem(at: tempURL, to: file)
                
                completion(nil)
            } catch {
                completion(error)
            }
        }
        downloadTask.resume()
    }
    
    static func loadData(url: URL, completion: @escaping (Data?, Error?) -> Void) {
        var result = Data()
        // 캐시 내의 URL로의 경로 지정. 캐시에 이미지 다운로드해 저장
        let fileDownloadPath = FileManager.default.urls(for: FileManager.SearchPathDirectory.cachesDirectory, in: FileManager.SearchPathDomainMask.userDomainMask)[0]
        
        // 캐시에 해당 이미지가 없으면, 캐시에 그 이미지 다운로드 :
        downloadImage(url: url, toFile: fileDownloadPath) { (error) in
            do {
                try result = Data(contentsOf: fileDownloadPath)
                completion(result, nil)
            } catch {
                print("캐시에 이미지가 없어 새로 다운로드 : \(error)")
            }
        }
    }
}
