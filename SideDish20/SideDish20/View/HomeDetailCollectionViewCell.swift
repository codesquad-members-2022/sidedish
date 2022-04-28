//
//  HomeDetailCollectionViewCell.swift
//  SideDish20
//
//  Created by 백상휘 on 2022/04/28.
//

import UIKit

class HomeDetailCollectionViewCell: UICollectionViewCell {

    @IBOutlet weak var imageView: UIImageView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    func setImage(image: UIImage?) {
        self.imageView.image = image
    }
}
