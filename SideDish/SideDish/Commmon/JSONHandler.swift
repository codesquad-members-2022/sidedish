import Foundation

//아래 클래스에 대한 프로토콜을 구성해서, 추상타입을 채택한 구체타입을 사용할 예정
struct JSONHandler: JSONHandlable{

    private let encoder = JSONEncoder()
    private let decoder = JSONDecoder()
    
    func convertJSONToObject<T: Decodable>(from data: Data, to targetType: T.Type)-> T?{
        return try? decoder.decode(T.self, from: data)
    }
    
    func convertObjectToJSON<T: Encodable>(from object: T)-> Data?{
        return try? encoder.encode(object)
    }
}

