//
//  SectionHeaderDelegate.swift
//  SideDishApp
//
//  Created by 박진섭 on 2022/04/19.
//

import Foundation

protocol SectionHeaderViewDelegate: AnyObject {
    func didTapSectionHeader(section: SectionHeaderView, sectionNumber: Int)
}
