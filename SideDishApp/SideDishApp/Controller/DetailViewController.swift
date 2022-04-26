//
//  DetailViewController.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/20.
//

import UIKit

final class DetailViewController: UIViewController {
    
    private let menu: Menu
    private let detailScrollView = DetailScrollView()
    
    init(menu: Menu) {
        self.menu = menu
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = menu.title
        view.addSubview(detailScrollView)
        configureMenuStackView()
        layoutDetailScrollView()
        
        detailScrollView.overViewImageScrollView.delegate = self
        detailScrollView.countStepper.addTarget(self, action: #selector(stepperValueChanged(_:)), for: .touchUpInside)
    }
    
    private func configureMenuStackView() {
        detailScrollView.mainInfoStackView.setTitle(by: menu.title)
        detailScrollView.mainInfoStackView.setDescription(by: menu.description)
        detailScrollView.mainInfoStackView.setPrice(originPrice: menu.n_price, discountedPrice: menu.s_price)
        detailScrollView.mainInfoStackView.setBadges(by: menu.badge)
    }
    
    func setSubInfo(by menuDetail: MenuDetail) {
        let descriptions = [menuDetail.point, menuDetail.delivery_info, menuDetail.delivery_fee]
        detailScrollView.subInfoStackView.setSubInfoDescription(by: descriptions)
    }
}

// MARK: - View Layout

extension DetailViewController {
    private func layoutDetailScrollView() {
        detailScrollView.translatesAutoresizingMaskIntoConstraints = false
        
        detailScrollView.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        detailScrollView.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
        detailScrollView.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        detailScrollView.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
    }
}

extension DetailViewController: UIScrollViewDelegate {
    func scrollViewDidScroll(_ scrollView: UIScrollView) {
        detailScrollView.imagePageControl.currentPage = Int(scrollView.contentOffset.x / UIScreen.main.bounds.width)
    }
}

// MARK: - Selector Function

extension DetailViewController {
    @objc func stepperValueChanged(_ sender: UIStepper!) {
        detailScrollView.orderCount = Int(sender.value)
    }
}
