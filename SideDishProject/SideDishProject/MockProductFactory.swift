//
//  ProductFactory.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import Foundation


struct MockProductFactory{
    private let randomNames: [DishCategory : [String]]  = [.main : ["삼겹살", "김치볶음밥", "제육볶음"], .soup : ["김치찌게", "된장찌게", "미역국"], .side : ["멸치볶음", "김", "콩자반"]]
    private let randomDiscriptions: [String] = ["ebony가 직접 만들었습니다." , "rosa가 직접 만들었습니다.", "구찌가 극찬하였습니다.", "데일이 먹고 울었습니다."]
    private var events: [ProductEvent] = [.eventPrice(disCount: 0.15), .launchingPrice(disCount: 0.2), .none(disCount: 1.0)]
    func makeRandomProducts(count: Int) -> [Product] {
        var results: [Product] = []
        for _ in 0 ..< count {
            results.append(makeRandomProduct())
        }
        return results
    }
    
    
    private func makeRandomProduct() -> Product {
        let category = randomCategory()
        let price = randomPrice()
        let discription = randomDiscription()
        let stock = randomStock()
        let name = randomName(cateogory: category)
        let productEvents = randomEvents()
        return Product(name: name, price: price, description: discription, stock: stock, category: category, event: productEvents)
    }
    
    private func randomEvents() -> [ProductEvent]{
        guard let randomEvent = events.randomElement() else { return [] }
        return [randomEvent]
    }
    
    private func randomName(cateogory: DishCategory) -> String{
        guard let name = randomNames[cateogory]?.randomElement() else { return "" }
        return String(name)
    }
    
    private func randomPrice() -> Int{
        return randomValue(min: 5000, max: 20000)
    }
    
    private func randomDiscription() -> String{
        guard let discription = randomDiscriptions.randomElement() else { return "" }
        return discription
    }
    
    private func randomStock() -> Int{
        return randomValue(min: 0, max: 10)
    }
    
    private func randomCategory() -> DishCategory{
        guard let category = DishCategory.allCases.randomElement() else { return .side }
        return category
    }
    
    private func randomValue(min: Int, max: Int) -> Int{
        return Int.random(in: min...max)
    }
}
