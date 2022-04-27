import Foundation

protocol JSONHandlable{
    
    func convertJSONToObject<T:Decodable>(from data: Data, to targetType: T.Type) -> T?
    func convertObjectToJSON<T:Encodable>(from object: T) -> Data?
}

