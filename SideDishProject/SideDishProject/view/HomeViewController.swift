//
//  ViewController.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/18.
//

import UIKit
import Toaster

final class HomeViewController: UIViewController {
    
    private var productModel: HomeUsecase?
    private lazy var homeView = HomeView(frame: view.frame)
    private let dishCollectionDataSource = DishCollectionDataSource()
    private let dishCollectionDelegate = DishCollectionDelegate()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.title = "order"
        productModel?.delegate = self
        productModel?.getAll()
        view = homeView
        homeView.setCollectionViewModel(dataSource: dishCollectionDataSource, delegate: dishCollectionDelegate)
    }

    static func create(with model: HomeUsecase) -> HomeViewController {
        let viewController = HomeViewController()
        viewController.productModel = model
        return viewController
    }
    
    private func presentDetailViewController(uniqueId: UniqueID){
        let detailViewController = ProductSceneContainer.makeViewController(sceneType: .detail(uniqueId: uniqueId))
        self.navigationController?.pushViewController(detailViewController, animated: true)
    }
    
}
extension HomeViewController: ProductModelDelegate{
    func updateDishComment(comments: [String]) {
        dishCollectionDataSource.setDishComments(dishComments: comments)
    }
    
    func updateAllDishes(dishes: [DishCategory : [Product]]) {
        dishCollectionDataSource.setDishes(dishes: dishes)
    }
    
    func updateFail(error: Error) {
        Toast(text: "error \(error)").show()
    }
}
