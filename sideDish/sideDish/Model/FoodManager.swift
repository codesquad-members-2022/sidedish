//
//  FoodManager.swift
//  sideDish
//
//  Created by 최예주 on 2022/04/25.
//

import Foundation

class FoodManager{
    
    let category = ["main", "soup", "side"]
    
    var mainFood: [Food]?
    var soupFood: [Food]?
    var sideFood: [Food]?
    
    // API로 요청 -> 실패시 mockup data 로 데이터 가져오도록
    
    init(){
        foodLoadData()
    }
    
    func foodLoadData(){
        mainFood = JsonConvertor.mockLoad(file: "main")
        soupFood = JsonConvertor.mockLoad(file: "soup")
        sideFood = JsonConvertor.mockLoad(file: "side")
    }

}
