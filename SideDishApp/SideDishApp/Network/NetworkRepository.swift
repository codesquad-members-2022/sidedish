//
//  NetworkService.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/05/17.
//

import Foundation
import OSLog

final class NetworkRepository {
    // 어떤 NetworkManagable를 채탁한 NetworkManager가 어떤 것일지에 따라 request가 달라짐.
    private var networkManager: NetworkManagable?
    
    init(networkManager: NetworkManagable) {
        self.networkManager = networkManager
    }
    
    // request를 처리하고 성공했다면 Decoding된 데이터를 completionHandler에 담아서 보냄.
    func fetchData<T: Codable>(endpoint: Endpointable, decodeType: T.Type, onCompleted: @escaping(T?) -> Void) {
        networkManager?.request(endpoint: endpoint, completion: { (result: Result<T?, NetworkError>) in
            print(result)
            switch result {
            case .success(let success):
                onCompleted(success)
            case .failure(let error):
                os_log(.error, "\(error.localizedDescription)")
                }
            }
        )
    }
}
