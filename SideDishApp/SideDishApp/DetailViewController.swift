//
//  DetailViewController.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/20.
//

import UIKit

final class DetailViewController: UIViewController {
    
    private var menu: Menu
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .systemBackground
        self.title = menu.title
    }
    
    init(menu: Menu) {
        self.menu = menu
        super.init(nibName: nil, bundle: nil)
    }
    
    @available(*, unavailable) required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
