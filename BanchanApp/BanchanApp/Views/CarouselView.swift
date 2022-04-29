//
//  CarouselView.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

protocol CarouselViewDataSource: AnyObject {
    // Item View
    func carouselView(_ carouselView: CarouselView, index: Int) -> UIView

    // Item 개수
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
        let control = UIPageControl(frame: rect, primaryAction: UIAction(handler: self.handleOnChangePageIndex))

        control.hidesForSinglePage = true
        control.pageIndicatorTintColor = .systemGray5
        control.currentPageIndicatorTintColor = UIColor.tintColor
        return control
    }()

    private var itemView = UIView.self

    weak var delegate: CarouselViewDataSource? {
        didSet {
            self.reloadData()
        }
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.configureUI()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.configureUI()
    }

    private func configureUI() {
        self.scrollView.delegate = self

        self.addSubview(self.scrollView)
        self.scrollView.addSubview(self.contentView)
        self.contentView.addSubview(self.stackView)
        self.contentView.addSubview(self.pageControl)

        self.scrollView.fill(inView: self)
        self.contentView.fill(inView: self.scrollView.contentLayoutGuide)
        self.contentView.setHeight(toAnchor: self.scrollView.frameLayoutGuide.heightAnchor)
        self.stackView.fill(inView: self.contentView)
        self.pageControl.anchor(bottom: self.contentView.bottomAnchor, paddingBottom: 10)
        self.pageControl.centerX(inLayoutGuide: self.scrollView.frameLayoutGuide)
    }

    func reloadData() {
        let currentCount = self.stackView.arrangedSubviews.count
        let count = self.delegate?.carouselView(self, numberOfItems: currentCount) ?? 0

        guard count > 1 else { return }

        self.stackView.clearSubviews()

        for index in 0..<count {
            let item = self.delegate?.carouselView(self, index: index) ?? itemView.init()
            self.stackView.addArrangedSubview(item)
            item.setWidth(toAnchor: self.scrollView.frameLayoutGuide.widthAnchor)
            item.setHeight(toAnchor: self.scrollView.frameLayoutGuide.heightAnchor)
        }

        self.pageControl.numberOfPages = count
    }

    private func handleOnChangePageIndex(_ action: UIAction) {
        var frame = self.scrollView.frameLayoutGuide.layoutFrame
        let pageNumber = self.pageControl.currentPage
        let offsetX = frame.width * CGFloat(pageNumber)

        frame.origin.x = offsetX

        self.scrollView.scrollRectToVisible(frame, animated: true)
    }

    func register(item: UIView.Type) {
        self.itemView = item
    }

}

extension CarouselView: UIScrollViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        let offsetX = self.scrollView.contentOffset.x
        let width = self.scrollView.frameLayoutGuide.layoutFrame.width
        let pageIndex = round(offsetX / width)

        self.pageControl.currentPage = Int(pageIndex)
    }
}
