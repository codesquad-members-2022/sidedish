//
//  SideDishManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class SideDishManager {
    
    static let mainIdentifier = "SideDishManager"
    static let detailIdentifier = "SideDishManagerDetailModel"
    
    private(set) var mainDishes: MainCard?
    private(set) var soupDishes: MainCard?
    private(set) var sideDishes: MainCard?
    private(set) var selectedDish: DetailCard?
    
    static let shared = SideDishManager()
    
    private init() {}
    
    func getDishes(type: Dish) {
        let url = "https://api.codesquad.kr/onban/" + type.name
        HTTPManager.requestGet(url: url) { data in
            guard let dishes: MainCard = JSONConverter.decodeJsonObject(data: data) else { return }
            
            switch type {
            case .main:
                self.mainDishes = dishes
            case .soup:
                self.soupDishes = dishes
            case .side:
                self.sideDishes = dishes
            }
            
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: SideDishManager.mainIdentifier), object: self)
        }
    }
    
    func getDetailDish() {
        HTTPManager.requestGet(url: "https://api.codesquad.kr/onban/detail/HBDEF"){ data in
            guard let detailDish: DetailCard = JSONConverter.decodeJsonObject(data: data) else { return }
            
            self.selectedDish = detailDish
            
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: SideDishManager.detailIdentifier), object: self)
        }
    }
}
