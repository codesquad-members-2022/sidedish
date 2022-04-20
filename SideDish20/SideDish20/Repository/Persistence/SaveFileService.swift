//
//  SaveFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

final class SaveFileService: CacheFileManagerAttribute {
    
    var locationCacheDir: URL {
        manager.urls(for: .libraryDirectory, in: .userDomainMask)[0] // get Dir urlPath.
    }
    
    @discardableResult
    func saveFile(as name: String, contentsOf file: Data) -> Result<URL, CacheError> {
        guard var targetURL = getCacheDirPath() else {
            return .failure(.cacheDirectoryError("Can not find Cache Directory."))
        }
        
        targetURL.appendPathComponent(name, isDirectory: false)
        if folderExists(at: targetURL) == false {
            do {
                try manager.createDirectory(at: targetURL, withIntermediateDirectories: false)
            } catch {
                return .failure(.cacheDirectoryError("Create Cache Directory Failed"))
            }
        }
        
        targetURL.appendPathComponent(name, isDirectory: false)
        if manager.fileExists(atPath: targetURL.path) {
            return .success(targetURL)
        } else {
            do {
                try file.write(to: targetURL)
                return .success(targetURL)
            } catch {
                return .failure(.fileAlreadyExistError("File Already Exist at \(targetURL.absoluteString)"))
            }
        }
    }
}
