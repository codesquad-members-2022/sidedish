//
//  SectionHeader.swift
//  SideDish
//
//  Created by YEONGJIN JANG on 2022/04/19.
//

import UIKit

class SectionHeader: UICollectionReusableView {

    static let cellId = "homeHeaderView"
    @IBOutlet weak var label: UILabel!

    public func setup() {
        label.text = """
                    모두가 좋아하는
                    든든한 메인 요리
                    """
        label.font = UIFont.init(name: Font.sfRegular, size: 32)
        backgroundColor = .clear
    }

}
