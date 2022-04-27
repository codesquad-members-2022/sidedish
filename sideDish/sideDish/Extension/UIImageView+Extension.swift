//
//  UIImageView.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/25.
//

import UIKit

extension UIImageView {
    func loadImage(url: URL){
        URLSession(configuration: URLSessionConfiguration.default).dataTask(with: url) { data, _, error in
            guard let data = data else { return }
            let image = UIImage(data: data)
            if let error = error {
                print(error.localizedDescription)
            }
            DispatchQueue.main.async {
                self.image = image ?? UIImage(named: "tempFood")
            }
        }.resume()
    }
}
