//
//  UIImage+Extension.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/25.
//

import UIKit

extension UIImage {
    static let placeholder = UIImage(systemName: "cart.circle") ?? UIImage()

    func getAspectRatio() -> Double? {
        let width = Double(self.size.width)
        let height = Double(self.size.height)

        guard width > 0, height > 0 else {
            return nil
        }

        return width / height
    }

}
