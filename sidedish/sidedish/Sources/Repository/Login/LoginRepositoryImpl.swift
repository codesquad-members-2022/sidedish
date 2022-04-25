//
//  LoginRepositoryImpl.swift
//  sidedish
//
//  Created by seongha shin on 2022/04/25.
//

import Combine
import FirebaseAuth
import FirebaseCore
import Foundation
import GoogleSignIn

class LoginRepositoryImpl: NetworkRepository, LoginRepository {
    func googleLogin(viewController: UIViewController) -> AnyPublisher<User, Never> {
        Future<User, Never> { promise in
            guard let clientId = FirebaseApp.app()?.options.clientID else { return }
            let config = GIDConfiguration(clientID: clientId)
            GIDSignIn.sharedInstance.signIn(with: config, presenting: viewController) { user, _ in
                guard let authentication = user?.authentication,
                      let idToken = authentication.idToken else {
                    return
                }

                let credential = GoogleAuthProvider.credential(withIDToken: idToken, accessToken: authentication.accessToken)
                Auth.auth().signIn(with: credential) { authResult, _ in
                    guard let user = authResult?.user else {
                        return
                    }
                    
                    promise(.success(User(user: user)))
                }
            }
        }.eraseToAnyPublisher()
    }
    
    func getUser() -> AnyPublisher<Void, Never> {
        Future<Void, Never> { promise in
//            try? Auth.auth().signOut()
            if Auth.auth().currentUser == nil {
                return
            }
            promise(.success(()))
        }.eraseToAnyPublisher()
    }
}
