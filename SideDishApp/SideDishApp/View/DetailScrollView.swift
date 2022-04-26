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
    
    private let detailContainerStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.spacing = 24
        stackView.axis = .vertical
        stackView.distribution = .equalSpacing
        return stackView
    }()
    
    private(set) var mainInfoStackView = MenuStackView()
    private(set) var subInfoStackView = MenuSubInfoContainerStackView()
    
    private let countContainerStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        return stackView
    }()
    
    private let countTitleLabel: UILabel = {
        let label = UILabel()
        label.text = "수량"
        label.textColor = .systemGray
        label.textAlignment = .left
        return label
    }()
    
    private let countLabel: UILabel = {
        let label = UILabel()
        label.text = "1"
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
    
    private let orderContainerStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.spacing = 24
        stackView.alignment = .trailing
        stackView.axis = .vertical
        stackView.distribution = .fill
        return stackView
    }()
    
    private let amountContainerStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 24
        return stackView
    }()
    
    private let amountTitleLabel: UILabel = {
        let label = UILabel()
        label.text = "총 주문금액"
        label.font = .boldSystemFont(ofSize: 18)
        label.textColor = .systemGray
        return label
    }()
    
    private let amountLabel: UILabel = {
        let label = UILabel()
        label.text = "12,640원"
        label.font = .boldSystemFont(ofSize: 32)
        return label
    }()
    
    private let orderButton: UIButton = {
        let button = UIButton()
        button.setTitle("주문하기", for: .normal)
        button.backgroundColor = .tintColor
        button.titleLabel?.font = .boldSystemFont(ofSize: 18)
        button.layer.cornerRadius = 10
        return button
    }()
    
    private let separatorView: UIView = {
        let view = UIView(frame: CGRect(x: 0, y: 0, width: 30, height: 30))
        view.backgroundColor = .systemGray5
        return view
    }()
    
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
        configureOverViewImageScrollView()
        
        contentView.addSubview(imagePageControl)
        configureImagePageControl()
        
        contentView.addSubview(detailContainerStackView)
        
        detailContainerStackView.addArrangedSubview(mainInfoStackView)
        mainInfoStackView.changeSpacingForDetailView()
        mainInfoStackView.changeFontForDetailView()
        detailContainerStackView.addArrangedSubview(UIView.makeSeparatorView())
        
        detailContainerStackView.addArrangedSubview(subInfoStackView)
        detailContainerStackView.addArrangedSubview(UIView.makeSeparatorView())
        
        detailContainerStackView.addArrangedSubview(countContainerStackView)
        countContainerStackView.addArrangedSubview(countTitleLabel)
        countContainerStackView.addArrangedSubview(countLabel)
        countContainerStackView.addArrangedSubview(countStepper)
        configureCountContainerStackView()
        
        detailContainerStackView.addArrangedSubview(UIView.makeSeparatorView())
        
        detailContainerStackView.addArrangedSubview(orderContainerStackView)
        orderContainerStackView.addArrangedSubview(amountContainerStackView)
        amountContainerStackView.addArrangedSubview(amountTitleLabel)
        amountContainerStackView.addArrangedSubview(amountLabel)
        orderContainerStackView.addArrangedSubview(orderButton)

        layoutContentView()
        layoutImagePageControl()
        layoutDetailContainerStackView()
        layoutCountTitleLabel()
        layoutOrderButton()
        
        amountTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        amountTitleLabel.widthAnchor.constraint(equalToConstant: 87).isActive = true
        
    }
    
    private func configureImagePageControl() {
        imagePageControl.numberOfPages = mockImages.count
        imagePageControl.currentPage = 0
        imagePageControl.pageIndicatorTintColor = .white
        imagePageControl.currentPageIndicatorTintColor = .systemBlue
    }
    
    private func configureOverViewImageScrollView() {
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
    
    private func layoutSeparatorView() {
        separatorView.translatesAutoresizingMaskIntoConstraints = false
        separatorView.widthAnchor.constraint(equalTo: mainInfoStackView.widthAnchor).isActive = true
        separatorView.heightAnchor.constraint(equalToConstant: 1).isActive = true
    }
    
    private func configureCountContainerStackView() {
        countContainerStackView.setCustomSpacing(150, after: countTitleLabel)
    }
    
    private func layoutCountTitleLabel() {
        countTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        countTitleLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
    }
    
    private func layoutOrderButton() {
        orderButton.translatesAutoresizingMaskIntoConstraints = false
        orderButton.leadingAnchor.constraint(equalTo: orderContainerStackView.leadingAnchor).isActive = true
        orderButton.heightAnchor.constraint(equalToConstant: 50).isActive = true
    }
}

// MARK: - Private Extension

private extension UIStackView {
    static func makeSubInfo(by description: [String]) -> UIStackView {
        let stackView = UIStackView()
        stackView.spacing = 16
        stackView.axis = .vertical
        
        for index in 0..<description.count {
            let eachStackView = UIStackView.makeSubInfoComponents(titleText: .allCases[index], descriptionText: description[index])
            stackView.addArrangedSubview(eachStackView)
        }
        
        return stackView
    }
    
    private static func makeSubInfoComponents(titleText: Constant.SubInfoTitle, descriptionText: String) -> UIStackView {
        let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.spacing = 16
        
        let titleLabel = UILabel()
        titleLabel.text = titleText.rawValue
        titleLabel.textColor = .systemGray
        
        let descriptionLabel = UILabel()
        descriptionLabel.text = descriptionText
        descriptionLabel.textColor = .darkGray
        
        stackView.addArrangedSubview(titleLabel)
        stackView.addArrangedSubview(descriptionLabel)
        
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.widthAnchor.constraint(equalToConstant: 60).isActive = true
        
        return stackView
    }
}

private extension UIView {
    static func makeSeparatorView() -> UIView {
        let view = UIView()
        view.backgroundColor = .systemGray4
        view.translatesAutoresizingMaskIntoConstraints = false
        view.heightAnchor.constraint(equalToConstant: 1).isActive = true
        return view
    }
}
