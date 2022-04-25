//
//  CacheFileManagerAttribute.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class CacheFileManagerAttribute {
    
    private let manager = FileManager.default
    private let cacheFolderName = "Cache"
    
    /// Application Support 경로를 반환
    func getLibraryPath() -> URL? {
        manager.urls(for: .libraryDirectory, in: .userDomainMask).first
    }
    
    /// Cache 폴더가 존재하는지 확인
    func isFileExists(at url: URL) -> Bool {
        return manager.fileExists(atPath: url.path)
    }
    
    /// Cache 폴더가 존재하면 그 경로를 가져오고, 없으면 생성한 뒤 경로를 가져옴.
    func getCacheDirPath() -> URL? {
        
        guard var cacheFolderPath = getLibraryPath() else {
            return nil
        }
        
        cacheFolderPath.appendPathComponent(cacheFolderName, isDirectory: true)
        
        if isFileExists(at: cacheFolderPath) {
            return cacheFolderPath
        }
        
        do {
            try manager.createDirectory(at: cacheFolderPath, withIntermediateDirectories: false)
        } catch {
            return nil
        }

        return cacheFolderPath
    }
    
    func createDirectoryInCache(as name: String) -> URL? {
        guard var cacheFolderPath = getCacheDirPath() else {
            return nil
        }
        
        cacheFolderPath.appendPathComponent(name)
        
        do {
            try manager.createDirectory(at: cacheFolderPath, withIntermediateDirectories: false)
            return cacheFolderPath
        } catch {
            return nil
        }
    }
    
    func getContentsCache() -> [Data]? {
        guard let cacheDir = getCacheDirPath() else {
            return nil
        }
        
        do {
            let contentsInCache = try manager.contentsOfDirectory(at: cacheDir,
                                                                  includingPropertiesForKeys: nil,
                                                                  options: .skipsHiddenFiles)
            let URLInCache = contentsInCache.map({$0.appendingPathComponent($0.lastPathComponent)})
            return URLInCache.compactMap { url in
                manager.contents(atPath: url.path)
            }
        } catch {
            return nil
        }
    }
    
    func getContent(name: String) -> Data? {
        guard var targetURL = getCacheDirPath() else { return nil }
        
        targetURL.appendPathComponent(name)
        targetURL.appendPathComponent(name)
        
        return manager.contents(atPath: targetURL.path)
    }
    
}

enum CacheError: Error {
    case fileNotExistError(String)
    case urlError(String)
    case fileAlreadyExistError(String)
    case cacheDirectoryError(String)
}
