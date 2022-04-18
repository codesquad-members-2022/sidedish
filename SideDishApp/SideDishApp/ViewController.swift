//
//  ViewController.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/18.
//

import UIKit
import Toast_Swift

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.view.makeToast("Hello")
        print("HI")
    }


}

