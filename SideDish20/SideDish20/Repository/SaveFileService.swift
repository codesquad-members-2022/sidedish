//
//  SaveFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class SaveFileService: CacheFileManagerAttribute {
    
    var locationCacheDir: URL {
        manager.urls(for: .libraryDirectory, in: .userDomainMask)[0] // get Dir urlPath.
    }
    
    @discardableResult
    func saveFile(as name: String, contentsOf file: Data) -> URL? {
        guard var targetURL = getCacheDirPath() else {
            return nil
        }
        
        targetURL.appendPathComponent(name, isDirectory: false)
        if folderExists(at: targetURL) == false {
            do {
                try manager.createDirectory(at: targetURL, withIntermediateDirectories: false)
            } catch {
                return nil
            }
        }
        
        targetURL.appendPathComponent(name, isDirectory: false)
        if manager.fileExists(atPath: targetURL.path) {
            return targetURL
        } else {
            do {
                try file.write(to: targetURL)
            } catch {
                return nil
            }
        }
        
        return targetURL
    }
}
