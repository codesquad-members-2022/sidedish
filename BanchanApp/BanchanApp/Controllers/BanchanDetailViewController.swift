//
//  BanchanDetailViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

class BanchanDetailViewController: UIViewController {
    @IBOutlet weak var orderButton: UIButton!
    @IBOutlet weak var quantityLabel: UILabel!
    @IBOutlet weak var quantityStepper: UIStepper!

    override func viewDidLoad() {
        super.viewDidLoad()
        self.configureUI()
    }

    private func configureUI() {
        
    }
}
