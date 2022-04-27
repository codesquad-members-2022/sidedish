import Foundation

final class MockRepository: RepositoryApplicable{
    
    var delegate: RepositoryDelegate?
    private var networkHandler: NetworkHandlable
    private let jsonHandler: JSONHandlable
    private let dataCache: DataCacheable
    
    init(networkHandler: NetworkHandlable, jsonHandler: JSONHandlable, dataCache: DataCacheable){
        self.networkHandler = networkHandler
        self.jsonHandler = jsonHandler
        self.dataCache = dataCache
        
        self.networkHandler.delegate = self
    }
    
    func fetchBackgroundData<T>(category: Category, dataType: T.Type) where T : Decodable, T : Encodable {
        let food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        delegate?.fetchBackgroundData(category: .main, backgroundData: food)
    }
    
    func requestData(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<Data,Error>)->Void) {
        networkHandler.request(url: url, method: method, contentType: contentType, completionHandler: completionHandler)
    }
    
}

extension MockRepository: NetworkHandlerDelegate{
    
    func cachingDataRequested(url: EndPoint, data: Data) {
        dataCache.addCacheData(data: data, key: url.urlString)
    }
}
