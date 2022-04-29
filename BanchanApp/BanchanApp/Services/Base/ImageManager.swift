//
//  ImageManager.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/27.
//

import Foundation

class ImageData {
    var data: Data

    init(data: Data) {
        self.data = data
    }
}

class ImageManager {
    typealias CompletionHandler = (Data) -> Void

    private let cachedImages = NSCache<NSURL, ImageData>()
    private var pendingResponses = [NSURL: [CompletionHandler]]()

    private var directoryURL: URL? {
        let url = try? FileManager.default.url(for: .applicationSupportDirectory, in: .userDomainMask, appropriateFor: nil, create: true)
        return url
    }

    private func joinPath(base: String, path: String) -> String {
        return "\(base)/\(path)"
    }

    private func getCachedImageFromMemory(url: NSURL) -> ImageData? {
        return cachedImages.object(forKey: url)
    }

    private func getCachedImageFromDisk(url: NSURL) -> ImageData? {
        guard let directoryURL = self.directoryURL else {
            return nil
        }

        let filePath = self.joinPath(base: directoryURL.path, path: (url as URL).lastPathComponent)
        let fileURL = URL(fileURLWithPath: filePath)

        guard let imageBinaryData = try? Data(contentsOf: fileURL) else {
            return nil
        }

        let imageData = self.cacheData(key: url, value: imageBinaryData)

        return imageData
    }

    func fetchImage(with url: NSURL, completion: @escaping CompletionHandler) {
        if let cachedImage = getCachedImageFromMemory(url: url) {
            completion(cachedImage.data)
            return
        }

        if let cachedImage = self.getCachedImageFromDisk(url: url) {
            completion(cachedImage.data)
            return
        }

        guard pendingResponses[url] == nil else {
            pendingResponses[url]?.append(completion)
            return
        }

        pendingResponses[url] = [completion]

        URLSession.shared.downloadTask(with: url as URL) { data, _, error in
            guard
                let fileURL = data, error == nil, let completions = self.pendingResponses[url] else { return }

            do {
                guard let directoryURL = self.directoryURL else { return }

                let imageBinaryData = try Data(contentsOf: fileURL)
                let filePath = self.joinPath(base: directoryURL.path, path: (url as URL).lastPathComponent)

                FileManager.default.createFile(atPath: filePath, contents: imageBinaryData)

                let imageData = self.cacheData(key: url, value: imageBinaryData)

                completions.forEach { completion in
                    completion(imageData.data)
                }
            } catch {
                print("ERROR: ", error)
            }
        }.resume()
    }

    private func cacheData(key: NSURL, value: Data) -> ImageData {
        let imageData = ImageData(data: value)
        self.cachedImages.setObject(imageData, forKey: key)
        return imageData
    }
}
