import Foundation

final class DataWrapper {
    private (set) var data: Data
    
    init(data: Data) {
        self.data = data
    }
}

final class DataCachingManager: DataCachingManagable {
    private let dataCache: NSCache<NSString, DataWrapper>
    private var keys: Set<NSString> = []
    var count:Int{
        return keys.count
    }
    
    init() {
        self.dataCache = NSCache<NSString, DataWrapper>()
    }
    
    func addCacheData(data: Data, key: String) {
        let key = NSString(string: key)
        dataCache.setObject(DataWrapper(data: data), forKey: key)
        keys.insert(key)
    }
    
    func getCacheData(key: String) -> Data? {
        let key = NSString(string: key)
        return dataCache.object(forKey: key)?.data
    }
}
