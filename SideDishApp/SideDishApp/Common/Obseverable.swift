//
//  Obseverable.swift
//  SideDishApp
//
//  Created by Kai Kim on 2022/04/20.
//

import Foundation

final class Observable <T> {

    typealias Listener = (T) -> Void

    var listener: Listener?

    var value: T {
        didSet {
            listener?(value)
        }
    }

    init(_ value: T) {
        self.value = value
    }

    func bind(listener: Listener?) {
        self.listener = listener
        listener?(value)
    }

}
