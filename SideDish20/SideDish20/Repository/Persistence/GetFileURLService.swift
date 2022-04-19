//
//  GetFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

final class GetFileURLService: CacheFileManagerAttribute {
    override init() {
        super.init()
    }
    
    func fetchFile(as name: String) -> URL? {
        guard var cacheDir = getCacheDirPath() else {
            return nil
        }
        
        cacheDir.appendPathComponent(name, isDirectory: false)
        
        do {
            let contentNames = try manager.contentsOfDirectory(atPath: cacheDir.path)
            if let fileName = contentNames.first {
                return cacheDir.appendingPathComponent(fileName)
            } else {
                return nil
            }
        } catch {
            return nil
        }
    }
    
    func fetchCachedFiles() -> [FileDTO] {
        
        var result = [FileDTO]()
        
        guard var cacheDir = getCacheDirPath() else {
            return result
        }
        
        do {
            let cacheContents = try manager.contentsOfDirectory(atPath: cacheDir.path)
            
            for cachedFileName in cacheContents {
                
                cacheDir.appendPathComponent(cachedFileName)
                
                if let data = try? Data(contentsOf: cacheDir) {
                    result.append(FileDTO(name: cachedFileName, data: data))
                }
                
                cacheDir.deleteLastPathComponent()
            }
            
        } catch {
            return result
        }
        
        return result
    }
}
