//
//  GetFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

class GetFileURLService: CacheFileManagerAttribute {
    override init() {
        super.init()
    }
    
    func getFile(as name: String) -> URL? {
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
}
