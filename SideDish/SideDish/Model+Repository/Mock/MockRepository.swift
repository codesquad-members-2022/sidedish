import Foundation

struct MockRepository: RepositoryApplicable {
    
    var delegate: RepositoryDelegate?
    
    func fetchBackgroundData<T>(category: Category, dataType: T.Type) where T : Decodable, T : Encodable {
        let food = Food(detailHash: "hash", alt: "alt", foodDescription: "description", normalPrice: "normalPrice", specialPrice: "specialPrice", deliveryInformation: ["deliveryInformation"], title: "title", imageUrl: "imageUrl", badges: ["badge"])
        delegate?.fetchBackgroundData(category: .main, backgroundData: food)
    }
    
    func requestData(completionHandler: @escaping (Data) -> Void, method: HttpMethod, contentType: ContentType, url: EndPoint) {
    
    }
    
}
