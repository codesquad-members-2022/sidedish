import Foundation

final class MockRepository: RepositoryApplicable{
    
    var delegate: RepositoryDelegate?
    private var networkHandler: NetworkHandlable
    private let jsonHandler: JSONHandlable
    private let dataCache: DataCachingManagable
    
    init(networkHandler: NetworkHandlable, jsonHandler: JSONHandlable, dataCache: DataCachingManagable){
        self.networkHandler = networkHandler
        self.jsonHandler = jsonHandler
        self.dataCache = dataCache
        
        self.networkHandler.delegate = self
    }
    
    func fetchBackgroundData<T>(category: Category, dataType: T.Type) where T : Decodable, T : Encodable {
        let food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        delegate?.fetchBackgroundData(category: .main, backgroundData: food)
    }
    
    func requestBinaryData(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<Data,Error>)->Void) {
        networkHandler.request(url: url, method: method, contentType: contentType, completionHandler: completionHandler)
    }
    
    func requestModelData<T>(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<T, Error>) -> Void) where T : Decodable, T : Encodable {
        networkHandler.request(url: url, method: method, contentType: contentType) { result in
            switch result {
            case .success(let data):
                guard let model = self.jsonHandler.convertJSONToObject(from: data, to: T.self) else { return }
                completionHandler(.success(model))
            case .failure(let error):
                completionHandler(.failure(error))
            }
        }
    }
}

extension MockRepository: NetworkHandlerDelegate{
    
    func cachingDataRequested(url: EndPoint, data: Data) {
        dataCache.addCacheData(data: data, key: url.urlString)
    }
}
