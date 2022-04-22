import Foundation

struct Repository: RepositoryApplicable{
    weak var delegate: RepositoryDelegate?
    private let jsonHandler: JSONHandlable = JSONHandler()
    
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type){
        guard let data = getSampleJSONData(fileName: category.fileName) else { return }
        guard let response = jsonHandler.convertJSONToObject(from: data, to: Response<T>.self) else { return }
        for backgroundData in response.body{
            delegate?.fetchBackgroundData(category: category, backgroundData: backgroundData)
        }
    }
    
    private func getSampleJSONData(fileName: String)-> Data?{
        guard let path = Bundle.main.url(forResource: fileName, withExtension: "json") else { return nil }
        guard let data: Data = try? Data(contentsOf: path) else { return nil }
        return data
    }
}
