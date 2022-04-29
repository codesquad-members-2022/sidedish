//
//  ViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

protocol BanchanViewControllerDelegate: AnyObject {
    func didRequestOrder()
}

class BanchanDetailViewController: UIViewController {

    // MARK: - Container View(Vertical Scroll View)
    private lazy var containerScrollView: UIScrollView = {
        let scroll = UIScrollView()

        scroll.showsHorizontalScrollIndicator = false

        return scroll
    }()

    private lazy var productDescriptionImageStack: UIStackView = {
        let stack = UIStackView()

        stack.axis = .vertical
        stack.distribution = .fillProportionally

        return stack
    }()

    // MARK: - Carousel View
    private lazy var productImageCarouselView = CarouselView()
    private lazy var containerContentView = UIView()

    // MARK: - Order View
    private lazy var orderView = UIView()

    private lazy var productDetailView = ProductDetailView()

    private lazy var deliveryInformationContainerStack: UIStackView = {
        let stack = UIStackView()

        stack.axis = .horizontal
        stack.spacing = 16
        stack.distribution = .fillProportionally

        return stack
    }()

    private lazy var deliveryInformationCategoryStack: UIStackView = {
        let stack = UIStackView()

        stack.axis = .vertical
        stack.spacing = 16
        stack.distribution = .fillEqually

        return stack
    }()

    private lazy var deliveryInformationCategoryValueStack: UIStackView = {
        let stack = UIStackView()

        stack.axis = .vertical
        stack.spacing = 16
        stack.distribution = .fillEqually

        return stack
    }()

    private lazy var pointLabel: UILabel = {
        let label = UILabel()

        label.font = .textSmallRegular
        label.textColor = .gray1

        return label
    }()

    private lazy var deliveryInformationLabel: UILabel = {
        let label = UILabel()

        label.font = .textSmallRegular
        label.textColor = .gray1

        return label
    }()

    private lazy var deliveryFeeLabel: UILabel = {
        let label = UILabel()

        label.font = .textSmallRegular
        label.textColor = .gray1

        return label
    }()

    private lazy var totalPriceLabel: PriceTag = {
        let label = PriceTag()

        label.price = "15,000원"

        return label
    }()

    private lazy var quantityView = QuantityView()

    private lazy var orderButton: UIButton = {
        let configuration = UIButton.Configuration.filled()
        let button = UIButton(
            configuration: configuration,
            primaryAction: UIAction(handler: self.handleOnTapOrderButton)
        )

        button.titleLabel?.font = .textMediumBold
        button.setTitle("주문하기", for: .normal)

        return button
    }()

    // MARK: - Properties
    weak var delegate: BanchanViewControllerDelegate?
    var viewModel: BanchanDetailViewModel?

    // MARK: - Life Cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .systemBackground

