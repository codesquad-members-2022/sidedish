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
        scrollView.bounces = false
        return scrollView
    }()
    
    private let pageControl: UIPageControl = {
        let paging = UIPageControl()
        paging.translatesAutoresizingMaskIntoConstraints = false
        paging.numberOfPages = 3
        paging.pageIndicatorTintColor = .gray
        paging.currentPageIndicatorTintColor = .black
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
        layout()
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        fatalError("Init with coder is unavailable")
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
    
    let color: [UIColor] = [.red, .purple, .primary2]
    
    func setImage(urls: [URL]) {
        let imageViews = urls.map { _ -> UIImageView in
            let imageView = UIImageView()
            imageView.translatesAutoresizingMaskIntoConstraints = false
            imageView.backgroundColor = color[ Int.random(in: 0..<color.count)]
            contentView.addArrangedSubview(imageView)
            return imageView
        }
        imageViews.forEach {
            $0.widthAnchor.constraint(equalTo: detailScrollView.widthAnchor).isActive = true
        }
        contentView.trailingAnchor.constraint(equalTo: imageViews[imageViews.count - 1].trailingAnchor).isActive = true
    }
}
