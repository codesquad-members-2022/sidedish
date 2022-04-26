//
//  EndPointFactory.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/26.
//

import Foundation

enum EndpointFactory {
   static func make(categoryType: CategoryType) -> CategoryEndpoint {
       CategoryEndpoint(from: categoryType)
   }

   static func make(imageURL: URL) -> ImageEndPoint {
       return ImageEndPoint(url: imageURL)
   }

    static func make(detailHash: String) -> ProductDetailEndPoint {
        return ProductDetailEndPoint(from: detailHash)
    }
}