        self.configureUI()
        self.productImageCarouselView.delegate = self
        self.quantityView.delegate = self
        self.viewModel?.getBanchanDetail()
        self.bind()
    }

    private func bind() {
        self.viewModel?.descriptor.bind(subscriber: { detail in
            guard let viewModel = self.viewModel, let detail = detail else { return }
            let banchanInfo  = viewModel.getBanchanInfo()
            self.productDetailView.setTitleText(banchanInfo.title, font: .textLargeBold)
            self.productDetailView.setDescriptionText(banchanInfo.description, font: .textMediumRegular)
            self.productDetailView.setBadgeList(banchanInfo.badges)
            self.productDetailView.setSalePrice(banchanInfo.salePrice, font: .textMediumRegular)

            if let normalPrice = banchanInfo.normalPrice {
                self.productDetailView.setNormalPrice(normalPrice, font: .textMediumBold)
            }

            self.pointLabel.text = detail.point
            self.deliveryFeeLabel.text = detail.deliveryFee
            self.deliveryInformationLabel.text = detail.deliveryInfo

            viewModel.getThumbnails()
            viewModel.getSectionImages()
        })

        self.viewModel?.thumbnailImages.bind(subscriber: { images in
            guard !images.isEmpty else { return }
            self.productImageCarouselView.reloadData()
        })

        self.viewModel?.sectionImages.bind(subscriber: { images in
            for data in images {
                guard let image = UIImage(data: data), let ratio = image.getAspectRatio() else { return }

                let imageView = UIImageView(image: image)

                imageView.contentMode = .scaleAspectFit

                self.productDescriptionImageStack.addArrangedSubview(imageView)

                imageView.translatesAutoresizingMaskIntoConstraints = false
                imageView.widthAnchor.constraint(equalTo: imageView.heightAnchor, multiplier: ratio).isActive = true
            }
        })
    }

    private func configureUI() {
        self.configureContainerScrollView()
        self.configureCarouselView()
        self.configureOrderView()
        self.configureProductDescriptionImageStack()
    }

    // MARK: - UI Configurations
    private func configureContainerScrollView() {
        self.view.addSubview(self.containerScrollView)
        self.containerScrollView.addSubview(self.containerContentView)
        self.containerScrollView.fill(inView: self.view.safeAreaLayoutGuide)
        self.containerContentView.fill(inView: self.containerScrollView.contentLayoutGuide)
        self.containerContentView.widthAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.widthAnchor).isActive = true
    }

    private func configureCarouselView() {
        self.containerContentView.addSubview(self.productImageCarouselView)
        self.productImageCarouselView.anchor(
            top: self.containerContentView.topAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            height: self.containerScrollView.frameLayoutGuide.layoutFrame.width
        )
    }

    // MARK: - OrderView Config
    private func configureOrderView() {
        self.containerContentView.addSubview(self.orderView)
        self.orderView.anchor(
            top: self.productImageCarouselView.bottomAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            paddingTop: 24,
            paddingLeft: 16,
            paddingRight: 16
        )

        self.configureProductDetailView()
        self.configureDeliveryInformationView()
        self.configureQuantityView()
        self.configureTotalPriceLabel()
        self.configureOrderButton()
    }

    // MARK: - OrderView Configuration
    private func configureProductDetailView() {
        self.orderView.addSubview(self.productDetailView)
        self.productDetailView.anchor(
            top: self.orderView.topAnchor,
            leading: self.orderView.leadingAnchor,
            trailing: self.orderView.trailingAnchor
        )

//        self.productDetailView.setTitleText("오리 주물럭_반조리", font: .textLargeBold)
//        self.productDetailView.setDescriptionText("감칠맛 나는 매콤한 양념", font: .textMediumRegular)
//        self.productDetailView.setNormalPrice("15,800원", font: .textMediumRegular)
//        self.productDetailView.setSalePrice("12,640원", font: .textMediumBold)
    }

    private func configureDeliveryInformationView() {
        self.orderView.addSubview(self.deliveryInformationContainerStack)
        self.deliveryInformationContainerStack.anchor(
            top: self.productDetailView.bottomAnchor,
            leading: self.orderView.leadingAnchor,
            trailing: self.orderView.trailingAnchor,
            paddingTop: 24
        )

        // MARK: - deliveryInformationCategoryStack
        self.deliveryInformationContainerStack.addArrangedSubview(self.deliveryInformationCategoryStack)

        let pointCategory = UILabel()
        let deliveryInformationCategory = UILabel()
        let deliveryFeeCategory = UILabel()

        pointCategory.text = "적립금"
        pointCategory.font = .textSmallRegular
        pointCategory.textColor = .gray2

        deliveryInformationCategory.text = "배송정보"
        deliveryInformationCategory.font = .textSmallRegular
        deliveryInformationCategory.textColor = .gray2

        deliveryFeeCategory.text = "배송비"
        deliveryFeeCategory.font = .textSmallRegular
        deliveryFeeCategory.textColor = .gray2

        self.deliveryInformationCategoryStack.addArrangedSubview(pointCategory)
        self.deliveryInformationCategoryStack.addArrangedSubview(deliveryInformationCategory)
        self.deliveryInformationCategoryStack.addArrangedSubview(deliveryFeeCategory)

        // MARK: - deliveryInformationCategoryValueStack
        self.deliveryInformationContainerStack.addArrangedSubview(self.deliveryInformationCategoryValueStack)

        self.pointLabel.text = "126원"
        self.deliveryInformationLabel.text = "서울 경기 새벽 배송, 전국 택배 배송"
        self.deliveryFeeLabel.text = "2,500원 (40,000원 이상 구매 시 무료)"

        self.deliveryInformationCategoryValueStack.addArrangedSubview(pointLabel)
        self.deliveryInformationCategoryValueStack.addArrangedSubview(deliveryInformationLabel)
        self.deliveryInformationCategoryValueStack.addArrangedSubview(deliveryFeeLabel)
    }

    private func configureQuantityView() {
        self.orderView.addSubview(self.quantityView)
        self.quantityView.anchor(
            top: self.deliveryInformationContainerStack.bottomAnchor,
            leading: self.orderView.leadingAnchor,
            trailing: self.orderView.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureTotalPriceLabel() {
        self.orderView.addSubview(self.totalPriceLabel)
        self.totalPriceLabel.anchor(
            top: self.quantityView.bottomAnchor,
            leading: self.orderView.leadingAnchor,
            trailing: self.orderView.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureOrderButton() {
        self.orderView.addSubview(self.orderButton)
        self.orderButton.setHeight(50)
        self.orderButton.anchor(
            top: totalPriceLabel.bottomAnchor,
            bottom: self.orderView.bottomAnchor,
            leading: self.orderView.leadingAnchor,
            trailing: self.orderView.trailingAnchor,
            paddingTop: 24
        )
    }

    private func configureProductDescriptionImageStack() {
        self.containerContentView.addSubview(self.productDescriptionImageStack)
        self.productDescriptionImageStack.anchor(
            top: self.orderView.bottomAnchor,
            bottom: self.containerContentView.bottomAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            paddingTop: 48,
            paddingLeft: 16,
            paddingRight: 16
        )
    }

    // MARK: - Action Method
    private func handleOnTapOrderButton(_ action: UIAction) {
        self.delegate?.didRequestOrder()
    }
}

extension BanchanDetailViewController: CarouselViewDataSource {
    func carouselView(_ carouselView: CarouselView, index: Int) -> UIView {
        let imageView = UIImageView()

        guard let data = self.viewModel?.thumbnailImages.value[index], let image = UIImage(data: data) else {
            return imageView
        }

        imageView.image = image
        imageView.contentMode = .scaleAspectFit

        return imageView
    }

    func carouselView(_ carouselView: CarouselView, numberOfItems: Int) -> Int {
        return self.viewModel?.thumbnailCount ?? 0
    }
}

extension BanchanDetailViewController: QuantityViewDelegate {
    func quantityViewDidChangeValue(value: Double) {
        self.viewModel?.updateQuantity(value)
        self.totalPriceLabel.price = self.viewModel?.totalPrice ?? "0원"

    }
}
