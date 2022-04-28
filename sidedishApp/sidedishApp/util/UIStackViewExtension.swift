//
//  UIStackViewExtension.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/28.
//

import Foundation
import UIKit

extension UIStackView {
    func clearSubviews() {
        self.arrangedSubviews.forEach { view in
            self.removeArrangedSubview(view)
            view.removeFromSuperview()
        }
    }
}
