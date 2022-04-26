//
//  OrderViewModel.swift
//  SideDishApp
//
//  Created by Bumgeun Song on 2022/04/26.
//

import Foundation

struct OrderInfoViewModel {
    public let amount = Observable<Int>(1)
    public let totalPrice = Observable<Money<KRW>>(Money<KRW>(""))

    func order() {
        // 주문 로직
    }

    func incrementAmount() {
        amount.value = amount.value ?? 0 + 1
    }

    func minusAmount() {
        amount.value = amount.value ?? 0 - 1
    }
}
