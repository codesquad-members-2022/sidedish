//
//  CarouselView.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

protocol CarouselViewDelegate: AnyObject {
    func carouselView(_ carouselView: CarouselView) -> UIView
    func carouselView(_ carouselView: CarouselView, numberOfItems: Int) -> Int
}

class CarouselView: UIView {
    private lazy var scrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.isPagingEnabled = true
        scrollView.isScrollEnabled = true
        scrollView.showsVerticalScrollIndicator = false
        scrollView.showsHorizontalScrollIndicator = false
        return scrollView
    }()

    private lazy var contentView = UIView()

    private lazy var stackView: UIStackView = {
        let stack = UIStackView()
        stack.axis = .horizontal
        return stack
    }()

    private lazy var pageControl: UIPageControl = {
        let rect = CGRect(x: 0, y: 0, width: 120, height: 25)
        let control = UIPageControl(frame: rect, primaryAction: UIAction(handler: self.handleOnSwipeItem))
        control.hidesForSinglePage = true
        return control
    }()

    private var itemView = UIView.self

    var delegate: CarouselViewDelegate?

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.configureUI()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.configureUI()
    }

    private func configureUI() {
        self.scrollView.addSubview(self.contentView)
        self.contentView.addSubview(self.stackView)
        self.contentView.addSubview(self.pageControl)

        self.scrollView.fill(inView: self)
        self.contentView.fill(inView: self.scrollView.contentLayoutGuide)
        self.contentView.setHeight(toAnchor: self.scrollView.frameLayoutGuide.widthAnchor)
        self.stackView.fill(inView: self.contentView)
        self.pageControl.anchor(bottom: self.contentView.bottomAnchor, paddingBottom: 10)
        self.pageControl.centerX(inLayoutGuide: self.scrollView.frameLayoutGuide)

        self.reloadData()
    }

    private func reloadData() {
        let currentCount = self.stackView.arrangedSubviews.count
        let count = self.delegate?.carouselView(self, numberOfItems: currentCount) ?? 0

        guard count > 1 else { return }

        self.resetItems()

        for _ in 1...count {
            let item = self.delegate?.carouselView(self) ?? itemView.init()
            item.setWidth(toAnchor: self.scrollView.frameLayoutGuide.widthAnchor)
            item.setHeight(toAnchor: self.scrollView.frameLayoutGuide.heightAnchor)
            self.stackView.addArrangedSubview(item)
        }
    }

    private func resetItems() {
        self.stackView.arrangedSubviews.forEach { view in
            self.stackView.removeArrangedSubview(view)
            view.removeFromSuperview()
        }
    }

    private func handleOnSwipeItem(_ action: UIAction) {}

    func register(item: UIView.Type) {
        self.itemView = item
    }
}
