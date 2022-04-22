//
//  DetailViewController.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import UIKit

final class DetailViewController: UIViewController{
    private var productRepository: ProductRepository?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    static func create(with repository: ProductRepository) -> DetailViewController {
        let viewController = DetailViewController()
        viewController.productRepository = repository
        return viewController
    }
    
}
