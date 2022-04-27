import Foundation

protocol RepositoryApplicable {
    var delegate: RepositoryDelegate? { get set }
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type)
    func requestData(completionHandler: @escaping (Data) -> Void, method: HttpMethod, contentType: ContentType, url: EndPoint)
}
