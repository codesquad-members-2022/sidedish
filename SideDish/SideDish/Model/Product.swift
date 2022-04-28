import Foundation
import UIKit

struct Product {
    let hash: String
    let image: UIImage
    let title: String
    let description: String
    let salePrice: String
    let normalPrice: String?
    let discountType: [DiscountType]?

    init(origin: DishCellInfo, image: UIImage) {
        self.hash = origin.detailHash
        self.image = image
        self.title = origin.title
        self.description = origin.bodyDescription
        self.salePrice = origin.salePrice
        self.normalPrice = origin.normalPrice
        self.discountType = origin.badge?.filter { DiscountType($0) != nil}.map { DiscountType($0)! }
        }
    }
