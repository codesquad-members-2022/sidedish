//
//  HomeHeaderView.swift
//  SideDish20
//
//  Created by 안상희 on 2022/04/19.
//

import UIKit

class HomeHeaderView: UIView {

    var headerText: String = ""
    @IBOutlet weak var headerLabel: UILabel!
    required override init(frame: CGRect) {
        super.init(frame: frame)
        headerLabel.text = headerText
    }
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        headerLabel.text = headerText
    }
}
