import Alamofire

protocol NetworkHandlable{
    var delegate: NetworkHandlerDelegate? { get set }
    func request(url: EndPoint, method: HTTPMethod, contentType: ContentType, completionHandler: @escaping (Data)->Void)
}
