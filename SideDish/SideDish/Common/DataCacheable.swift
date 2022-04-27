import Foundation

protocol DataCacheable {
    func addCacheData(data: Data, key: String)
    func getCacheData(key: String)->Data?
}
