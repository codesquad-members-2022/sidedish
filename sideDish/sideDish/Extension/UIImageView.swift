//
//  UIImageView.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/25.
//

import UIKit

extension UIImageView {
    func load(url: URL) {
        DispatchQueue.global().async {
            [weak self] in if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async { self?.image = image }
                }
            }
        }
    }
}
