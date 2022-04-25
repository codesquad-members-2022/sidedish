//
//  ViewController.swift
//  SideDish20
//
//  Created by Beck, Selina on 2022/04/18.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        self.performSegue(withIdentifier: "test", sender: nil)
    }
}
