//
//  SidedishDetailViewController.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/18.
//

import Combine
import UIKit

class MenuDetailViewController: UIViewController {
    
    private let scrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.isPagingEnabled = false
        return scrollView
    }()
    
    private let contentView: UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    private let thumbnailImageView: ThumbnailImageView = {
        let thumbnailView = ThumbnailImageView()
        thumbnailView.translatesAutoresizingMaskIntoConstraints = false
        thumbnailView.backgroundColor = .red
        return thumbnailView
    }()
    
    private let menuInfoView: MenuInfoView = {
        let infoView = MenuInfoView()
        infoView.translatesAutoresizingMaskIntoConstraints = false
        return infoView
    }()
    
    private let menuSubInfoView: MenuSubInfoView = {
        let subInfoView = MenuSubInfoView()
        subInfoView.translatesAutoresizingMaskIntoConstraints = false
        return subInfoView
    }()
    
    private let amountView: MenuAmountView = {
        let amountView = MenuAmountView()
        amountView.translatesAutoresizingMaskIntoConstraints = false
        return amountView
    }()
    
    private var cancellables = Set<AnyCancellable>()
    private let model: MenuDetailViewModelProtcol
    
    init(model: MenuDetailViewModelProtcol) {
        self.model = model
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        self.model = MenuDetailViewModel(menu: Sidedish.dummy)
        super.init(coder: coder)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        bind()
        attribute()
        layout()
        
        model.action.loadMenuDetail.send()
    }
    
    private func bind() {
        model.state.loadedDetail
            .receive(on: DispatchQueue.main)
            .sink { menu, detail in
                self.title = detail.description
                self.menuInfoView.setData(menu)
                self.menuSubInfoView.setData(detail)
            }.store(in: &cancellables)
        
        model.state.showError
            .sink {
                print($0)
            }.store(in: &cancellables)
        
        amountView.plusPublisher
            .sink(receiveValue: model.action.plusAmount.send(_:))
            .store(in: &cancellables)
        
        amountView.minusPublisher
            .sink(receiveValue: model.action.minusAmount.send(_:))
            .store(in: &cancellables)
        
        model.state.amount
            .sink {
                self.amountView.amount = $0
            }
            .store(in: &cancellables)
    }
    
    private func attribute() {
        view.backgroundColor = .white
    }
    
    private func layout() {
        view.addSubview(scrollView)
        scrollView.addSubview(contentView)
        contentView.addSubview(thumbnailImageView)
        contentView.addSubview(menuInfoView)
        contentView.addSubview(menuSubInfoView)
        contentView.addSubview(amountView)
        
        let safeArea = view.safeAreaLayoutGuide
        NSLayoutConstraint.activate([
            scrollView.leftAnchor.constraint(equalTo: view.leftAnchor),
            scrollView.rightAnchor.constraint(equalTo: view.rightAnchor),
            scrollView.topAnchor.constraint(equalTo: safeArea.topAnchor),
            scrollView.bottomAnchor.constraint(equalTo: safeArea.bottomAnchor),
            
            scrollView.contentLayoutGuide.leftAnchor.constraint(equalTo: view.leftAnchor),
            scrollView.contentLayoutGuide.rightAnchor.constraint(equalTo: view.rightAnchor),
            scrollView.contentLayoutGuide.topAnchor.constraint(equalTo: safeArea.topAnchor),
            
            contentView.leftAnchor.constraint(equalTo: scrollView.leftAnchor),
            contentView.rightAnchor.constraint(equalTo: scrollView.rightAnchor),
            contentView.topAnchor.constraint(equalTo: scrollView.topAnchor),
            
            thumbnailImageView.leftAnchor.constraint(equalTo: contentView.leftAnchor),
            thumbnailImageView.rightAnchor.constraint(equalTo: contentView.rightAnchor),
            thumbnailImageView.topAnchor.constraint(equalTo: contentView.topAnchor),
            thumbnailImageView.heightAnchor.constraint(equalTo: contentView.widthAnchor),
            
            menuInfoView.leftAnchor.constraint(equalTo: contentView.leftAnchor, constant: 16),
            menuInfoView.rightAnchor.constraint(equalTo: contentView.rightAnchor, constant: -16),
            menuInfoView.topAnchor.constraint(equalTo: thumbnailImageView.bottomAnchor, constant: 24),
            
            menuSubInfoView.leftAnchor.constraint(equalTo: contentView.leftAnchor, constant: 16),
            menuSubInfoView.rightAnchor.constraint(equalTo: contentView.rightAnchor, constant: -16),
            menuSubInfoView.topAnchor.constraint(equalTo: menuInfoView.bottomAnchor, constant: 24),
            
            amountView.leftAnchor.constraint(equalTo: contentView.leftAnchor, constant: 16),
            amountView.rightAnchor.constraint(equalTo: contentView.rightAnchor, constant: -16),
            amountView.topAnchor.constraint(equalTo: menuSubInfoView.bottomAnchor, constant: 26),
                        
            contentView.bottomAnchor.constraint(equalTo: amountView.bottomAnchor),
            scrollView.contentLayoutGuide.heightAnchor.constraint(equalTo: contentView.heightAnchor)
        ])
    }
}
