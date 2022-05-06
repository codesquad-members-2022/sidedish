//
//  SidedishDetailViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import UIKit

class MenuDetailViewController: UIViewController {
    private var cancellables = Set<AnyCancellable>()
    private let model: MenuDetailViewModelProtcol

    private let scrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.isPagingEnabled = false
        return scrollView
    }()

    private let contentView = UIView()

    private let thumbnailImageView = ThumbnailImageView()
    
    private let infoStackView: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 24
        return stackView
    }()
    
    private let infoView: MenuInfoView = {
        let attribute = MenuInfoAttribute()
        attribute.lineSpacing = 8
        attribute.titleFont = .systemFont(ofSize: 32, weight: .regular)
        attribute.titleTextColor = .black
        attribute.discriptionFont = .systemFont(ofSize: 18, weight: .regular)
        attribute.discriptionTextColor = .grey2
        attribute.priceFont = .systemFont(ofSize: 18, weight: .regular)
        attribute.priceTextColor = .grey1
        attribute.salePriceFont = .systemFont(ofSize: 16)
        attribute.salePriceTextColor = .grey2
        attribute.badgeStackViewSpacing = 4
        let view = MenuInfoView(attribute: attribute)
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let subInfoView = MenuSubInfoView()
    
    private let amountView = MenuAmountView()
    
    private let orderView = MenuOrderView()
    
    private let sectionView = MenuSectionView()

    private let separator = (0..<3).map { _ -> UIView in
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .grey3
        return view
    }
    
    deinit {
        Log.debug("DeInit MenuDetailViewController")
    }
    
    init(model: MenuDetailViewModelProtcol) {
        self.model = model
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable)
    required init?(coder: NSCoder) {
        nil
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attribute()
        layout()

        model.action().loadMenuDetail.send()
    }

    private func bind() {
        model.state().loadedDetail
            .receive(on: DispatchQueue.main)
            .sink { [weak self] menu, detail in
                self?.title = menu.title
                self?.infoView.changeTitleLabel(text: menu.title)
                self?.infoView.changeDescriptionLabel(text: menu.description)
                self?.infoView.changePriceLabel(price: menu.price)
                self?.infoView.changeSalePriceLabel(price: menu.salePrice)
                self?.infoView.changeSaleBadge(menu.badge)
                self?.subInfoView.setData(detail)
                self?.orderView.setTotalPrice(menu.price)
                self?.thumbnailImageView.makeImageView(count: detail.thumbImages.count)
                self?.sectionView.makeImageView(count: detail.detailSection.count)
            }.store(in: &cancellables)

        model.state().showError
            .sink { _ in
                //TODO: 에러 처리
            }.store(in: &cancellables)

        amountView.plusPublisher
            .sink(receiveValue: model.action().tappedPlusButton.send(_:))
            .store(in: &cancellables)

        amountView.minusPublisher
            .sink(receiveValue: model.action().tappedMinusButton.send(_:))
            .store(in: &cancellables)

        model.state().amount
            .sink { [weak self] amount in
                self?.amountView.amount = amount
            }
            .store(in: &cancellables)
        
        model.state().totalPrice
            .sink { [weak self] totalPrice in
                self?.orderView.setTotalPrice(totalPrice)
            }
            .store(in: &cancellables)

        orderView.orderPublisher
            .sink(receiveValue: model.action().tappedOrderButton.send(_:))
            .store(in: &cancellables)

        model.state().ordered
            .receive(on: DispatchQueue.main)
            .sink { [weak self] _ in
                let alert = UIAlertController(title: "주문완료 ✅", message: "", preferredStyle: .alert)
                alert.addAction(UIAlertAction(title: "완료", style: .cancel))
                self?.present(alert, animated: true)
            }.store(in: &cancellables)
        
        model.state().loadedThumbnail
            .receive(on: DispatchQueue.main)
            .sink(receiveValue: thumbnailImageView.setImage(_:_:))
            .store(in: &cancellables)
        
        model.state().loadedDetailSection
            .receive(on: DispatchQueue.main)
            .sink(receiveValue: sectionView.setImage(_:_:))
            .store(in: &cancellables)
    }

    private func attribute() {
        view.backgroundColor = .white
    }

    private func layout() {
        view.addSubview(scrollView)
        scrollView.addSubview(contentView)
        contentView.addSubview(thumbnailImageView)
        contentView.addSubview(infoStackView)

        let infoViews = [infoView, separator[0], subInfoView, separator[1], amountView, separator[2], orderView, sectionView]
        infoViews.forEach {
            infoStackView.addArrangedSubview($0)
        }
        
        separator.forEach {
            $0.snp.makeConstraints {
                $0.height.equalTo(1)
            }
        }

        scrollView.snp.makeConstraints {
            $0.top.bottom.leading.trailing.equalTo(view.safeAreaLayoutGuide)
            $0.top.bottom.equalTo(view.safeAreaLayoutGuide)
        }
        
        scrollView.contentLayoutGuide.snp.makeConstraints {
            $0.top.leading.trailing.equalTo(view.safeAreaLayoutGuide)
            $0.bottom.equalTo(contentView.snp.bottom)
        }
        
        contentView.snp.makeConstraints {
            $0.top.leading.trailing.equalTo(scrollView)
            $0.bottom.equalTo(infoStackView)
        }
        
        thumbnailImageView.snp.makeConstraints {
            $0.top.leading.trailing.equalTo(contentView)
            $0.height.equalTo(contentView.snp.width)
        }
        
        infoStackView.snp.makeConstraints {
            $0.leading.trailing.equalTo(contentView).inset(16)
            $0.top.equalTo(thumbnailImageView.snp.bottom).offset(24)
            $0.bottom.equalTo(infoViews[infoViews.count - 1])
        }
    }
}
