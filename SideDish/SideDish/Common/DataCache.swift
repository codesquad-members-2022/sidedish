import Foundation

final class DataWrapper{
    private (set) var data: Data
    
    init(data: Data){
        self.data = data
    }
}

final class DataCache: DataCacheable{
    private let dataCache: NSCache<NSString, DataWrapper>
    
    init(){
        self.dataCache = NSCache<NSString, DataWrapper>()
    }
    
    func addCacheData(data: Data, key: String){
        let key = NSString(string: key)
        dataCache.setObject(DataWrapper(data: data), forKey: key)
    }
    
    func getCacheData(key: String)->Data?{
        let key = NSString(string: key)
        return dataCache.object(forKey: key)?.data
    }
}
