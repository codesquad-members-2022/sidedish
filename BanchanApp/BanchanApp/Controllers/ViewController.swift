//
//  ViewController.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/19.
//

import UIKit

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()

        let carousel = CarouselView()
        self.view.addSubview(carousel)
        carousel.anchor(top: self.view.safeAreaLayoutGuide.topAnchor, leading: self.view.safeAreaLayoutGuide.leadingAnchor, trailing: self.view.safeAreaLayoutGuide.trailingAnchor, height: self.view.frame.width)
        carousel.delegate = self
    }
}

extension ViewController: CarouselViewDataSource {
    func carouselView(_ carouselView: CarouselView) -> UIView {
        let image = UIImageView()
        image.image = UIImage(named: "dummy")
        image.contentMode = .scaleAspectFit
        return image
    }

    func carouselView(_ carouselView: CarouselView, numberOfItems: Int) -> Int {
        return 0
    }
}
