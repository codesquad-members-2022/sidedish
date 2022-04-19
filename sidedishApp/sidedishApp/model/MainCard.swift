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
    private(set) var tagList: [Tag]?
    
    init(detailHash: String, imageURL: String, title: String, description: String, normalPrice: String, salePrice: String?, tagList: [Tag]?) {
        self.detailHash = detailHash
        self.imageURL = imageURL
        self.title = title
        self.description = description
        self.normalPrice = normalPrice
        self.salePrice = salePrice
        self.tagList = tagList
    }
}
