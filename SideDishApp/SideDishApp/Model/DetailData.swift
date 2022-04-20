//
//  DetailData.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation

struct DetailData : Codable {
    let topImage : URL
    let thumbImages : [URL]
    let productDescription : String
    let deliveryInfo : String
    let deliveryFee : String
    let detailSection : [URL]
    private let unCastedPrices : [String]
    private let unCastedPoint : String
     
    enum CodingKeys: String, CodingKey {
           case topImage = "top_image"
           case thumbImages = "thumb_images"
           case productDescription = "product_description"
           case deliveryInfo = "delivery_info"
           case deliveryFee = "delivery_fee"
           case detailSection = "detail_section"
           case unCastedPrices = "prices"
           case unCastedPoint = "point"
    }
    
    var prices : [Money] {
        unCastedPrices.map({Money($0)})
    }
    
    var point : Money {
        Money(unCastedPoint)
    }
    
}
