//
//  HTTPManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class HTTPManager {
    enum HttpMethod: String {
        case get = "GET"
        case post = "POST"
        
        func getRawValue() -> String {
            return self.rawValue
        }
    }
    //requestGet(url:) { ... }
    // escaping : 클로저가 바로 실행되지 않고, 함수가 종료될 때 해당 클로저가 실행되도록 함?
    static func requestGet(url: String, complete: @escaping (Data) -> ()) { // 디코더를 클로저로 넣어 나중에 바로 디코딩 가능
        guard let validURL = URL(string: url) else { return }
       
        var urlRequest = URLRequest(url: validURL)
        urlRequest.httpMethod = HttpMethod.get.getRawValue() // "GET"
        
        URLSession.shared.dataTask(with: urlRequest) { data, response, error in
            // completion handler - 요청 실패 : 데이터 없음, 성공 : 에러 없음 이므로 모두 옵셔널로 넘어온다.
            guard let data = data else { return }
            guard let response = response as? HTTPURLResponse,
                  (200..<300).contains(response.statusCode) else {
                if let response = response as? HTTPURLResponse {
                    print(response.statusCode)
                }
                return
            }

            complete(data) // 즉시 디코딩
        }.resume() // 클로저 실행
    }
}
