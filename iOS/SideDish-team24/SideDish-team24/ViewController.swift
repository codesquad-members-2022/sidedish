import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let dishes = Dishes(type: "국물")
        let dish = Dish(id: "abcd", name: "매운탕", price: 12000, stock: 3, type: "국물")
        dishes.addDish(with: dish)
        print(dishes.count)
    }


}

