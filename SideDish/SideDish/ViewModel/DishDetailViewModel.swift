import Foundation
import OSLog

final class DishDetailViewModel {
    private let repository: DishDetailRepository
    private let detailHash: String

    private(set) var topImages = [Data]()
    private(set) var title = ""
    private(set) var discountType: [DiscountType]?
    private(set) var detailImages = [Data]()

    var onUpdate: (DetailStringData) -> Void = {_ in}
    var onUpdateWithTopImages: () -> Void = {}
    var onUpdateWithDetailImages: () -> Void = {}

    init(title: String, detailHash: String, repository: DishDetailRepository) {
        self.title = title
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
                        if let data = try? Data(contentsOf: url) {
                            self.topImages.append(data)
                        }
                    }
                    self.onUpdateWithTopImages()

                    dishDetail.detailSection.forEach { imageURL in
                        guard let url = URL(string: imageURL) else {return}
                        if let data = try? Data(contentsOf: url) {
                            self.detailImages.append(data)
                        }
                    }
                    self.onUpdateWithDetailImages()
                }

                let detailStringData = DetailStringData(entity: dishDetail)
                self.onUpdate(detailStringData)
            }
        }
    }

    func setDiscountType(_ discountType: [DiscountType]) {
        self.discountType = discountType
    }
}
