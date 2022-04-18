//
//  UIConrtol+Extension.swift
//  Signup
//
//  Created by seongha shin on 2022/03/31.
//

import Combine
import UIKit

extension UIControl {
    struct EventPublisher<T>: Publisher {
        typealias Output = T
        typealias Failure = Never
        
        let control: UIControl
        let event: Event
        let receiveClosure: () -> T
        
        func receive<S>(subscriber: S) where S: Subscriber, Never == S.Failure, T == S.Input {
            control.addAction(UIAction { _ in
                subscriber.receive(receiveClosure())
            }, for: event)
        }
    }
}
extension UIControl {
    func publisher(for event: Event) -> AnyPublisher<Void, Never> {
        EventPublisher<Void>(control: self, event: event, receiveClosure: {
        }).eraseToAnyPublisher()
    }
}
