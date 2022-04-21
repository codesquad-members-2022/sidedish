//
//  SaveFileService.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/19.
//

import Foundation

final class SaveFileService: CacheFileManagerAttribute {
    
    @discardableResult
    func saveFile(as name: String, contentsOf file: Data) -> Result<URL, CacheError> {
        guard var targetURL = createDirectoryInCache(as: name) else { // Application Support/Cache
            return .failure(.cacheDirectoryError("Can not find Cache Directory."))
        }
        
        targetURL.appendPathComponent(name, isDirectory: false) // Application Support/Cache/img01/img01
        
        if isFileExists(at: targetURL) {
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
