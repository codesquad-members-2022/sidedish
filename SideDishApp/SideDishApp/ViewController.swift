//
//  ViewController.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/18.
//

import UIKit
import OSLog

class ViewController: UIViewController {
    let networkManger = NetworkManager(session: .shared)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        networkManger.request(endpoint: EndPointCase.get(category: .main).endpoint) { (result: Result<SideDishInfo?, NetworkError>) in
            switch result {
            case .success(let success):
                os_log(.info, "\(success.debugDescription)")
            case .failure(let failure):
                os_log(.error, "\(failure.localizedDescription)")
                
            }
        }
    }
}
