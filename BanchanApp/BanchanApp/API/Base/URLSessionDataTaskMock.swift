//
//  URLSessionDataTaskMock.swift
//  BanchanApp
//
//  Created by 송태환 on 2022/04/28.
//

import Foundation

class URLSessionDataTaskMock: URLSessionDataTask {
    private let closure: () -> Void

    init(closure: @escaping () -> Void) {
        self.closure = closure
        super.init()
    }

    override func resume() {
        self.closure()
    }
}
