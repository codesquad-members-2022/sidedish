//
//  Service.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

protocol ServiceProtocol {
    func fetchData(type: BanchanType, completion: @escaping ([Banchan]?, NetworkError?) -> Void)
    func getImage(with url: String, completion: @escaping (Data) -> Void)
}

class Service: ServiceProtocol {
    private var repository: RepositoryProtocol
    private let imageManager = ImageManager()

    init(repository: RepositoryProtocol) {
        self.repository = repository
    }

    func fetchData(type: BanchanType, completion: @escaping ([Banchan]?, NetworkError?) -> Void) {
        self.repository.getProductList(by: type) { result, error in
            guard let data = result, error == nil else {
                completion(nil, error)
                return
            }

            let banchans = data.map({ entity in
                return entity.toDomain(type: type)
            })

            completion(banchans, nil)
        }
    }

    func getImage(with url: String, completion: @escaping (Data) -> Void) {
        guard let url = NSURL(string: url) else { return }
        self.imageManager.fetchImage(with: url) { data in
            completion(data)
        }
    }
}
