//
//  SideDishManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class SideDishManager {
    
    static let mainIdentifier = "SideDishManager"
    static let detailIdentifier = "SideDishManagerDetail"
    static let downloadIdentifier = "SideDishManagerDownload"
    
    private(set) var mainDishes: MainCard?
    private(set) var soupDishes: MainCard?
    private(set) var sideDishes: MainCard?
    private(set) var selectedDish: DetailCard?
    private(set) var imageUrlList = [(String, URL)]() // hash, imageURL
    private(set) var dataDictionary = [String: Data]() // hash, imageData
    private(set) var detailImageThumbnail = [Data]()
    
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
    
    func getDishCountFromSection(indexPath: IndexPath) -> Int? {
        var dishCount: Int?
        switch indexPath.section {
        case 0:
            dishCount = mainDishes?.body.count
        case 1:
            dishCount = soupDishes?.body.count
        case 2:
            dishCount = sideDishes?.body.count
        default:
            return nil
        }
        return dishCount
    }
    
    func getMainDishImages() {
        
        getMainDishImageURLFromHash()
        
        for (hash, url) in imageUrlList {
            ImageManager.loadData(url: url) { (data, error) in
                if let data = data {
                    self.dataDictionary[hash] = data
                }
                NotificationCenter.default.post(name: NSNotification.Name(rawValue: SideDishManager.downloadIdentifier), object: self)
            }
        }
    }
    
    private func getMainDishImageURLFromHash() {
        guard let mainDishesBody = mainDishes?.body,
              let soupDishesBody = soupDishes?.body,
              let sideDishesBody = sideDishes?.body else {
            return
        }
        
        mainDishesBody.forEach {
            guard let url = URL(string: $0.imageURL) else { return }
            imageUrlList.append(($0.detailHash, url))
        }
        
        soupDishesBody.forEach {
            guard let url = URL(string: $0.imageURL) else { return }
            imageUrlList.append(($0.detailHash, url))
        }
        
        sideDishesBody.forEach {
            guard let url = URL(string: $0.imageURL) else { return }
            imageUrlList.append(($0.detailHash, url))
        }
    }
    
    func getDetailDishImages(dish: DetailCard.Body.DetailCardData) {
        
        for urlString in dish.thumbImages {
            guard let url = URL(string: urlString) else { return }
            
            ImageManager.loadData(url: url) { (data, error) in
                guard let data = data else { return }

                self.detailImageThumbnail.append(data)
                NotificationCenter.default.post(name: NSNotification.Name(rawValue: "detail"), object: self)
            }
        }
    }
    
    func clearDetailImageThumbnail() {
        detailImageThumbnail = [Data]()
    }
}
