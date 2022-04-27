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
    
    enum SectionHeaderText {
        static let main = "모두가 좋아하는 든든한 메인 요리"
        static let soup = "정성이 담긴 뜨끈뜨끈 국물 요리"
        static let side = "식탁을 풍성하게 하는 정갈한 밑반찬"
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
