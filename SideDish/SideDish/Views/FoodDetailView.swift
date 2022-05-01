import UIKit

final class FoodDetailView: UIView {
    
    weak var delegate: FoodDetailViewDelegate?
    
    private lazy var commonScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.alwaysBounceVertical = true
        return scrollView
    }()
    
    private lazy var thumbnailImageScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.alwaysBounceHorizontal = false
        scrollView.alwaysBounceVertical = false
        scrollView.showsVerticalScrollIndicator = false
        scrollView.showsHorizontalScrollIndicator = false
        scrollView.bounces = false
        scrollView.isScrollEnabled = true
        scrollView.isPagingEnabled = true
        scrollView.backgroundColor = .lightGray
        return scrollView
    }()
    
    private lazy var foodInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.distribution = .fillEqually
        stackView.axis = .vertical
        stackView.spacing = 6
        return stackView
    }()
    
    private lazy var foodNameLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 27)
        label.text = "Food Name"
        return label
    }()
    
    private lazy var foodDescriptionLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 22)
        label.numberOfLines = 2
        label.text = "Food Description"
        label.textColor = .gray
        return label
    }()
    
    private lazy var foodPricesView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodSpecialPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "특가"
        label.font = UIFont.systemFont(ofSize: 22)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodNormalPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "정가"
        label.font = UIFont.systemFont(ofSize: 22)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDeliveryInfoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .vertical
        stackView.distribution = .fillEqually
        stackView.spacing = 10
        return stackView
    }()
    
    private lazy var foodReserveView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodReserveLabel: UILabel = {
        let label = UILabel()
        label.text = "적립금"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodReserveValueLabel: UILabel = {
        let label = UILabel()
        label.text = "0"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDeliveryInfoView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodDeliveryInfoLabel: UILabel = {
        let label = UILabel()
        label.text = "배송정보"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDeliveryInfoValueLabel: UILabel = {
        let label = UILabel()
        label.text = "로켓배송"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
        
    }()
    
    private lazy var foodDeliveryPriceView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodDeliveryPriceLabel: UILabel = {
        let label = UILabel()
        label.text = "배송비"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodDeliveryPriceValueLabel: UILabel = {
        let label = UILabel()
        label.text = "0"
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 15)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    
    private lazy var foodCountView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodCountLabel: UILabel = {
        let label = UILabel()
        label.text = "수량"
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private (set) lazy var foodCountValueLabel: UILabel = {
        let label = UILabel()
        label.text = "0"
        label.font = UIFont.systemFont(ofSize: 17)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    private lazy var foodCountStepper: UIStepper = {
        let stepper = UIStepper()
        stepper.autorepeat = true
        stepper.wraps = true
        stepper.translatesAutoresizingMaskIntoConstraints = false
        return stepper
    }()
    
    private lazy var foodTotalPriceView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private lazy var foodTotalPriceLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.text = "총 주문금액"
        label.font = UIFont.systemFont(ofSize: 25)
        return label
    }()
    
    private (set) lazy var foodTotalPriceValueLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.font = UIFont.systemFont(ofSize: 27)
        label.text = "0"
        return label
    }()
    
    private lazy var foodOrderingButton: UIButton = {
        let button = UIButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        button.backgroundColor = UIColor(red: 0, green: 122/255, blue: 255/255, alpha: 1)
        button.layer.masksToBounds = true
        button.layer.cornerRadius = 15
        button.setTitle("주문하기", for: .normal)
        button.setTitleColor(UIColor.white, for: .normal)
        return button
    }()
    
    private lazy var foodDetailImageStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.distribution = .fillProportionally
        stackView.spacing = 5
        stackView.translatesAutoresizingMaskIntoConstraints = false
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        addViews()
        setLayout()
        addStepperAction()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
    private func addViews() {
        addSubview(commonScrollView)
        
        commonScrollView.addSubview(thumbnailImageScrollView)
        commonScrollView.addSubview(foodInfoStackView)
        commonScrollView.addSubview(foodDeliveryInfoStackView)
        commonScrollView.addSubview(foodCountView)
        commonScrollView.addSubview(foodTotalPriceView)
        commonScrollView.addSubview(foodOrderingButton)
        commonScrollView.addSubview(foodDetailImageStackView)
        
        foodInfoStackView.addArrangedSubview(foodNameLabel)
        foodInfoStackView.addArrangedSubview(foodDescriptionLabel)
        foodInfoStackView.addArrangedSubview(foodPricesView)

        foodPricesView.addSubview(foodSpecialPriceLabel)
        foodPricesView.addSubview(foodNormalPriceLabel)
        
        foodDeliveryInfoStackView.addArrangedSubview(foodReserveView)
        foodDeliveryInfoStackView.addArrangedSubview(foodDeliveryInfoView)
        foodDeliveryInfoStackView.addArrangedSubview(foodDeliveryPriceView)
        
        foodReserveView.addSubview(foodReserveLabel)
        foodReserveView.addSubview(foodReserveValueLabel)
        
        foodDeliveryInfoView.addSubview(foodDeliveryInfoLabel)
        foodDeliveryInfoView.addSubview(foodDeliveryInfoValueLabel)
        
        foodDeliveryPriceView.addSubview(foodDeliveryPriceLabel)
        foodDeliveryPriceView.addSubview(foodDeliveryPriceValueLabel)
        
        foodCountView.addSubview(foodCountLabel)
        foodCountView.addSubview(foodCountValueLabel)
        foodCountView.addSubview(foodCountStepper)
        
        foodTotalPriceView.addSubview(foodTotalPriceLabel)
        foodTotalPriceView.addSubview(foodTotalPriceValueLabel)
    }
    
    private func setLayout() {
        NSLayoutConstraint.activate([
            commonScrollView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            commonScrollView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor),
            commonScrollView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor),
            commonScrollView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor),
            
            thumbnailImageScrollView.topAnchor.constraint(equalTo: commonScrollView.contentLayoutGuide.topAnchor),
            thumbnailImageScrollView.leadingAnchor.constraint(equalTo: commonScrollView.contentLayoutGuide.leadingAnchor),
            thumbnailImageScrollView.trailingAnchor.constraint(equalTo: commonScrollView.contentLayoutGuide.trailingAnchor),
            thumbnailImageScrollView.heightAnchor.constraint(equalToConstant: 300),
            thumbnailImageScrollView.widthAnchor.constraint(equalTo: commonScrollView.frameLayoutGuide.widthAnchor),
            
            foodInfoStackView.topAnchor.constraint(equalTo: thumbnailImageScrollView.bottomAnchor, constant: 18),
            foodInfoStackView.widthAnchor.constraint(equalTo: thumbnailImageScrollView.widthAnchor, multiplier: 0.85),
            foodInfoStackView.centerXAnchor.constraint(equalTo: thumbnailImageScrollView.frameLayoutGuide.centerXAnchor),
            
            foodSpecialPriceLabel.leadingAnchor.constraint(equalTo: foodPricesView.leadingAnchor),
            foodSpecialPriceLabel.centerYAnchor.constraint(equalTo: foodPricesView.centerYAnchor),
            foodNormalPriceLabel.leadingAnchor.constraint(equalTo: foodSpecialPriceLabel.trailingAnchor, constant: 15),
            foodNormalPriceLabel.centerYAnchor.constraint(equalTo: foodPricesView.centerYAnchor),
            
            foodDeliveryInfoStackView.topAnchor.constraint(equalTo: foodInfoStackView.bottomAnchor, constant: 18),
            foodDeliveryInfoStackView.widthAnchor.constraint(equalTo: foodInfoStackView.widthAnchor),
            foodDeliveryInfoStackView.centerXAnchor.constraint(equalTo: commonScrollView.centerXAnchor),
            
            foodReserveLabel.leadingAnchor.constraint(equalTo: foodReserveView.leadingAnchor),
            foodReserveLabel.widthAnchor.constraint(equalTo: foodDeliveryInfoStackView.widthAnchor, multiplier: 0.22),
            foodReserveLabel.topAnchor.constraint(equalTo: foodReserveView.topAnchor),
            foodReserveLabel.bottomAnchor.constraint(equalTo: foodReserveView.bottomAnchor),
            foodReserveValueLabel.leadingAnchor.constraint(equalTo: foodReserveLabel.trailingAnchor),
            foodReserveValueLabel.topAnchor.constraint(equalTo: foodReserveView.topAnchor),
            foodReserveValueLabel.bottomAnchor.constraint(equalTo: foodReserveView.bottomAnchor),
            
            foodDeliveryInfoLabel.leadingAnchor.constraint(equalTo: foodDeliveryInfoView.leadingAnchor),
            foodDeliveryInfoLabel.widthAnchor.constraint(equalTo: foodDeliveryInfoStackView.widthAnchor, multiplier: 0.22),
            foodDeliveryInfoLabel.topAnchor.constraint(equalTo: foodDeliveryInfoView.topAnchor),
            foodDeliveryInfoLabel.bottomAnchor.constraint(equalTo: foodDeliveryInfoView.bottomAnchor),
            foodDeliveryInfoValueLabel.leadingAnchor.constraint(equalTo: foodDeliveryInfoLabel.trailingAnchor),
            foodDeliveryInfoValueLabel.topAnchor.constraint(equalTo: foodDeliveryInfoView.topAnchor),
            foodDeliveryInfoValueLabel.bottomAnchor.constraint(equalTo: foodDeliveryInfoView.bottomAnchor),
            
            foodDeliveryPriceLabel.leadingAnchor.constraint(equalTo: foodDeliveryPriceView.leadingAnchor),
            foodDeliveryPriceLabel.widthAnchor.constraint(equalTo: foodDeliveryInfoStackView.widthAnchor, multiplier: 0.22),
            foodDeliveryPriceLabel.topAnchor.constraint(equalTo: foodDeliveryPriceView.topAnchor),
            foodDeliveryPriceLabel.bottomAnchor.constraint(equalTo: foodDeliveryPriceView.bottomAnchor),
            foodDeliveryPriceValueLabel.leadingAnchor.constraint(equalTo: foodDeliveryPriceLabel.trailingAnchor),
            foodDeliveryPriceValueLabel.topAnchor.constraint(equalTo: foodDeliveryPriceView.topAnchor),
            foodDeliveryPriceValueLabel.bottomAnchor.constraint(equalTo: foodDeliveryPriceView.bottomAnchor),
            
            foodCountView.widthAnchor.constraint(equalTo: foodInfoStackView.widthAnchor),
            foodCountView.centerXAnchor.constraint(equalTo: thumbnailImageScrollView.frameLayoutGuide.centerXAnchor),
            foodCountView.topAnchor.constraint(equalTo: foodDeliveryInfoStackView.bottomAnchor, constant: 25),
            foodCountLabel.leadingAnchor.constraint(equalTo: foodCountView.leadingAnchor),
            foodCountLabel.topAnchor.constraint(equalTo: foodCountView.topAnchor),
            foodCountLabel.bottomAnchor.constraint(equalTo: foodCountView.bottomAnchor),
            foodCountStepper.trailingAnchor.constraint(equalTo: foodCountView.trailingAnchor),
            foodCountStepper.topAnchor.constraint(equalTo: foodCountView.topAnchor),
            foodCountStepper.bottomAnchor.constraint(equalTo: foodCountView.bottomAnchor),
            foodCountValueLabel.trailingAnchor.constraint(equalTo: foodCountStepper.leadingAnchor, constant: -20),
            foodCountValueLabel.topAnchor.constraint(equalTo: foodCountView.topAnchor),
            foodCountValueLabel.bottomAnchor.constraint(equalTo: foodCountView.bottomAnchor),
            
            foodTotalPriceView.topAnchor.constraint(equalTo: foodCountView.bottomAnchor, constant: 25),
            foodTotalPriceView.widthAnchor.constraint(equalTo: foodInfoStackView.widthAnchor),
            foodTotalPriceView.centerXAnchor.constraint(equalTo: commonScrollView.centerXAnchor),
            foodTotalPriceValueLabel.trailingAnchor.constraint(equalTo: foodTotalPriceView.trailingAnchor),
            foodTotalPriceValueLabel.topAnchor.constraint(equalTo: foodTotalPriceView.topAnchor),
            foodTotalPriceValueLabel.bottomAnchor.constraint(equalTo: foodTotalPriceView.bottomAnchor),
            foodTotalPriceLabel.trailingAnchor.constraint(equalTo: foodTotalPriceValueLabel.leadingAnchor, constant: -20),
            foodTotalPriceLabel.topAnchor.constraint(equalTo: foodTotalPriceView.topAnchor),
            foodTotalPriceLabel.bottomAnchor.constraint(equalTo: foodTotalPriceView.bottomAnchor),
            
            foodOrderingButton.widthAnchor.constraint(equalTo: foodInfoStackView.widthAnchor),
            foodOrderingButton.centerXAnchor.constraint(equalTo: commonScrollView.centerXAnchor),
            foodOrderingButton.topAnchor.constraint(equalTo: foodTotalPriceView.bottomAnchor, constant: 25),
            foodOrderingButton.heightAnchor.constraint(equalToConstant: 50),

            foodDetailImageStackView.widthAnchor.constraint(equalTo: foodInfoStackView.widthAnchor),
            foodDetailImageStackView.centerXAnchor.constraint(equalTo: commonScrollView.centerXAnchor),
            foodDetailImageStackView.topAnchor.constraint(equalTo: foodOrderingButton.bottomAnchor, constant: 20),
            foodDetailImageStackView.heightAnchor.constraint(equalToConstant: 2300),
            foodDetailImageStackView.bottomAnchor.constraint(equalTo: commonScrollView.contentLayoutGuide.bottomAnchor)
        ])
    }
    
    func setFoodDetailInfo(foodTitle: String, foodDescription: String, foodDeliveryInfo: String, foodDeliveryPrice: String, foodPoint: String, foodPrices: [String]) {
        foodNameLabel.text = foodTitle
        foodDescriptionLabel.text = foodDescription
        foodDeliveryInfoValueLabel.text = foodDeliveryInfo
        foodDeliveryPriceValueLabel.text = foodDeliveryPrice
        foodReserveValueLabel.text = foodPoint
        
        if(foodPrices.count>=2){
            foodSpecialPriceLabel.text = foodPrices[0]
            foodNormalPriceLabel.text = foodPrices[1]
            foodNormalPriceLabel.textColor = .gray
        }else{
            foodNormalPriceLabel.text = foodPrices[0]
            adjustFoodPricesViewLayout()
        }
        
        func adjustFoodPricesViewLayout() {
            foodSpecialPriceLabel.removeFromSuperview()
            foodNormalPriceLabel.leadingAnchor.constraint(equalTo: foodPricesView.leadingAnchor).isActive = true
        }
    }
    
    func addThumbnailImage(imageData: Data) {
        let image = UIImage(data: imageData)
        let imageView = UIImageView(image: image)
        thumbnailImageScrollView.addSubview(imageView)
        adjustThumbnailImageViewLayout(imageView: imageView)
        
        func adjustThumbnailImageViewLayout(imageView: UIImageView) {
            imageView.translatesAutoresizingMaskIntoConstraints = false
            imageView.topAnchor.constraint(equalTo: thumbnailImageScrollView.frameLayoutGuide.topAnchor).isActive = true
            imageView.bottomAnchor.constraint(equalTo: thumbnailImageScrollView.frameLayoutGuide.bottomAnchor).isActive = true
            imageView.leadingAnchor.constraint(equalTo: thumbnailImageScrollView.leadingAnchor).isActive = true
            imageView.trailingAnchor.constraint(equalTo: thumbnailImageScrollView.frameLayoutGuide.trailingAnchor).isActive = true
        }
    }
    
    func addDetailImage(imageData: Data) {
        let image = UIImage(data: imageData)
        let imageView = UIImageView(image: image)
        foodDetailImageStackView.addArrangedSubview(imageView)
    }
    
    func adjustFoodDetailImageStackViewLayout(imageCount: Int) {
        if(imageCount <= 3) {
            foodDetailImageStackView.heightAnchor.constraint(equalToConstant: 1000).isActive = true
        }
    }
    
    func addStepperAction() {
        foodCountStepper.addAction(UIAction{ [weak self] _ in
            guard let stepper = self?.foodCountStepper else { return }
            self?.delegate?.changingSelectedFoodCountRequested(value: stepper.value)
        }, for: .valueChanged)
    }
    
}
