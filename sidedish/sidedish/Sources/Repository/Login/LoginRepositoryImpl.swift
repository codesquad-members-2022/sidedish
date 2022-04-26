//
//  LoginRepositoryImpl.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Combine
import FirebaseAuth
import Foundation

class LoginRepositoryImpl: NetworkRepository, LoginRepository {
    func googleLogin(authCredential: AuthCredential) -> AnyPublisher<User, Never> {
        Future<User, Never> { promise in
            Auth.auth().signIn(with: authCredential) { authResult, _ in
                guard let user = authResult?.user else {
                    return
                }
                
                promise(.success(User(user: user)))
            }
        }.eraseToAnyPublisher()
    }
    
    func getUser() -> AnyPublisher<User?, Never> {
        Future<User?, Never> { promise in
            guard let user = Auth.auth().currentUser else {
                promise(.success(nil))
                return
            }
            promise(.success(User(user: user)))
        }.eraseToAnyPublisher()
    }
    
    func signOut() -> AnyPublisher<Void, Never> {
        Future<Void, Never> { promise in
            try? Auth.auth().signOut()
            promise(.success(()))
        }.eraseToAnyPublisher()
    }
}
