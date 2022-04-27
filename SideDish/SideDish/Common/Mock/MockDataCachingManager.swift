import Foundation

final class MockDataCachingManager: DataCachingManagable{
    
    private var mockDataCache: [String:Data] = [:]
    var count: Int{
        print(mockDataCache.count)
        return mockDataCache.count
    }
    
    func addCacheData(data: Data, key: String) {
        mockDataCache[key] = data
    }
    
    func getCacheData(key: String) -> Data? {
        guard let data = mockDataCache[key] else { return nil }
        return data
    }
    
}
