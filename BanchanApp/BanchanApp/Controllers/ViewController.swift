//
//  ViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

// MARK: - 스토리 보드로 작업된 BanchanDetailViewController 코드로 옮기는 작업
class ViewController: UIViewController {
    private lazy var containerScrollView: UIScrollView = {
        let scroll = UIScrollView()
        scroll.showsHorizontalScrollIndicator = false
        return scroll
    }()

    private lazy var productDescriptionImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleAspectFill
        imageView.image = UIImage(named: "dummy")
        return imageView
    }()

    private lazy var carouselView = CarouselView()
    private lazy var containerContentView = UIView()
    private lazy var orderView = OrderView()

    override func viewDidLoad() {
        super.viewDidLoad()
        self.configureUI()
        self.carouselView.delegate = self
        self.orderView.delegate = self
    }

    private func configureContainerScrollView() {
        self.view.addSubview(self.containerScrollView)
        self.containerScrollView.addSubview(self.containerContentView)
        self.containerScrollView.fill(inView: self.view.safeAreaLayoutGuide)
        self.containerContentView.fill(inView: self.containerScrollView.contentLayoutGuide)
        self.containerContentView.setWidth(self.containerScrollView.frameLayoutGuide.layoutFrame.width)
    }

    private func configureCarouselView() {
        self.containerContentView.addSubview(self.carouselView)
        self.carouselView.anchor(
            top: self.containerContentView.topAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            height: self.containerScrollView.frameLayoutGuide.layoutFrame.width
        )
    }

    private func configureOrderView() {
        self.containerContentView.addSubview(self.orderView)
        self.orderView.anchor(
            top: self.carouselView.bottomAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            paddingTop: 24,
            paddingLeft: 16,
            paddingRight: 16
        )
    }

    private func configureProductDescriptionImageView() {
        self.containerContentView.addSubview(self.productDescriptionImageView)
        self.productDescriptionImageView.anchor(
            top: self.orderView.bottomAnchor,
            bottom: self.containerContentView.bottomAnchor,
            leading: self.containerContentView.leadingAnchor,
            trailing: self.containerContentView.trailingAnchor,
            paddingTop: 48,
            paddingLeft: 16,
            paddingRight: 16
        )
    }

    private func configureUI() {
        self.configureContainerScrollView()
        self.configureCarouselView()
        self.configureOrderView()
        self.configureProductDescriptionImageView()
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

extension ViewController: OrderViewDelegate {
    func orderViewDidTapOrderButton() {}
}
