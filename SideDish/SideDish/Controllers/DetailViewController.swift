import UIKit
import OSLog

final class DetailViewController: UIViewController{
    
    private var foodTitle: String = ""
    private let foodDetailView: FoodDetailView
    private weak var ordering: Ordering?
    private let logger = Logger()
    
    init(foodTitle: String, ordering: Ordering){
        self.ordering = ordering
        self.foodTitle = foodTitle
        self.foodDetailView = FoodDetailView()
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        return nil
    }
    
    override func viewDidLoad() {
        navigationItem.title = foodTitle
        view.backgroundColor = .white
        foodDetailView.translatesAutoresizingMaskIntoConstraints = false
        setLayout()
        updateFoodDetailInfo()
        updateFoodThumbnailImage()
        updateFoodDetailImages()
    }
    
    private func setLayout() {
        view.addSubview(foodDetailView)
        NSLayoutConstraint.activate([
            foodDetailView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            foodDetailView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor),
            foodDetailView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor),
            foodDetailView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor)
        ])
        
    }
    
    private func updateFoodDetailInfo() {
        guard let foodDetail = ordering?.selectedFoodDetail else { return }
        foodDetailView.setFoodDetailInfo(foodTitle: foodTitle,
                                         foodDescription: foodDetail.productDescription,
                                         foodDeliveryInfo: foodDetail.deliveryInfo,
                                         foodDeliveryPrice: foodDetail.deliveryFee,
                                         foodPoint: foodDetail.point,
                                         foodPrices: foodDetail.prices)
    }
    
    //일정 상 썸네일 이미지는 스크롤뷰를 적용하기에는 학습시간이 부족해서 우선 이미지 한장만 적용
    private func updateFoodThumbnailImage() {
        ordering?.requesetFoodImage(imageUrl: foodDetail.thumbImageUrls[0]) { result in
            switch result {
            case .success(let imageData):
                self.foodDetailView.addThumbnailImage(imageData: imageData)
            case .failure(let error):
                self.logger.error("\(error.localizedDescription)")
            }
        }
    }
    
    private func updateFoodDetailImages() {
        foodDetailView.adjustFoodDetailImageStackViewLayout(imageCount: foodDetail.detailImageUrls.count)
        for imageUrl in foodDetail.detailImageUrls {
            ordering?.requesetFoodImage(imageUrl: imageUrl) { result in
                switch result {
                case .success(let imageData):
                    DispatchQueue.main.async {
                        self.foodDetailView.addDetailImage(imageData: imageData)
                    }
                case .failure(let error):
                    self.logger.error("\(error.localizedDescription)")
                }
            }
        }
    }
}
