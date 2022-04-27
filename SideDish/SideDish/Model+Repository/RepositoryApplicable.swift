import Foundation

protocol RepositoryApplicable {
    var delegate: RepositoryDelegate? { get set }
    
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type)
    func requestData(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<Data,Error>)->Void)
}
