//
//  MainCard.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation

struct MainCard {
    private(set) var detailHash: String
    private(set) var imageURL: String
    private(set) var title: String
    private(set) var description: String
    private(set) var normalPrice: String
    private(set) var salePrice: String?
    private(set) var badgeList: [Badge]?
}
