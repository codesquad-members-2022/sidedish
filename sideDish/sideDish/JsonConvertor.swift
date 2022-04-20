//
//  JsonConvertor.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/20.
//

import Foundation

class JsonConvertor{
    
    func mockLoad(){
        let fileName = "mock"
        let type = "json"
        
        guard let fileLocation = Bundle.main.url(forResource: fileName, withExtension: type) else { return  }
        
        do {
            let data = try Data(contentsOf: fileLocation)
            guard let decodeData : [Food] = JsonConvertor.decodeJsonArray(data: data) else { return }
        } catch {
        }
    }
    
    
    static func decodeJsonArray<T: Codable>(data: Data) -> [T]?{
        do{
            let result = try JSONDecoder().decode([T].self, from: data)
            return result
        } catch{
            guard let error = error as? DecodingError else { return nil }
            
            switch error{
            case .dataCorrupted(let context):
                print(context.codingPath, context.debugDescription, context.underlyingError ?? "", separator: "\n")
                return nil
            default :
                return nil
            }
        }
    }
    
    static func encodeJson<T: Codable>(param: T) -> Data?{
        do{
            let result = try JSONEncoder().encode(param)
            return result
        } catch{
            return nil
        }
    }
}
