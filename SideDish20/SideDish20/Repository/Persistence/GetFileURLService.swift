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
    
    func fetchFile(as name: String) -> FileDTO? {
        guard var cacheDir = getCacheDirPath() else {
            return nil
        }
        
        do {
            
            cacheDir.appendPathComponent(name, isDirectory: false)
            
            let contentName = try manager.contentsOfDirectory(atPath: cacheDir.path)
            
            if let fileName = contentName.first {
                let url = cacheDir.appendingPathComponent(fileName)
                let data = try Data(contentsOf: url)
                return FileDTO(name: url.lastPathComponent, data: data)
            } else {
                return nil
            }
        } catch {
            return nil
        }
    }
    
    func fetchCachedFiles() -> [FileDTO] {
        
        var result = [FileDTO]()
        
        guard let cacheDir = getCacheDirPath() else { return result }
        
        do {
            
            let cacheContents = try manager.contentsOfDirectory(
                at: cacheDir,
                includingPropertiesForKeys: nil,
                options: .skipsHiddenFiles
            )
            
            for url in cacheContents {
                do {
                    let filePath = url.appendingPathComponent(url.lastPathComponent, isDirectory: false)
                    let data = try Data(contentsOf: filePath)
                    result.append(FileDTO(name: url.lastPathComponent, data: data))
                } catch {
                    continue
                }
            }
            
        } catch {
            return result
        }
        
        return result
    }
}
