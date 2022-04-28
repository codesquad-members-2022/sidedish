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
        self.discountType = {
            var result: [DiscountType] = []
            origin.badge?.forEach({ string in
                if let type = DiscountType(string) {
                    result.append(type)
                }
            })
            return result.isEmpty ? nil : result
        }()
    }
}
