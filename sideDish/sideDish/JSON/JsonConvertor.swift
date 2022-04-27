//
//  JsonConvertor.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/20.
//

import Foundation
import OSLog

enum NetworkError: String, Error {
    case nodata
    case decoding
    case statusCode
}

extension NetworkError: CustomStringConvertible {
    var description: String {
        return self.rawValue
    }
}

class JsonConvertor{
    
    static func mockLoad(file: String) -> [Food]?{
        let fileName = file
        let type = "json"
        
        guard let fileLocation = Bundle.main.url(forResource: fileName, withExtension: type) else { return nil }
        do {
            let data = try Data(contentsOf: fileLocation)
            guard let result: Response = JsonConvertor.decodeJson(data: data) else { return nil }
            
            if result.statusCode == 200 {
                return result.body
            } else {
                os_log(.debug, log: .default, "server is not valid \(NetworkError.statusCode)")
            }
        } catch {
            os_log(.default, log: .default, "data is not load error \(NetworkError.nodata)")
        }
        
        return nil
    }
    
    static func decodeJson<T: Codable>(data: Data) -> T?{
        do{
            let result = try JSONDecoder().decode(T.self, from: data)
            return result
        } catch {
            os_log(.default, log: .default, "Decoding error \(NetworkError.decoding)")
            return nil
        }
    }
}
