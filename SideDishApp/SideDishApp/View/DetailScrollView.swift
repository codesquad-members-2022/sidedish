//
//  DetailScrollView.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/22.
//

import UIKit

final class DetailScrollView: UIScrollView {
    
    private var mockImages = ["mockImage.png", "mockImage.png"]
    
    private let contentView: UIView = {
        let view = UIView()
        view.backgroundColor = .systemBackground
        return view
    }()
    
    private(set) var overViewImageScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.backgroundColor = .green
        scrollView.alwaysBounceVertical = false
        scrollView.showsHorizontalScrollIndicator = false
        scrollView.showsVerticalScrollIndicator = false
        scrollView.isScrollEnabled = true
        scrollView.isPagingEnabled = true
        scrollView.bounces = false
        return scrollView
    }()
    
    private(set) var imagePageControl: UIPageControl = {
        let pageControl = UIPageControl()
        pageControl.backgroundColor = .red
        return pageControl
    }()
    
    private(set) var menuStackView = MenuStackView()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }

    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    private func setUpView() {
        addSubview(contentView)
        contentView.addSubview(overViewImageScrollView)
        contentView.addSubview(imagePageControl)
        contentView.addSubview(menuStackView)
        menuStackView.changeSpacingForDetailView()
        menuStackView.changeFontForDetailView()
        
        layoutContentView()
        layoutImagePageControl()
        layoutMenuStackView()
        
        imagePageControl.numberOfPages = mockImages.count
        imagePageControl.currentPage = 0
        imagePageControl.pageIndicatorTintColor = .white
        imagePageControl.currentPageIndicatorTintColor = .systemBlue
        
        overViewImageScrollView.frame = CGRect(x: 0, y: 0, width: UIScreen.main.bounds.width, height: 375)
        overViewImageScrollView.contentSize = CGSize(width: UIScreen.main.bounds.width * CGFloat(mockImages.count), height: 375)
        
        for (index, imageName) in mockImages.enumerated() {
            let image = UIImage(named: imageName)
            let imageView = UIImageView(image: image)
            imageView.contentMode = .scaleToFill
            
            imageView.frame = overViewImageScrollView.frame
            imageView.frame.origin.x = UIScreen.main.bounds.width * CGFloat(index)
            overViewImageScrollView.addSubview(imageView)
        }
    }
}

// MARK: - View Layout

extension DetailScrollView {
    private func layoutContentView() {
        contentView.translatesAutoresizingMaskIntoConstraints = false
        contentView.topAnchor.constraint(equalTo: contentLayoutGuide.topAnchor).isActive = true
        contentView.bottomAnchor.constraint(equalTo: contentLayoutGuide.bottomAnchor).isActive = true
        contentView.leadingAnchor.constraint(equalTo: contentLayoutGuide.leadingAnchor).isActive = true
        contentView.trailingAnchor.constraint(equalTo: contentLayoutGuide.trailingAnchor).isActive = true
        
        contentView.widthAnchor.constraint(equalTo: frameLayoutGuide.widthAnchor).isActive = true
        contentView.heightAnchor.constraint(equalTo: frameLayoutGuide.heightAnchor).isActive = true
    }
    
    private func layoutOverViewImageScrollView() {
        overViewImageScrollView.translatesAutoresizingMaskIntoConstraints = false
        overViewImageScrollView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        overViewImageScrollView.centerXAnchor.constraint(equalTo: contentView.centerXAnchor).isActive = true
        overViewImageScrollView.widthAnchor.constraint(equalTo: contentView.widthAnchor).isActive = true
        overViewImageScrollView.heightAnchor.constraint(equalToConstant: 375).isActive = true
    }
    
    private func layoutImagePageControl() {
        imagePageControl.translatesAutoresizingMaskIntoConstraints = false
        imagePageControl.bottomAnchor.constraint(equalTo: overViewImageScrollView.bottomAnchor, constant: -18).isActive = true
        imagePageControl.centerXAnchor.constraint(equalTo: overViewImageScrollView.centerXAnchor).isActive = true
    }
    
    private func layoutMenuStackView() {
        menuStackView.translatesAutoresizingMaskIntoConstraints = false
        menuStackView.topAnchor.constraint(equalTo: overViewImageScrollView.bottomAnchor, constant: 24).isActive = true
        menuStackView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16).isActive = true
        menuStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16).isActive = true
    }
}
