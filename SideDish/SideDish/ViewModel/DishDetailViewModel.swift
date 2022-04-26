import Foundation
import UIKit
import OSLog

final class DishDetailViewModel {
    private let repository: DishDetailRepository
    private let detailHash: String

    private(set) var topImages = [UIImage]()
    private(set) var title = ""
    private(set) var description = ""
    private(set) var finalPrice = ""
    private(set) var normalPrice: String?
    private(set) var discountType: [DiscountType] = []
    private(set) var point = ""
    private(set) var deliveryInfo = ""
    private(set) var deliveryFee = ""
    private(set) var detailImages = [UIImage]()

    var onUpdate: () -> Void = {}
    var onUpdateWithTopImages: () -> Void = {}
    var onUpdateWithDetailImages: () -> Void = {}

    init(detailHash: String, repository: DishDetailRepository) {
        self.detailHash = detailHash
        self.repository = repository
    }

    func fetchDetailData() {
        self.repository.fetchDishDetail(of: detailHash) {result in
            switch result {
            case .failure(let error):
                os_log(.error, "\(error.localizedDescription)")

            case .success(let dishDetail):
                DispatchQueue.global().async {
                    dishDetail.thumbImages.forEach { imageURL in
                        guard let url = URL(string: imageURL) else {return}
                        if let data = try? Data(contentsOf: url),
                           let downloadedImage = UIImage(data: data) {
                            DispatchQueue.main.async {
                                self.topImages.append(downloadedImage)
                            }
                        }
                    }
                    self.onUpdateWithTopImages()

                    dishDetail.detailSection.forEach { imageURL in
                        guard let url = URL(string: imageURL) else {return}
                        if let data = try? Data(contentsOf: url),
                           let downloadedImage = UIImage(data: data) {
                            DispatchQueue.main.async {
                                self.detailImages.append(downloadedImage)
                            }
                        }
                    }
                    self.onUpdateWithDetailImages()
                }
                self.description = dishDetail.productDescription
                self.finalPrice = dishDetail.prices[0]
                if dishDetail.prices.count > 1 {
                    self.normalPrice = dishDetail.prices[1]
                }

                self.point = dishDetail.point
                self.deliveryInfo = dishDetail.deliveryInfo
                self.deliveryFee = dishDetail.deliveryFee
                self.onUpdate()
            }
        }
    }
}
