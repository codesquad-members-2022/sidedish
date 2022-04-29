//
//  DetailScrollView.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/22.
//

import UIKit

final class DetailScrollView: UIScrollView {
    
    var orderCount: Int = 1 {
        didSet {
            countLabel.text = "\(orderCount)"
        }
    }
    
    var amount: String = "" {
        didSet {
            amountLabel.text = amount
        }
    }
    
    private let contentView: UIView = {
        let view = UIView()
        view.backgroundColor = .systemBackground
        return view
    }()
    
    private(set) var overViewImageScrollView: UIScrollView = {
        let scrollView = UIScrollView()
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
        pageControl.pageIndicatorTintColor = .white
        pageControl.currentPageIndicatorTintColor = .systemBlue
        return pageControl
    }()
    
    private let detailContainerStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.spacing = 24
        stackView.axis = .vertical
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private(set) var mainInfoStackView = MenuStackView()
    private(set) var subInfoStackView = MenuSubInfoContainerStackView()
    
    private let countStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        return stackView
    }()
    
    private let countTitleLabel: UILabel = {
        let label = UILabel()
        label.text = Constant.DetailScrollText.count
        label.textColor = .systemGray
        label.textAlignment = .left
        return label
    }()
    
    private let countLabel: UILabel = {
        let label = UILabel()
        label.text = Constant.DetailScrollText.initialCount
        label.font = .boldSystemFont(ofSize: 18)
        label.textColor = .darkGray
        label.textAlignment = .center
        return label
    }()
    
    private(set) var countStepper: UIStepper = {
        let stepper = UIStepper()
        stepper.minimumValue = 1
        return stepper
    }()
    
    private let orderStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.spacing = 24
        stackView.alignment = .trailing
        stackView.axis = .vertical
        stackView.distribution = .fill
        return stackView
    }()
    
    private let amountStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 24
        return stackView
    }()
    
    private let amountTitleLabel: UILabel = {
        let label = UILabel()
        label.text = Constant.DetailScrollText.amount
        label.font = .boldSystemFont(ofSize: 18)
        label.textColor = .systemGray
        return label
    }()
    
    private let amountLabel: UILabel = {
        let label = UILabel()
        label.font = .boldSystemFont(ofSize: 32)
        return label
    }()
    
    private let orderButton: UIButton = {
        let button = UIButton()
        button.setTitle(Constant.DetailScrollText.order, for: .normal)
        button.backgroundColor = .tintColor
        button.titleLabel?.font = .boldSystemFont(ofSize: 18)
        button.layer.cornerRadius = 10
        return button
    }()
    
    private let recipeImageStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 0
        return stackView
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setUpView()
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setUpView() {
        configureView()
        
        addSubview(contentView)
        configureContentView()
        
        detailContainerStackView.addArrangedSubview(mainInfoStackView)
        configureMainInfoStackView()
        
        detailContainerStackView.addArrangedSubview(subInfoStackView)
        
        detailContainerStackView.addArrangedSubview(countStackView)
        configureCountStackView()
        
        detailContainerStackView.addArrangedSubview(orderStackView)
        configureOrderStackView()
        
        detailContainerStackView.addArrangedSubview(recipeImageStackView)
        
        insertSeparatorView()
        layoutComponents()
    }
    
    private func configureView() {
        backgroundColor = .systemBackground
    }
    
    private func configureContentView() {
        contentView.addSubview(overViewImageScrollView)
        contentView.addSubview(imagePageControl)
        contentView.addSubview(detailContainerStackView)
    }
    
    private func configureMainInfoStackView() {
        mainInfoStackView.changeSpacingForDetailView()
        mainInfoStackView.changeFontForDetailView()
    }
    
    private func configureCountStackView() {
        countStackView.addArrangedSubview(countTitleLabel)
        countStackView.addArrangedSubview(countLabel)
        countStackView.addArrangedSubview(countStepper)
        countStackView.setCustomSpacing(150, after: countTitleLabel)
    }
    
    private func configureOrderStackView() {
        orderStackView.addArrangedSubview(amountStackView)
        amountStackView.addArrangedSubview(amountTitleLabel)
        amountStackView.addArrangedSubview(amountLabel)
        orderStackView.addArrangedSubview(orderButton)
    }
    
    private func layoutComponents() {
        layoutContentView()
        layoutOverViewImageScrollView()
        layoutImagePageControl()
        layoutDetailContainerStackView()
        layoutCountTitleLabel()
        layoutOrderButton()
    }
    
    private func insertSeparatorView() {
        for index in stride(from: 1, to: 6, by: 2) {
            detailContainerStackView.insertArrangedSubview(UIView.makeSeparator(), at: index)
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
        contentLayoutGuide.bottomAnchor.constraint(equalTo: detailContainerStackView.bottomAnchor).isActive = true
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
    
    private func layoutDetailContainerStackView() {
        detailContainerStackView.translatesAutoresizingMaskIntoConstraints = false
        detailContainerStackView.topAnchor.constraint(equalTo: overViewImageScrollView.bottomAnchor, constant: 24).isActive = true
        detailContainerStackView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 16).isActive = true
        detailContainerStackView.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: -16).isActive = true
    }
    
    private func layoutCountTitleLabel() {
        countTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        countTitleLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
    }
    
    private func layoutOrderButton() {
        orderButton.translatesAutoresizingMaskIntoConstraints = false
        orderButton.leadingAnchor.constraint(equalTo: orderStackView.leadingAnchor).isActive = true
        orderButton.heightAnchor.constraint(equalToConstant: 50).isActive = true
    }
}

// MARK: - Providing Function

extension DetailScrollView {
    
    func setPrice(text: String) {
        amountLabel.text = "\(text)"
    }
    
    func setOverViewImageScrollContentSize(imageCount: Int) {
        imagePageControl.numberOfPages = imageCount
        overViewImageScrollView.contentSize = CGSize(width: overViewImageScrollView.frame.width * CGFloat(imageCount), height: 375)
    }
    
    func insertThumbNail(image: UIImage?, at index: Int) {
        let imageView = UIImageView(image: image)
        imageView.contentMode = .scaleToFill
        imageView.frame = self.overViewImageScrollView.frame
        imageView.frame.origin.x = self.overViewImageScrollView.frame.width * CGFloat(index)
        self.overViewImageScrollView.addSubview(imageView)
    }
    
    func addPlaceholderView(count: Int) {
        for _ in 0..<count {
            recipeImageStackView.addArrangedSubview(UIView())
        }
    }
    
    func setRecipe(image: UIImage?, at index: Int) {
        let imageView = UIImageView(image: image)
        
        let baseWidth = self.detailContainerStackView.frame.size.width
        guard let adjustedHeight = imageView.calculateAdjustedHeight(baseWidth: baseWidth) else { return }
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.heightAnchor.constraint(equalToConstant: adjustedHeight).isActive = true
        
        self.recipeImageStackView.insertArrangedSubview(imageView, at: index)
    }
}

// MARK: - Private Extension

private extension UIView {
    static func makeSeparator() -> UIView {
        let view = UIView()
        view.backgroundColor = .systemGray4
        view.translatesAutoresizingMaskIntoConstraints = false
        view.heightAnchor.constraint(equalToConstant: 1).isActive = true
        return view
    }
}

private extension UIImageView {
    func calculateAdjustedHeight(baseWidth: CGFloat) -> CGFloat? {
        guard let imageHeight = self.image?.size.height,
              let imageWidth = self.image?.size.width else { return nil }
        
        let imageRatio = imageHeight / imageWidth
        let adjustedImageHeight = baseWidth * imageRatio
        
        return adjustedImageHeight
    }
}
