import Foundation

protocol RepositoryApplicable {
    var delegate: RepositoryDelegate? { get set }
    
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type)
    func requestBinaryData(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<Data,Error>)->Void)
    func requestModelData<T: Codable>(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<T,Error>)->Void)
}
