//
//  DetailViewController.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/20.
//

import UIKit

final class DetailViewController: UIViewController{
    private var model: DetailModel?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    static func create(with model: DetailModel) -> DetailViewController {
        let viewController = DetailViewController()
        viewController.model = model
        return viewController
    }
    
}
