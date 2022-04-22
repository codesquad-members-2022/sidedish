import Foundation

protocol JSONHandlable{
    func convertJSONToObject(from data: Data, to targetType: Decodable.Type)->Decodable?
    func convertObjectToJSON(from object: Encodable)->Data?
}
