//
//  NetworkManager.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//
import Foundation

final class NetworkManager {
    private var session: URLSession

    init(session: URLSession) {
        self.session = session
    }
    
    func request<T: Decodable>(endpoint: Endpointable, completion: @escaping((Result<T?, NetworkError>) -> Void)) {
        // handling urlError
        let endpointURL = endpoint.getURL()
        guard let url = URL(string: endpointURL) else {
            return completion(.failure(.invalidURL))
        }
        var urlRequest = URLRequest(url: url)
        // HTTP Method
        let httpMethod = endpoint.getHttpMethod().description
        urlRequest.httpMethod = httpMethod
        // HTTP header
        let headers = endpoint.getHeaders()
        headers?.forEach { urlRequest.setValue($1 as? String, forHTTPHeaderField: $0) }
        
        // handling encodingError if endpoint has body
        if let postBody = endpoint.getBody() {
            do {
                let body = try JSONSerialization.data(withJSONObject: postBody, options: [])
                urlRequest.httpBody = body
            } catch {
                completion(.failure(.encodingError))
            }
        }

        dataTask(urlRequest: urlRequest, completion: completion)
    }
    
    func dataTask<T: Decodable>(urlRequest: URLRequest, completion: @escaping((Result<T?, NetworkError>) -> Void)) {
        
        let dataTask = session.dataTask(with: urlRequest) { [weak self] data, response, error in
            guard let self = self else {
                return completion(.failure(.emptySession))
            }
            
            // handling transportError
            if let error = error {
                return completion(.failure(.transportError(error)))
            }
            
            // handling NoDataError
            guard let data = data else {
                return completion(.failure(.emptyData))
            }
            
            // handling ServerError
            guard let statusCode = self.getStatusCode(response: response) else { return }
            guard 200..<300 ~= statusCode else {
                return completion(.failure(.invalidResponse(statusCode: statusCode)))
            }
            
            // handling DecodingError
            do {
                
                // handling getImage Case
                let getImageBaseURL = urlRequest.description.replacingOccurrences(of: urlRequest.url?.path ?? "", with: "")
                
                if getImageBaseURL == BaseURL.image.urlString {
                    return completion(.success(data as? T))
                }
                
                let fetchedData = try JSONDecoder().decode(T.self, from: data) // Data -> T: Decodable
                return completion(.success(fetchedData))
                
            } catch {
                return completion(.failure(.decodingError))
            }
        }
        dataTask.resume()
    }
    
    func session(_ urlSession: URLSession) {
        self.session = urlSession
    }
    
    private func getStatusCode(response: URLResponse?) -> Int? {
        guard let httpResponse = response as? HTTPURLResponse else { return nil }
        return httpResponse.statusCode
    }
}
