//
//  SectionHeader.swift
//  SideDish
//
//  Created by YEONGJIN JANG on 2022/04/19.
//

import UIKit

class SectionHeader: UICollectionReusableView {

    static let cellId = "homeHeaderView"
    static let labelHeight: CGFloat = 96
    @IBOutlet weak var label: UILabel!

    public func setup(at index: Int) {
        switch index {
        case 0:
            label.text = """
                    모두가 좋아하는
                    든든한 메인 요리
                    """
        case 1:
            label.text = """
                    정성이 담긴
                    뜨끈뜨끈 국물 요리
                    """
        case 2:
            label.text = """
                    식탁을 풍성하게 하는
                    정갈한 밑반찬
                    """
        default:
            assert(false, "range out of index")
        }
        label.font = UIFont.init(name: Font.sfRegular, size: 32)
        backgroundColor = .clear
    }

}
