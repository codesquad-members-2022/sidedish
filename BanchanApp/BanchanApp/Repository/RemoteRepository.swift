//
//  Repository.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

protocol RepositoryProtocol {
    func getProductList(by type: BanchanType, completion: @escaping ([Product]?, NetworkError?) -> Void)
    func getProduct(by id: String, completion: @escaping (ProductDetail?, NetworkError?) -> Void)
}

class RemoteRepository: RepositoryProtocol {
    private let networkManager: NetworkManagerProtocol

    init(networkManager: NetworkManagerProtocol) {
        self.networkManager = networkManager
    }

    private var baseURL: URL? {
        return try? URL(string: "https://" + Configuration.value(for: "ServerURL"))
    }

    func getProductList(by type: BanchanType, completion: @escaping ([Product]?, NetworkError?) -> Void) {
        guard var url = self.baseURL else { return }

        url.appendPathComponent(type.toValue)

        let request = URLRequest(url: url)

        self.networkManager.fetchData(request: request, type: ProductListResponse.self) { result in
            switch result {
            case .success(let products):
                completion(products.body, nil)
            case .failure(let error):
                completion(nil, error)
            }
        }
    }

    // TODO: URLRequest 를 매개변수로 받고 제너릭을 사용해 아래 코드 재사용
    func getProduct(by id: String, completion: @escaping (ProductDetail?, NetworkError?) -> Void) {
        guard var url = self.baseURL else { return }

        url.appendPathComponent("detail")
        url.appendPathComponent(id)

        let request = URLRequest(url: url)

        self.networkManager.fetchData(request: request, type: ProductDetailResponse.self) { result in
            switch result {
            case .success(let productDetail):
                completion(productDetail.data, nil)
            case .failure(let error):
                completion(nil, error)
            }
        }
    }
}
