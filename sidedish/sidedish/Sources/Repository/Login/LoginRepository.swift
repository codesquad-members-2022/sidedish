//
//  LoginRepository.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Combine
import Foundation
import UIKit

protocol LoginRepository {
    func googleLogin(viewController: UIViewController) -> AnyPublisher<User, Never>
    func getUser() -> AnyPublisher<User, Never>
}
