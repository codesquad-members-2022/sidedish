import Alamofire
import OSLog

enum ContentType {
    case json
    case image
    
    var value: String {
        switch self {
        case .json:
            return "application/json"
        case .image:
            return "image/jpeg"
        }
    }
}

enum EndPoint {
    case main(category: String)
    case detail(detailHash: String)
    case mainImage(rawUrl: String)
    
    var urlString: String {
        switch self {
        case .main(let category):
            return "https://api.codesquad.kr/onban/\(category)"
        case .detail(let detailHash):
            return "https://api.codesquad.kr/onban/detail/\(detailHash)"
        case .mainImage(let rawUrl):
            return rawUrl
        }
    }
}

enum HttpMethod {
    case get
    case post
}

struct NetworkHandler: NetworkHandlable {
    
    private let logger: Logger
    weak var delegate: NetworkHandlerDelegate?
    
    init() {
        logger = Logger()
    }
    
    func request(url: EndPoint, method: HttpMethod, contentType: ContentType, completionHandler: @escaping (Data)->Void) {
        AF.request(url.urlString,
                          method: HTTPMethod(rawValue: "\(method)"),
                          parameters: nil,
                          encoding: URLEncoding.default,
                          headers: ["Content-Type":contentType.value])
        .validate(statusCode: 200..<300)
        .responseData{response in
            switch response.result {
            case .success(let data):
                completionHandler(data)
                DispatchQueue.global().async {
                    delegate?.cachingDataRequested(url:url, data: data)
                }
            case .failure(let error):
                logger.error("[Alamofire Response Error]\(error.localizedDescription)")
            }
        }
    }
}
