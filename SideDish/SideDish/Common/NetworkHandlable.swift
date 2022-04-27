import Foundation

protocol NetworkHandlable{
    var delegate: NetworkHandlerDelegate? { get set }
    func request(url: EndPoint, method: HttpMethod, contentType: ContentType, completionHandler: @escaping (Result<Data,Error>)->Void)
}
