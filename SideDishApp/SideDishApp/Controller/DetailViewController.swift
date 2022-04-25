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
    }
    
    private func configureMenuStackView() {
        detailScrollView.menuStackView.setMenuTitle(by: menu.title)
        detailScrollView.menuStackView.setMenuDescription(by: menu.description)
        detailScrollView.menuStackView.setMenuPrice(originPrice: menu.n_price, discountedPrice: menu.s_price)
        detailScrollView.menuStackView.setBadges(by: menu.badge)
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
