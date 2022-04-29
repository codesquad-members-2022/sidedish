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

    // MARK: - Life Cycle
    override func viewDidLoad() {
        super.viewDidLoad()
		self.view.backgroundColor = .systemBackground

        self.configureUI()
        self.productImageCarouselView.delegate = self
        self.quantityView.delegate = self
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

		self.productDetailView.setTitleText("오리 주물럭_반조리", font: .textLargeBold)
		self.productDetailView.setDescriptionText("감칠맛 나는 매콤한 양념", font: .textMediumRegular)
		self.productDetailView.setNormalPrice("15,800원", font: .textMediumRegular)
		self.productDetailView.setSalePrice("12,640원", font: .textMediumBold)
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

		let urls = [
			"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D1.jpg",
			"http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D2.jpg",
			"http://public.codesquad.kr/jk/storeapp/data/pakage_regular.jpg"
		]

		let group = DispatchGroup()

		// TODO: 순서대로 담아야함
		var images = [Data]()

		for urlString in urls {
			guard let url = URL(string: urlString) else { continue }

			group.enter()

			URLSession.shared.dataTask(with: url) { data, _, error in
				guard let data = data, error == nil else {
					group.leave()
					return
				}

				group.leave()
				images.append(data)
			}.resume()
		}

		group.notify(queue: .main) { [weak self] in
			for data in images {
				guard let image = UIImage(data: data), let ratio = image.getAspectRatio() else { return }

				let imageView = UIImageView(image: image)

				imageView.contentMode = .scaleAspectFit

				self?.productDescriptionImageStack.addArrangedSubview(imageView)

				imageView.translatesAutoresizingMaskIntoConstraints = false
				imageView.widthAnchor.constraint(equalTo: imageView.heightAnchor, multiplier: ratio).isActive = true
			}
		}
	}

	// MARK: - Action Method
    private func handleOnTapOrderButton(_ action: UIAction) {
        self.delegate?.didRequestOrder()
    }
}

extension BanchanDetailViewController: CarouselViewDataSource {
    func carouselView(_ carouselView: CarouselView, index: Int) -> UIView {
        let image = UIImageView()
        // TODO: get image url from ViewModel
        image.image = UIImage(systemName: "suitcase.cart")
        image.contentMode = .scaleAspectFit
        return image
    }

    func carouselView(_ carouselView: CarouselView, numberOfItems: Int) -> Int {
        // TODO: get total image count from ViewModel
        return 4
    }

}

extension BanchanDetailViewController: QuantityViewDelegate {

    func quantityViewDidChangeValue(value: Double) {
        // TODO: Update ViewModel
        // 1. Update quantity to ViewModel
        // 2. Get point from ViewModel
        // 3. Update point Label
    }

}
