import Foundation

protocol DataCachingManagable {
    func addCacheData(data: Data, key: String)
    func getCacheData(key: String)->Data?
}
