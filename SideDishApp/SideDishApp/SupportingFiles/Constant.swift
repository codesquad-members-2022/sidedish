//
//  Constant.swift
//  SideDishApp
//
//  Created by 김상혁 on 2022/04/18.
//

import Foundation

enum Constant {
    
    enum ViewControllerTitle {
        static let ordering = "Ordering"
    }
    
    enum Identifier {
        static let orderingViewCell = "OrderingViewCellIdentifier"
        static let sectionHeaderView = "sectionHeaderViewIdentifier"
    }
    
    enum SubInfoText: String, CaseIterable, CustomStringConvertible {
        case point
        case deliveryInfo
        case deliveryFee
        
        var description: String {
            switch self {
            case .point:
                return "적립금"
            case .deliveryInfo:
                return "배송정보"
            case .deliveryFee:
                return "배송비"
            }
        }
    }
    
    enum DetailScrollText {
        static let count = "수량"
        static let initialCount = "1"
        static let amount = "총 주문금액"
        static let order = "주문하기"
    }
}
