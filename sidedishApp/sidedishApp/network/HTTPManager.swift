//
//  HTTPManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class HTTPManager {
    enum HttpMethod: String {
        case get = "GET"
        case post = "POST"
        
        func getRawValue() -> String {
            return self.rawValue
        }
    }
    
    // 캐시에 이미지 다운로드해 저장
    static let fileDownloadPath = FileManager.default.urls(for: FileManager.SearchPathDirectory.cachesDirectory, in: FileManager.SearchPathDomainMask.userDomainMask)[0]
    
    static func requestGet(url: String, complete: @escaping (Data) -> ()) {
        guard let validURL = URL(string: url) else { return }
       
        var urlRequest = URLRequest(url: validURL)
        urlRequest.httpMethod = HttpMethod.get.getRawValue()
        
        URLSession.shared.dataTask(with: urlRequest) { data, response, error in
            guard let data = data else { return }
            guard let response = response as? HTTPURLResponse,
                  (200..<300).contains(response.statusCode) else {
                if let response = response as? HTTPURLResponse {
                    print(response.statusCode)
                }
                return
            }

            complete(data)
        }.resume()
    }
    
    static func downloadImage(url: URL, toFile file: URL, completion: @escaping (Error?) -> Void) {
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = HttpMethod.get.getRawValue()
        
        let downloadTask = URLSession.shared.downloadTask(with: urlRequest) { tempURL, response, error in
            
            guard let tempURL = tempURL else {
                completion(error)
                return
            }

            do {
                // 저장경로에 있는 파일 지우기
                if FileManager.default.fileExists(atPath: file.path) {
                    try FileManager.default.removeItem(at: file)
                }
                
                // 임시경로의 파일을 새 저장경로에 저장
                try FileManager.default.copyItem(at: tempURL, to: file)
                
                completion(nil)
            } catch { // copyItem에서 발생할 수 있는 에러 처리
                completion(error)
            }
        }
        downloadTask.resume()
    }
    
    static func loadData(url: URL, completion: @escaping (Data?, Error?) -> Void) {
        var result = Data()
        // 캐시 내의 URL로의 경로 지정
        let fileCachePath = FileManager.default.temporaryDirectory.appendingPathComponent(
            url.lastPathComponent,
            isDirectory: false
        )
        // 캐시에 해당 이미지가 있으면 캐시의 이미지를 가져옴
        do {
            try result = Data(contentsOf: fileDownloadPath)
            completion(result, nil)
            return
        } catch {
            print("캐시에 이미지 있음 : \(error)")
        }
        
        // 캐시에 해당 이미지가 없으면, 캐시에 그 이미지 다운로드 :
        downloadImage(url: url, toFile: fileDownloadPath) { (error) in
            do {
                try result = Data(contentsOf: fileDownloadPath)
                completion(result, nil)
            } catch {
                print("캐시에 이미지가 없어 새로 다운로드 : \(error)")
            }
        }
        // TODO : 이전에 다운받은 이미지가 있어서 매번 그 이미지를 가져오는 상황.
    }
}
