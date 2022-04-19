//
//  SecondSectionViewController.swift
//  sidedishApp
//
//  Created by juntaek.oh on 2022/04/19.
//

import UIKit

class SecondSectionViewController: UIViewController{
    private var pointLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}

private extension SecondSectionViewController{
    func configurePointLabel(){
        pointLabel = UILabel()
        pointLabel.frame = CGRect(x: 0, y: 0, width: 60, height: 24)
        pointLabel.textColor = UIColor(red: 0.51, green: 0.51, blue: 0.51, alpha: 1)
        pointLabel.font = UIFont(name: "SFProDisplay-Regular", size: 14)
    }
}
