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
    private let dishCollectionWrapper = DishCollectionWrapper()
    private var productModel: ProductModel?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.title = "order"
        productModel?.delegate = self
        productModel?.getAll()
        view = homeView
        homeView.setCollectionViewModel(viewModel: dishCollectionWrapper)
    }

    static func create(with repository: ProductRepository) -> HomeViewController {
        let viewController = HomeViewController()
        viewController.productModel = ProductModel(repository: repository)
        return viewController
    }
    
    private func presentDetailViewController(){
        guard let repository = productRepository else { return }
        let detailViewController = ProductSceneContainer.makeDetail(repository: repository)
        self.navigationController?.pushViewController(detailViewController, animated: true)
    }
    
}
extension HomeViewController: ProductModelDelegate{
    func updateAllDishes(dishes: [DishCategory : [Product]]) {
        dishCollectionWrapper.setDishes(dishes: dishes)
    }
    
    func updateFail(error: Error) {
        Toast(text: "error \(error)").show()
    }
}
