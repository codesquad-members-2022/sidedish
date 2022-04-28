//
//  ThumbnailImageView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import UIKit

class ThumbnailImageView: UIView {
    
    private let detailScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.isScrollEnabled = true
        scrollView.isPagingEnabled = true
        scrollView.showsVerticalScrollIndicator = false
        scrollView.showsHorizontalScrollIndicator = false
        scrollView.bounces = false
        return scrollView
    }()
    
    private let pageControl: UIPageControl = {
        let paging = UIPageControl()
        paging.translatesAutoresizingMaskIntoConstraints = false
        paging.pageIndicatorTintColor = .white
        paging.currentPageIndicatorTintColor = .primary2
        return paging
    }()
    
    // 스크롤뷰 안에는 스크롤 되는 컨텐츠뷰가 존재해야 스크롤 뷰가 정상적으로 동작
    // 스크롤 되는 모든 컴포넌트들은 모두 여기의 자식뷰
    private let contentView: UIStackView = {
        let view = UIStackView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
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
 
        NSLayoutConstraint.activate([
            detailScrollView.topAnchor.constraint(equalTo: safeAreaLayoutGuide.topAnchor),
            detailScrollView.bottomAnchor.constraint(equalTo: safeAreaLayoutGuide.bottomAnchor),
            detailScrollView.leadingAnchor.constraint(equalTo: safeAreaLayoutGuide.leadingAnchor),
            detailScrollView.trailingAnchor.constraint(equalTo: safeAreaLayoutGuide.trailingAnchor),
            
            detailScrollView.contentLayoutGuide.topAnchor.constraint(equalTo: topAnchor),
            detailScrollView.contentLayoutGuide.bottomAnchor.constraint(equalTo: bottomAnchor),
            detailScrollView.contentLayoutGuide.leadingAnchor.constraint(equalTo: leadingAnchor),
            detailScrollView.contentLayoutGuide.trailingAnchor.constraint(equalTo: contentView.trailingAnchor),
            
            pageControl.centerXAnchor.constraint(equalTo: centerXAnchor),
            pageControl.bottomAnchor.constraint(equalTo: bottomAnchor, constant: -20),
            
            contentView.topAnchor.constraint(equalTo: detailScrollView.topAnchor),
            contentView.bottomAnchor.constraint(equalTo: detailScrollView.bottomAnchor),
            contentView.leadingAnchor.constraint(equalTo: detailScrollView.leadingAnchor)
        ])
    }
        
    func makeImageView(count: Int) {
        pageControl.numberOfPages = count
        let imageViews = (0..<count).map { _ -> UIImageView in
            let imageView = UIImageView()
            imageView.translatesAutoresizingMaskIntoConstraints = false
            contentView.addArrangedSubview(imageView)
            imageView.widthAnchor.constraint(equalTo: detailScrollView.widthAnchor).isActive = true
            return imageView
        }
        contentView.trailingAnchor.constraint(equalTo: imageViews[imageViews.count - 1].trailingAnchor).isActive = true
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
