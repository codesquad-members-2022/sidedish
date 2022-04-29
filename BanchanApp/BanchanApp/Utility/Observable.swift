//
//  Observable.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/26.
//

import Foundation

final class Observable<T> {
    typealias Subscriber = (T) -> Void

    private var subscriber: Subscriber?

    var value: T {
        didSet {
            self.subscriber?(value)
        }
    }

    init(_ value: T) {
        self.value = value
    }

    func bind(subscriber: @escaping Subscriber) {
        self.subscriber = subscriber
        subscriber(self.value)
    }
}
