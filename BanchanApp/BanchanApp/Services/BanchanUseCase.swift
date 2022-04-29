//
//  BanchanUseCase.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/29.
//

import Foundation

protocol BanchanUseCaseProtocol {
    func fetchData(with id: String, completion: @escaping (ProductDetail?, NetworkError?) -> Void)
    func getImages(with urls: [String], completion: @escaping (Data) -> Void)
    func getBulkImages(with urls: [String], completion: @escaping ([Data]) -> Void)
}

class BanchanUseCase: BanchanUseCaseProtocol {
    private let repository: RepositoryProtocol
    private let imageManager = ImageManager()

    init(repository: RepositoryProtocol) {
        self.repository = repository
    }

    func fetchData(with id: String, completion: @escaping (ProductDetail?, NetworkError?) -> Void) {
        self.repository.getProduct(by: id) { entity, error in
            guard let data = entity, error == nil else {
                completion(nil, error)
                return
            }

            completion(data, nil)
        }
    }

    func getImages(with urls: [String], completion: @escaping (Data) -> Void) {
        let urls = urls.compactMap { url in
            return NSURL(string: url)
        }

        for url in urls {
            self.imageManager.fetchImage(with: url) { data in
                completion(data)
            }
        }
    }

    func getBulkImages(with urls: [String], completion: @escaping ([Data]) -> Void) {
        let urls = urls.compactMap { url in
            return NSURL(string: url)
        }

        var result = [Data]()
        let group = DispatchGroup()

        for url in urls {
            group.enter()
            self.imageManager.fetchImage(with: url) { data in
                group.leave()
                result.append(data)
            }
        }

        group.notify(queue: .main) {
            completion(result)
        }
    }
}
