//
//  ClientCard.swift
//  TodoList
//
//  Created by seongha shin on 2022/04/09.
//

import Foundation

struct ClientCard: Encodable {
    let id: Int
    let title: String
    let content: String
    let authorSystem: String
}
