import Foundation

protocol RepositoryDelegate: AnyObject {
    func fetchBackgroundData(category: Category, backgroundData: Codable)
}
