//
//  NetworkRepository.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/22.
//

import Combine
import Foundation

class NetworkRepository {
    func downloadTask(_ url: URL, cachePath: URL, complated: @escaping (URL) -> Void) {
        let task = URLSession.shared.downloadTask(with: url) { url, _, _ in
            guard let url = url else {
                return
            }
            complated(url)
        }
        task.resume()
    }
}
