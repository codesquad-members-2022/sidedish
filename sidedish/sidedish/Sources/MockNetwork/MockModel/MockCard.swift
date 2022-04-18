//
//  MockCard.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/09.
//

import Foundation

//Server Model
class MockCard: Decodable {
//    let id: Int
//    public private(set) var title: String
//    public private(set) var content: String
//    let author_system: String
//    public private(set) var column_name: MockColumnType
//    public private(set) var order_id: Int
//
//    var description: String {
//        "id: \(id), order_id: \(order_id), "
//    }
//
//    static func == (lhs: MockCard, rhs: MockCard) -> Bool {
//        lhs.id == rhs.id
//    }
//
//    init(id: Int, title: String, content: String, author_system: String, column_name: MockColumnType, order_id: Int) {
//        self.id = id
//        self.title = title
//        self.content = content
//        self.author_system = author_system
//        self.column_name = column_name
//        self.order_id = order_id
//    }
//
//    func changeColumn(_ column: MockColumnType) {
//        column_name = column
//    }
//
//    func changeOrderId(_ id: Int) {
//        order_id = id
//    }
//
//    func changeTitle(_ title: String) {
//        self.title = title
//    }
//
//    func changeContent(_ content: String) {
//        self.content = content
//    }
//
//    func toClientData() -> ClientCard {
//        ClientCard(id: id, title: title, content: content, authorSystem: author_system)
//    }
}
//
//enum MockColumnType: String, CaseIterable, Codable {
//    case to_do, in_progress, done
//}
