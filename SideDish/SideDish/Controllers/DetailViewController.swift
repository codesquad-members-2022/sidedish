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
        foodDetailView.delegate = self

        setLayout()
        updateFoodDetailInfo()
        updateFoodThumbnailImage()
        updateFoodDetailImages()
        addObservers()
    }
    
    private func addObservers() {
        NotificationCenter.default.addObserver(self, selector: #selector(changedSelectedFoodCount(_:)), name: NotificationName.selectedFoodCountChanged, object: ordering)
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
        guard let foodDetail = ordering?.selectedFoodDetail else { return }
        ordering?.requesetFoodImage(imageUrl: foodDetail.thumbImageUrls[0]) { [weak self] result in
            switch result {
            case .success(let imageData):
                self?.foodDetailView.addThumbnailImage(imageData: imageData)
            case .failure(let error):
                self?.logger.error("\(error.localizedDescription)")
            }
        }
    }
    
    private func updateFoodDetailImages() {
        guard let foodDetail = ordering?.selectedFoodDetail else { return }
        foodDetailView.adjustFoodDetailImageStackViewLayout(imageCount: foodDetail.detailImageUrls.count)
        for imageUrl in foodDetail.detailImageUrls {
            ordering?.requesetFoodImage(imageUrl: imageUrl) { [weak self] result in
                switch result {
                case .success(let imageData):
                    DispatchQueue.main.async { 
                        self?.foodDetailView.addDetailImage(imageData: imageData)
                    }
                case .failure(let error):
                    self?.logger.error("\(error.localizedDescription)")
                }
            }
        }
    }
    
    @objc func changedSelectedFoodCount(_ notification: Notification) {
        guard let count = notification.userInfo?[UserInfoKey.changedSelectedFoodCount] as? Int else { return }
        guard let sum = notification.userInfo?[UserInfoKey.orderingSumPrice] as? Int else { return }
        foodDetailView.foodCountValueLabel.text = "\(count)"
        foodDetailView.foodTotalPriceValueLabel.text = "\(sum)"
    }
}

extension DetailViewController: FoodDetailViewDelegate {
    func changingSelectedFoodCountRequested(value: Double) {
        ordering?.setOrderingCount(value: value)
    }
}
