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
        let url = "https://api.codesquad.kr/onban/detail/"
        HTTPManager.requestGet(url: url) { data in
            guard let detailDish: DetailCard = JSONConverter.decodeJsonObject(data: data) else { return }
            
            self.selectedDish = detailDish
            
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: SideDishManager.detailIdentifier), object: self)
        }
    }
    
    func getDishFromSection(indexPath: IndexPath) -> MainCard.Body? {
        var dish: MainCard.Body?
        switch indexPath.section {
        case 0:
            dish = mainDishes?.body[indexPath.item]
        case 1:
            dish = soupDishes?.body[indexPath.item]
        case 2:
            dish = sideDishes?.body[indexPath.item]
        default:
            return nil
        }
        return dish
    }
    
    func getDetailDishFromHash(hash: String) -> DetailCard.Body.DetailCardData? {
        var detailCard: DetailCard.Body.DetailCardData?
        self.selectedDish?.body.forEach{
            if $0.hash == hash {
                detailCard = $0.data
            }
        }
        return detailCard
    }
}
