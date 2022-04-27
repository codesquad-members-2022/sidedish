import UIKit

final class DetailViewController: UIViewController{
    
    private var food: Food
    
    init(food: Food){
        self.food = food
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        return nil
    }
    
    override func viewDidLoad() {
        navigationItem.title = food.alt
        view.backgroundColor = .white
    }
}
