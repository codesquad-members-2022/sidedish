import Foundation

protocol RepositoryApplicable{
    var delegate: RepositoryDelegate? { get set }
    
    func fetchBackgroundData<T: Codable>(category: Category, dataType: T.Type)
}
