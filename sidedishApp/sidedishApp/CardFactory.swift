//
//  CardFactory.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/19.
//

import Foundation

class CardFactory {
    
    func createMainCard(detailHash: String, imageURL: String, title: String, description: String, normalPrice: String, salePrice: String?, tagList: [Tag]?) -> MainCard {
        return MainCard(detailHash: detailHash, imageURL: imageURL, title: title, description: description, normalPrice: normalPrice, salePrice: salePrice, tagList: tagList)
    }
}
