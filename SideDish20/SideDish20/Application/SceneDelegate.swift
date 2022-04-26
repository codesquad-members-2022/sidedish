import UIKit

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        let storyboard = UIStoryboard(name: "Home", bundle: nil)
        let instantViewController = storyboard.instantiateViewController(withIdentifier: String(describing: HomeNavigationController.self))
        
        guard let homeViewController = instantViewController as? HomeNavigationController else {
            return
        }
        
        self.window?.rootViewController = homeViewController
    }
}

