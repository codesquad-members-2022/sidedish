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
    
    func fetchFile(as name: String) -> Result<FileDTO, CacheError> {
        guard var cacheDir = getCacheDirPath() else {
            return .failure(.cacheDirectoryError("Can not find Cache Directory."))
        }
        
        do {
            
            cacheDir.appendPathComponent(name, isDirectory: false)
            
            let contentName = try manager.contentsOfDirectory(atPath: cacheDir.path)
            
            if let fileName = contentName.first {
                let url = cacheDir.appendingPathComponent(fileName)
                let data = try Data(contentsOf: url)
                return .success(FileDTO(name: url.lastPathComponent, data: data))
            } else {
                return .failure(.fileNotExistError("FilePath error. \(cacheDir)\\\(contentName)"))
            }
        } catch {
            return .failure(.cacheDirectoryError("No contents in Cache Directory file system."))
        }
    }
    
    func fetchCachedFiles() -> Result<[FileDTO], CacheError> {
        
        var result = [FileDTO]()
        
        guard let cacheDir = getCacheDirPath() else {
            return .failure(.cacheDirectoryError("Can not find Cache Directory."))
        }
        
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
                    return .failure(.fileNotExistError("FilePath error. \(url.absoluteString)"))
                }
            }
            
        } catch {
            return .failure(.cacheDirectoryError("No contents in Cache Directory file system."))
        }
        
        return .success(result)
    }
}
