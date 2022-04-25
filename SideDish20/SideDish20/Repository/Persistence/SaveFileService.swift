//
//  SaveFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

final class SaveFileService: CacheFileManagerAttribute {
    
    func saveFile(as name: String, contentsOf file: Data) {
        guard var targetURL = createDirectoryInCache(as: name) else { // Application Support/Cache
            return
        }
        
        targetURL.appendPathComponent(name, isDirectory: false) // Application Support/Cache/img01/img01
        
        if isFileExists(at: targetURL) {
            return
        } else {
            try? file.write(to: targetURL)
        }
    }
}
