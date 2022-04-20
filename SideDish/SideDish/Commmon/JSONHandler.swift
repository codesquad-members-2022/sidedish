import Foundation

final class JSONHandler{
    
    private static let encoder = JSONEncoder()
    private static let decoder = JSONDecoder()
    
    static func convertJSONToObject<T: Decodable>(from data: Data, to targetType: T.Type)-> T?{
        return try? decoder.decode(T.self, from: data)
    }
    
    static func convertObjectToJSON<T: Encodable>(from object: T)-> Any?{
        return try? encoder.encode(object)
    }
}
