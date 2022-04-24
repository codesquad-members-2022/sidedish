//
//  ViewController.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/18.
//

import UIKit
import Toast_Swift

class MainViewController: UIViewController {

    private var mainCollectionView: MainCollectionView!

    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Ordering"
        let navigationBar = navigationController?.navigationBar
        let navigationBarAppearance = UINavigationBarAppearance()
        navigationBarAppearance.shadowColor = .black
        navigationBar?.scrollEdgeAppearance = navigationBarAppearance
    }

}
