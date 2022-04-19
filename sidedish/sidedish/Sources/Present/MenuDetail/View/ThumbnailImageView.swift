//
//  ThumbnailImageView.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/19.
//

import UIKit

class ThumbnailImageView: UIView {
    
    
    private let detailScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.translatesAutoresizingMaskIntoConstraints = false
        scrollView.backgroundColor = .red
        return scrollView
    }()
}
