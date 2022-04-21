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
    private lazy var homeView = HomeView(frame: view.frame)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.title = "order"
        view = homeView
    }

    static func create(with repository: ProductRepository) -> HomeViewController {
        let viewController = HomeViewController()
        viewController.productRepository = repository
        return viewController
    }
    
    private func presentDetailViewController(){
        guard let repository = productRepository else { return }
        let detailViewController = ProductSceneContainer.makeDetail(repository: repository)
        self.navigationController?.pushViewController(detailViewController, animated: true)
    }
    
}
