//
//  CacheFileManagerAttribute.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheFileManagerAttribute {
    
    let manager = FileManager.default
    private let cacheFolderName = "Cache"
    
    /// Application Support 경로를 반환
    func getLibraryPath() -> URL? {
        manager.urls(for: .libraryDirectory, in: .userDomainMask).first
    }
    
    /// Cache 폴더가 존재하는지 확인
    func folderExists(at url: URL) -> Bool {
        var isDirectory: ObjCBool = true
        return manager.fileExists(atPath: url.path, isDirectory: &isDirectory)
    }
    
    /// Cache 폴더가 존재하면 그 경로를 가져오고, 없으면 생성한 뒤 경로를 가져옴.
    func getCacheDirPath() -> URL? {
        
        guard var cacheFolderPath = getLibraryPath() else {
            return nil
        }
        
        cacheFolderPath.appendPathComponent(cacheFolderName, isDirectory: true)
        
        if folderExists(at: cacheFolderPath) {
            return cacheFolderPath
        }
        
        do {
            try manager.createDirectory(at: cacheFolderPath, withIntermediateDirectories: false)
        } catch {
            return nil
        }

        return cacheFolderPath
    }
}

enum CacheError: Error {
    case fileNotExistError(String)
    case urlError(String)
    case fileAlreadyExistError(String)
    case cacheDirectoryError(String)
}
