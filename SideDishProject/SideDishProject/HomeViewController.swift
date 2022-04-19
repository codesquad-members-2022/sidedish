//
//  ViewController.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/18.
//

import UIKit
import Toaster

class HomeViewController: UIViewController {

    private var productRepository: ProductRepository?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .yellow
    }

    static func create(with repository: ProductRepository) -> HomeViewController {
        let viewController = HomeViewController()
        viewController.productRepository = repository
        return viewController
    }
}
