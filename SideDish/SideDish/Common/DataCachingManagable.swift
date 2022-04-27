import Foundation

protocol DataCachingManagable {
    var count: Int { get }
    
    func addCacheData(data: Data, key: String)
    func getCacheData(key: String)->Data?
}
