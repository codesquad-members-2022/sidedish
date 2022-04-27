import Foundation

struct JSONHandler: JSONHandlable {
    
    private let encoder = JSONEncoder()
    private let decoder = JSONDecoder()
    
    func convertJSONToObject<T: Decodable>(from data: Data, to targetType: T.Type)-> T? {
        return try? decoder.decode(T.self, from: data)
    }
    
    func convertObjectToJSON<T: Encodable>(from object: T) -> Data? {
        return try? encoder.encode(object)
    }
}

