//
//  ViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

// MARK: - 스토리 보드로 작업된 BanchanDetailViewController 코드로 옮기는 작업
class ViewController: UIViewController {
    private lazy var verticalScrollView: UIScrollView = {
        let scroll = UIScrollView()
        scroll.showsHorizontalScrollIndicator = false
        return scroll
    }()

    private lazy var carouselView = CarouselView()

    private lazy var productDescriptionImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleAspectFill
        imageView.image = UIImage(named: "dummy")
        return imageView
    }()

    override func viewDidLoad() {
        super.viewDidLoad()
        self.configureUI()
        self.carouselView.delegate = self
    }

    private func configureUI() {
        self.view.addSubview(self.verticalScrollView)

        // MARK: - ContentScrollView
        let verticalScrollContentView = UIView()

        self.verticalScrollView.fill(inView: self.view.safeAreaLayoutGuide)
        self.verticalScrollView.addSubview(verticalScrollContentView)

        verticalScrollContentView.fill(inView: self.verticalScrollView.contentLayoutGuide)
        verticalScrollContentView.setWidth(self.verticalScrollView.frameLayoutGuide.layoutFrame.width)

        // MARK: - CarouselView
        verticalScrollContentView.addSubview(self.carouselView)

        self.carouselView.anchor(top: verticalScrollContentView.topAnchor, leading: verticalScrollContentView.leadingAnchor, trailing: verticalScrollContentView.trailingAnchor, height: self.verticalScrollView.frameLayoutGuide.layoutFrame.width)

        // MARK: - SectionContainerView
        let sectionContainerView = UIView()
        verticalScrollContentView.addSubview(sectionContainerView)
        sectionContainerView.anchor(top: self.carouselView.bottomAnchor, bottom: verticalScrollContentView.bottomAnchor, leading: verticalScrollContentView.leadingAnchor, trailing: verticalScrollContentView.trailingAnchor, paddingTop: 24, paddingLeft: 16, paddingRight: 16)

        // MARK: - DescriptionContainerView
        let descriptionContainerView = UIView()
        sectionContainerView.addSubview(descriptionContainerView)
        descriptionContainerView.anchor(top: sectionContainerView.topAnchor, leading: sectionContainerView.leadingAnchor, trailing: sectionContainerView.trailingAnchor)

        // MARK: - DescriptionStack
        let descriptionStack = UIStackView()
        descriptionStack.axis = .vertical
        descriptionContainerView.addSubview(descriptionStack)
        descriptionStack.anchor(top: descriptionContainerView.topAnchor, leading: descriptionContainerView.leadingAnchor, trailing: descriptionContainerView.trailingAnchor)
        let productTitleLabel = UILabel()
        productTitleLabel.frame.size = productTitleLabel.intrinsicContentSize
        productTitleLabel.text = "오리 주물럭 반조리"

        let productSubtitleLabel = UILabel()
        productSubtitleLabel.frame.size = productSubtitleLabel.intrinsicContentSize
        productSubtitleLabel.text = "감칠맛 나는 매콤한 양념"

        let productPriceLabel = UILabel()
        productPriceLabel.frame.size = productPriceLabel.intrinsicContentSize
        productPriceLabel.text = "12,640원 15,800원"

        descriptionStack.addSubview(productTitleLabel)
        descriptionStack.addSubview(productSubtitleLabel)
        descriptionStack.addSubview(productPriceLabel)

        // MARK: - DeliveryInformationView
        let deliveryInformationStack = UIStackView()
        deliveryInformationStack.axis = .horizontal
        descriptionContainerView.addSubview(deliveryInformationStack)
        deliveryInformationStack.anchor(top: descriptionStack.bottomAnchor, leading: descriptionContainerView.leadingAnchor, trailing: descriptionContainerView.trailingAnchor, paddingTop: 24)

        let quantityView = UIView()
        descriptionContainerView.addSubview(quantityView)
        quantityView.anchor(top: deliveryInformationStack.bottomAnchor, leading: descriptionContainerView.leadingAnchor, trailing: descriptionContainerView.trailingAnchor, paddingTop: 24)

        let totalPriceLabel = UILabel()
        totalPriceLabel.text = "총 주문금액 12,640원"
        totalPriceLabel.textAlignment = .right
        descriptionContainerView.addSubview(totalPriceLabel)
        totalPriceLabel.anchor(top: quantityView.bottomAnchor, leading: descriptionContainerView.leadingAnchor, trailing: descriptionContainerView.trailingAnchor, paddingTop: 24)

        let orderButton = UIButton(type: .system)
        orderButton.setTitle("주문하기", for: .normal)
        descriptionContainerView.addSubview(orderButton)
        orderButton.setHeight(50)
        orderButton.anchor(top: totalPriceLabel.bottomAnchor, bottom: descriptionContainerView.bottomAnchor, leading: descriptionContainerView.leadingAnchor, trailing: descriptionContainerView.trailingAnchor, paddingTop: 24)

        // MARK: - ProductDescriptionImageView
        sectionContainerView.addSubview(self.productDescriptionImageView)
        self.productDescriptionImageView.anchor(top: descriptionContainerView.bottomAnchor, bottom: sectionContainerView.bottomAnchor, leading: sectionContainerView.leadingAnchor, trailing: sectionContainerView.trailingAnchor, paddingTop: 48)

    }
}

extension ViewController: CarouselViewDataSource {
    func carouselView(_ carouselView: CarouselView) -> UIView {
        let image = UIImageView()
        image.image = UIImage(named: "dummy")
        image.contentMode = .scaleAspectFit
        return image
    }

    func carouselView(_ carouselView: CarouselView, numberOfItems: Int) -> Int {
        return 4
    }
}
