//
//  ProductFactory.swift
//  SideDishProject
//
//  Created by 김동준 on 2022/04/19.
//

import Foundation


struct MockProductFactory{
    private let mainDishNames: [String] = ["삼겹살", "김치볶음밥", "제육볶음"]
    private let soupDishNames: [String] = ["김치찌게", "된장찌게", "미역국"]
    private let sideDishNames: [String] = ["멸치볶음", "김", "콩자반"]
    
    private let randomDiscriptions: [String] = ["ebony가 직접 만들었습니다." , "rosa가 직접 만들었습니다.", "구찌가 극찬하였습니다.", "데일이 먹고 울었습니다."]
    private let dishImageURLs: [String] = ["http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg","http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_D1.jpg", "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_D2.jpg", "http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_D3.jpg"]
    private var events: [ProductEvent] = [.eventPrice(disCount: 0.15), .launchingPrice(disCount: 0.2), .none(disCount: 1.0)]
    private let makeCount: Int
    
    init(makeCount: Int){
        self.makeCount = makeCount
    }
    
    func makeRandomProducts() -> [Product] {
        var results: [Product] = []
        for _ in 0 ..< self.makeCount {
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
        let imageUrl = randomImageUrl()
        return Product(name: name, price: price, description: discription, stock: stock, category: category, imageUrl: imageUrl, event: productEvents)
    }
    
    private func randomImageUrl() -> String{
        guard let url = dishImageURLs.randomElement() else { return "" }
        return url
    }
    
    private func randomEvents() -> [ProductEvent]{
        guard let randomEvent = events.randomElement() else { return [] }
        return [randomEvent]
    }
    
    private func randomName(cateogory: DishCategory) -> String{
        switch cateogory.id{
        case 1:
            guard let name = mainDishNames.randomElement() else { return "" }
            return name
        case 2:
            guard let name = soupDishNames.randomElement() else { return "" }
            return name
        case 3:
            guard let name = sideDishNames.randomElement() else { return "" }
            return name
        default:
            return ""
        }
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
    
    private func randomCategory() -> DishCategory {
        let categories = [DishCategory(id: 1, name: "모두가 좋아하는 든든한 메인요리", count: 0), DishCategory(id: 2, name: "정성이 담긴 뜨끈한 국물요리", count: 0), DishCategory(id: 3, name: "식탁을 풍성하게 하는 정갈한 밑반찬", count: 0) ]
        return categories.randomElement()!
    }
    
    private func randomValue(min: Int, max: Int) -> Int{
        return Int.random(in: min...max)
    }
}
