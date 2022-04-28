//
//  ViewController.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/18.
//

import UIKit
import Toaster

final class HomeViewController: UIViewController {
    
    private var usecase: HomeUsecase?
    private lazy var homeView = HomeView(frame: view.frame)
    private let dishCollectionDataSource = DishCollectionDataSource()
    private let dishCollectionDelegate = DishCollectionDelegate()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.title = "order"
        usecase?.delegate = self
        usecase?.getAll()
        view = homeView
        dishCollectionDelegate.cellAction = self
        homeView.setCollectionViewModel(dataSource: dishCollectionDataSource, delegate: dishCollectionDelegate)
    }

    static func create(with model: HomeUsecase) -> HomeViewController {
        let viewController = HomeViewController()
        viewController.usecase = model
        return viewController
    }
    
    private func presentDetailViewController(uniqueId: UniqueID){
//        let detailViewController = ProductSceneContainer.makeViewController(sceneType: .detail(uniqueId: uniqueId))
//        self.navigationController?.pushViewController(detailViewController, animated: true)
//
        let detailViewController = DetailViewController()
        self.navigationController?.pushViewController(detailViewController, animated: true)
    }
    
}
extension HomeViewController: ProductModelDelegate{
    func updateImageData(imageData: [DishCategory : [Data?]] ) {
        dishCollectionDataSource.setDishImages(images: imageData)
        homeView.collectionViewReloadData()
    }
    
    func selected(id: UniqueID) {
        presentDetailViewController(uniqueId: id)
    }
    
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

extension HomeViewController: DishCellAction{
    func didTapped(indexPath: IndexPath) {
        usecase?.setSelectedIndex(indexPath: indexPath)
    }
}
