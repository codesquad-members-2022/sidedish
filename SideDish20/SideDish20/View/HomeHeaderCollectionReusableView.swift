//
//  HomeHeaderCollectionReusableView.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/20.
//

import UIKit

class HomeHeaderCollectionReusableView: UICollectionReusableView {

    static let identifier = "homeHeaderView"
    var headerText: String = "모두가 좋아하는 든든한 메인 요리"

    @IBOutlet weak var homeHeaderLabel: UILabel!

    required override init(frame: CGRect) {
        super.init(frame: frame)
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
}
