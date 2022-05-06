//
//  ThumbnailImageView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import SnapKit
import UIKit

class ThumbnailImageView: UIView {
    
    private let detailScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.isScrollEnabled = true
        scrollView.isPagingEnabled = true
        scrollView.showsVerticalScrollIndicator = false
        scrollView.showsHorizontalScrollIndicator = false
        scrollView.bounces = false
        return scrollView
    }()
    
    private let pageControl: UIPageControl = {
        let paging = UIPageControl()
        paging.pageIndicatorTintColor = .white
        paging.currentPageIndicatorTintColor = .primary2
        return paging
    }()

    private let contentView = UIStackView()
    
    init() {
        super.init(frame: .zero)
        bind()
        layout()
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
    }
    
    private func bind() {
        detailScrollView.delegate = self
    }
    
    private func layout() {
        addSubview(detailScrollView)
        addSubview(pageControl)
        
        detailScrollView.addSubview(contentView)
        
        detailScrollView.snp.makeConstraints { make in
            make.edges.equalTo(safeAreaLayoutGuide)
        }
        
        detailScrollView.contentLayoutGuide.snp.makeConstraints { make in
            make.top.bottom.leading.equalToSuperview()
            make.trailing.equalTo(contentView)
        }
        
        pageControl.snp.makeConstraints { make in
            make.centerX.equalToSuperview()
            make.bottom.equalToSuperview().offset(-20)
        }
        
        contentView.snp.makeConstraints { make in
            make.top.bottom.leading.equalTo(detailScrollView)
        }
    }
        
    func makeImageView(count: Int) {
        pageControl.numberOfPages = count
        let imageViews = (0..<count).map { _ -> UIImageView in
            let imageView = UIImageView()
            contentView.addArrangedSubview(imageView)
            imageView.snp.makeConstraints { make in
                make.width.equalTo(detailScrollView)
            }
            return imageView
        }
        contentView.snp.makeConstraints { make in
            make.trailing.equalTo(imageViews[imageViews.count - 1])
        }
    }
    
    func setImage(_ index: Int, _ fileUrl: URL) {
        guard let imageView = contentView.subviews[index] as? UIImageView else {
            return
        }
        
        imageView.image = UIImage(contentsOfFile: fileUrl.path)
    }
}

extension ThumbnailImageView: UIScrollViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        pageControl.currentPage = Int(round(scrollView.contentOffset.x / detailScrollView.bounds.width))
    }
}
