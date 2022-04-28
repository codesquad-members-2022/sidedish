//
//  ResourceRepositoryImpl.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/22.
//

import Combine
import Foundation

class ResourceRepositoryImpl: NetworkRepository, ResourceRepository {
    func loadImage(_ url: URL) -> AnyPublisher<URL, Never> {
        Future<URL, Never> { promise in
            guard let cachesDirectory = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first else {
                return
            }
            
            let fileName = url.lastPathComponent
            let destination = cachesDirectory.appendingPathComponent(fileName)
            if FileManager.default.fileExists(atPath: destination.path) {
                promise(.success(destination))
                return
            }
            
            self.downloadTask(url, cachePath: destination) { url in
                try? FileManager.default.copyItem(at: url, to: destination)
                promise(.success(destination))
            }
        }.eraseToAnyPublisher()
    }
}
