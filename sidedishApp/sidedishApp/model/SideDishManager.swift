//
//  SideDishManager.swift
//  sidedishApp
//
//  Created by Bibi on 2022/04/25.
//

import Foundation

final class SideDishManager {
    
    static let identifier = "SideDishManager"
    
    private(set) var mainDishes: MainCard?
    private(set) var soupDishes = [MainCard]()
    private(set) var sideDishes = [MainCard]()
    
    static let shared = SideDishManager()
    
    private init() {} // shared 싱글톤을 위해 init을 private로 설정
    
    func getMainDishes() {
        HTTPManager.requestGet(url: "https://api.codesquad.kr/onban/main") { data in
            guard let mainDishes: MainCard = JSONConverter.decodeJsonObject(data: data) else { return }
            
            self.mainDishes = mainDishes
            
            NotificationCenter.default.post(name: NSNotification.Name(rawValue: SideDishManager.identifier), object: self)
        }
    }
    
    func getSoupDishes() {
        
    }
    
    func getSideDishes() {
        
    }
}
