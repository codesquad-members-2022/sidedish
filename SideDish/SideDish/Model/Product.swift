import Foundation
import UIKit

class Product {
    let hash: String
    private(set) var image: UIImage?
    let title: String
    let description: String
    let salePrice: String
    let normalPrice: String?
    let discountType: [DiscountType]?

    init(origin: DishCellInfo) {
        self.hash = origin.detailHash
        self.title = origin.title
        self.description = origin.bodyDescription
        self.salePrice = origin.salePrice
        self.normalPrice = origin.normalPrice
        self.discountType = origin.badge?.filter { DiscountType($0) != nil}.map { DiscountType($0)! }
    }

    func injectImage(image: UIImage) {
        self.image = image
    }
}
