import UIKit

final class DetailViewController: UIViewController{
    
    private var foodDetail: FoodDetail
    private var foodTitle: String = ""
    
    init(foodDetail: FoodDetail, foodTitle: String){
        self.foodDetail = foodDetail
        self.foodTitle = foodTitle
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        return nil
    }
    
    override func viewDidLoad() {
        navigationItem.title = foodTitle
        view.backgroundColor = .white
    }
}
