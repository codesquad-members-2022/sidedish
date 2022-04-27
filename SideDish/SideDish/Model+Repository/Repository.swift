import Foundation

final class Repository: RepositoryApplicable {
    
    weak var delegate: RepositoryDelegate?
    private let jsonHandler: JSONHandlable
    private var networkHandler: NetworkHandlable
    private let dataCache: DataCachingManagable
    
    convenience init(){
        self.init(networkHandler: NetworkHandler(), jsonHandler: JSONHandler(), dataCache: DataCache())
    }
    
    private init(networkHandler: NetworkHandlable, jsonHandler: JSONHandlable, dataCache: DataCacheable){
        self.networkHandler = networkHandler
        self.jsonHandler = jsonHandler
        self.dataCache = dataCache
        
        self.networkHandler.delegate = self
    }
    
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type) {
        guard let data = getSampleJSONData(fileName: category.fileName) else { return }
        guard let response = jsonHandler.convertJSONToObject(from: data, to: Response<T>.self) else { return }
        for backgroundData in response.body {
            delegate?.fetchBackgroundData(category: category, backgroundData: backgroundData)
        }
    }
    
    private func getSampleJSONData(fileName: String) -> Data? {
        guard let path = Bundle.main.url(forResource: fileName, withExtension: "json") else { return nil }
        guard let data: Data = try? Data(contentsOf: path) else { return nil }
        return data
    }
    
    func requestData(method: HttpMethod, contentType: ContentType, url: EndPoint, completionHandler: @escaping (Result<Data,Error>)->Void){
        if let imageData = dataCache.getCacheData(key: url.urlString){
            completionHandler(.success(imageData))
        }else{
            networkHandler.request(url: url, method: method, contentType: contentType, completionHandler: completionHandler)
        }
    }
}

extension Repository: NetworkHandlerDelegate {
    func cachingDataRequested(url: EndPoint, data: Data) {
        dataCache.addCacheData(data: data, key: url.urlString)
    }
}
